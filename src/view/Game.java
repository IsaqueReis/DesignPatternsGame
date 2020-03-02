package view;

import model.character.Character;
import model.designpatterns.command.Controler;
import model.designpatterns.command.ControlerFactory;
import model.designpatterns.composite.Abyss;
import model.designpatterns.composite.Exit;
import model.designpatterns.composite.Phase;
import model.designpatterns.composite.Room;
import model.designpatterns.factory.FactoryMethod;
import model.designpatterns.factory.GeneratePhase;
import model.designpatterns.factory.PhaseFactory;
import model.designpatterns.factory.RandomSpecialPersonagemFactory;
import model.designpatterns.observer.*;
import model.utils.Utils;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Game extends JPanel
{
    private Thread t;
    private ArrayList<Player> players = new ArrayList<Player>();
    private JTextArea consoleOutput;
    private JScrollPane scrollPane;
    private FactoryMethod factory;
    private ArrayList<ObservableShield> s = new ArrayList<ObservableShield>();
    private ControlerFactory cf;
    private ArrayList<Controler> controls = new ArrayList<Controler>();

    public Game()
    {

        KeyListener listener = new MyKeyListener();

        addKeyListener(listener);
        setFocusable(true);
    }

    public void play(Game g) throws InterruptedException
    {
        JFrame frame = new JFrame("Design Patterns Game");
        g.setLayout(null);

        consoleOutput = new JTextArea(5,80);
        consoleOutput.setFocusable(false);
        scrollPane = new JScrollPane(consoleOutput);
        frame.add(g, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //main character is ryu
        Character ryu = RandomSpecialPersonagemFactory.createCharacter("ryu");
        Character ken = RandomSpecialPersonagemFactory.createCharacter("ken");
        Character blanka = RandomSpecialPersonagemFactory.createCharacter("blanka");

        consoleOutput.append("----Adicionando uma decoração ao ataque----\n");
        consoleOutput.append("Ataque do personagem: [ " + ryu.getAttack().getAttackWeight() + "]\n");
        consoleOutput.append("Numero de escudos do personagem: " + ryu.getNumOfShields() + ".\n");

        FactoryMethod factory = GeneratePhase.getInstance();
        Phase phase = factory.createPhase(-1);

        s.add(new ObservableShield(Utils.getRandomIntegerBetweenRange(300, 800),
            Utils.getRandomIntegerBetweenRange(300, 600)));
        s.add(new ObservableShield(Utils.getRandomIntegerBetweenRange(300, 800),
            Utils.getRandomIntegerBetweenRange(300, 600)));
        s.add(new ObservableShield(Utils.getRandomIntegerBetweenRange(300, 800),
            Utils.getRandomIntegerBetweenRange(300, 600)));
        s.add(new ObservableShield(Utils.getRandomIntegerBetweenRange(300, 800),
            Utils.getRandomIntegerBetweenRange(300, 600)));

        players.add(new Player(150, 150, ryu, phase));
        players.add(new Player(400, 230, ken, phase));
        players.add(new Player(230, 50, blanka, phase));

        cf = new ControlerFactory();

        for(int i = 0; i < players.size(); i++)
            controls.add(cf.getInvoker(players.get(i).getCharacter()));

        for(int i = 0; i < players.size(); i++)
        {
            players.get(i).getPhase().play(players.get(i));
            consoleOutput.append(String.format("Tipo de composite: %s - Boss: %s\n", players.get(i).getPhase().typeOfRoom(),
                    players.get(i).getPhase().getBoss().getName()));
            players.get(i).addObserver(players.get(i).getPhase().getBoss());
            players.get(i).addObserver(s.get(0));
            players.get(i).addObserver(s.get(1));
            players.get(i).addObserver(s.get(2));
            players.get(i).addObserver(s.get(3));
        }

        while(true)
        {
            for(int i = 0; i < players.size(); i++)
            {
                if(players.get(i).getPhase().getBoss().getChangePhase() == false)
                {
                    players.get(i).deleteObserver(players.get(i).getPhase().getBoss());
                    players.get(i).getPhase().getBoss().setStatus(false);
                    players.get(i).getPhase().play(players.get(i));

                    if(players.get(i).getPhase().typeOfRoom().equals("saida") || players.get(i).getPhase().typeOfRoom().equals("abismo"))
                    {
                        System.out.println(players.get(i).getCharacter().getName() +
                                " Você chegou a saida do jogo! Parabens!");
                        consoleOutput.append(players.get(i).getCharacter().getName() +
                                "Você chegou a saida do jogo! Parabens!\n");
                        consoleOutput.setCaretPosition(consoleOutput.getDocument().getLength());
                        Thread.sleep(100000000);
                        System.exit(0);
                    }


                    consoleOutput.append(String.format("Tipo de composite: %s - Boss: %s\n", players.get(i).getPhase().typeOfRoom(), players.get(i).getPhase().getBoss().getName()));
                    consoleOutput.setCaretPosition(consoleOutput.getDocument().getLength());
                    players.get(i).addObserver(players.get(i).getPhase().getBoss());
                    players.get(i).getPhase().getBoss().setChangePhase(true);
                }

                if(players.get(i).getCharacter().getLifeState().toString().equals("morto"))
                {
                    System.out.println("Você morreu batalhando!");
                    consoleOutput.append("Você morreu batalhando!\n");
                    consoleOutput.setCaretPosition(consoleOutput.getDocument().getLength());
                    Thread.sleep(100000000);
                    System.exit(0);
                }

                if(players.get(i).getPhase().getBoss().getHP() <= 0)
                {
                    players.get(i).getPhase().getBoss().setChangePhase(false);
                }

                t = new Thread(players.get(i));
                t.run();
                players.get(i).show();
                Thread.sleep(50);
                g.repaint();
            }
        }
    }

    public void paint(Graphics g)
    {
        super.paint(g); //cleans screen

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.RED);
        g2d.fillOval(players.get(0).getX(), players.get(0).getY(), 25, 25);

        g2d.setColor(Color.BLUE);
        g2d.fillOval(players.get(1).getX(), players.get(1).getY(), 25, 25);

        g2d.setColor(Color.MAGENTA);
        g2d.fillOval(players.get(2).getX(), players.get(2).getY(), 25, 25);


        g2d.setColor(Color.GREEN);
        g2d.setFont(new Font("Serif", Font.BOLD, 24));
        g2d.drawString("SAIDA", players.get(0).getPhase().getBoss().getOutCoordX(), players.get(0).getPhase().getBoss().getOutCoordY());

        if(players.get(0).getPhase().getBoss().getStatus())
        {
            g2d.setColor(Color.BLACK);
            g2d.fillOval(players.get(0).getPhase().getBoss().getX(), players.get(0).getPhase().getBoss().getY(), 25, 25);

            g2d.drawRect(players.get(0).getPhase().getBoss().getX() - 40, players.get(0).getPhase().getBoss().getY() - 15, (int) players.get(0).getPhase().getBoss().getHP(), 10);
            g2d.setColor(Color.RED);
            g2d.fillRect(players.get(0).getPhase().getBoss().getX()  - 40, players.get(0).getPhase().getBoss().getY() - 15, (int) players.get(0).getPhase().getBoss().getHP(), 10);
        }

        g2d.setColor(Color.BLACK);
        g2d.drawRect(0, 0, 100, 25);
        g2d.setColor(Color.RED);
        g2d.fillRect(0, 0, (int) players.get(0).getCharacter().getHP(), 25);

        if(s.get(0).getStatus())
        {
            g2d.setColor(Color.BLUE);
            g2d.fillOval(s.get(0).getX(), s.get(0).getY(), 15, 15);
        }

        if(s.get(1).getStatus())
        {
            g2d.setColor(Color.BLUE);
            g2d.fillOval(s.get(1).getX(), s.get(1).getY(), 15, 15);
        }

        if(s.get(2).getStatus())
        {
            g2d.setColor(Color.BLUE);
            g2d.fillOval(s.get(2).getX(), s.get(2).getX(), 15, 15);
        }

        if(s.get(3).getStatus())
        {
            g2d.setColor(Color.BLUE);
            g2d.fillOval(s.get(3).getX(), s.get(3).getX(), 15, 15);
        }

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Serif", Font.PLAIN, 16));
        g2d.drawString(String.format("HP: %.2f", players.get(0).getCharacter().getHP()) , 0, 50);

        g2d.setFont(new Font("Serif", Font.BOLD, 16));
        if(players.get(0).getCharacter().getLifeState().toString().equals("forte"))
        {
            g2d.setColor(new Color(11,120, 20));
            g2d.drawString("Estado: FORTE", 0, 70);
        } else if(players.get(0).getCharacter().getLifeState().toString().equals("normal"))
        {
            g2d.setColor(new Color(212,191,6));
            g2d.drawString("Estado: NORMAL", 0, 70);
        } else if(players.get(0).getCharacter().getLifeState().toString().equals("perigo"))
        {
            g2d.setColor(Color.RED);
            g2d.drawString("Estado: PERIGO", 0, 70);
        } else {
            g2d.setColor(Color.BLACK);
            g2d.drawString("Estado: MORTO", 0, 70);
        }

        if(players.get(0).getCharacter().haveShields())
        {
            g2d.setColor(Color.BLUE);
            g2d.drawString("O JOGADOR TEM UMA CADEIA DE ESCUDOS", 0, 90);
        } else {
            g2d.setColor(Color.orange);
            g2d.drawString("O JOGADOR NÃO TEM UMA CADEIA DE ESCUDOS", 0, 90);
        }
    }

    public class MyKeyListener implements KeyListener 
    {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
            if( !(players.get(0).getCharacter().getLifeState().toString().equals("morto")) )
            {
                if (e.getKeyCode() == KeyEvent.VK_LEFT)
                {
                    players.get(0).setX(players.get(0).getX() - 13);
                    controls.get(0).keyPressed(6);
                }


                if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                {
                    players.get(0).setX(players.get(0).getX() + 13);
                    controls.get(0).keyPressed(7);
                }


                if (e.getKeyCode() == KeyEvent.VK_UP)
                {
                    players.get(0).setY(players.get(0).getY() - 13);
                    controls.get(0).keyPressed(4);
                }


                if (e.getKeyCode() == KeyEvent.VK_DOWN)
                {
                    players.get(0).setY(players.get(0).getY() + 13);
                    controls.get(0).keyPressed(5);
                }

                if (e.getKeyCode() == KeyEvent.VK_SPACE)
                {
                    controls.get(0).keyPressed(2);
                }

                if (e.getKeyCode() == KeyEvent.VK_V)
                {
                    players.get(0).setY(players.get(0).getY() + 25);
                    players.get(0).setY(players.get(0).getX() + 25);
                    controls.get(0).keyPressed(1);
                }

                if (e.getKeyCode() == KeyEvent.VK_Z)
                {
                    controls.get(0).keyPressed(0);
                }

                if (e.getKeyCode() == KeyEvent.VK_1)
                {
                    controls.get(0).keyPressed(8);
                }

                if (e.getKeyCode() == KeyEvent.VK_2)
                {
                    controls.get(0).keyPressed(9);
                }

            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            //System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        }
    }  
}