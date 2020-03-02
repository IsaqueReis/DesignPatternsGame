package model.designpatterns.observer;

import model.designpatterns.command.Controler;
import model.designpatterns.command.ControlerFactory;
import model.designpatterns.composite.Phase;
import model.character.Character;
import model.utils.Utils;

import java.util.Observable;

public class Player extends Observable implements Runnable
{
    private int x;
    private int y;
    private Character ch;
    Phase currentPhase;
    private ControlerFactory cf;
    private Controler control;

    public int getX() 
    {
        return this.x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY() 
    {
        return this.y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public Character getCharacter()
    {
        return this.ch;
    }

    public void setCharacter(Character c)
    {
        this.ch = c;
        cf = new ControlerFactory();
        control = cf.getInvoker(this.ch);
    }

    public Phase getPhase()
    {
        return this.currentPhase;
    }

    public void setPhase(Phase cp)
    {
        this.currentPhase = cp;
    }

    public Player(int x, int y, Character c, Phase cp)
    {
        setX(x);
        setY(y);
        setCharacter(c);
        setPhase(cp);
    }

    public void setPosition(int x, int y)
    {
        setX(x);
        setY(y);
        System.out.println("o jogador esta em [" + this.x + "," + this.y + "]");
    }
    
    public void show() 
    {
        setChanged();
        notifyObservers();
    }

    @Override
    public void run() {
        //ten steps
        for(int i = 0; i < 10; i++)
        {
            switch(Utils.getRandomIntegerBetweenRange(1, 4))
            {
                case 1 : setY(getY() - Utils.getRandomIntegerBetweenRange(1, 13)); control.keyPressed(4); break;
                case 2 : setX(getX() + Utils.getRandomIntegerBetweenRange(1, 13)); control.keyPressed(7); break;
                case 3 : setY(getY() + Utils.getRandomIntegerBetweenRange(1, 13)); control.keyPressed(5); break;
                case 4 : setX(getX() - Utils.getRandomIntegerBetweenRange(1, 13)); control.keyPressed(6); break;
            }
        }
    }
}