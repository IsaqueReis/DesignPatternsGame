package model.designpatterns.observer;

import model.utils.Utils;

import java.util.Observable;
import java.util.Observer;

public class Enemy implements Observer 
{
    private int x;
    private int y;
    private int outCoordX;
    private int outCoordY;
    private double hp;
    private boolean status;
    private boolean changePhase;
    private String name;
    private static double DEFAULT_ATTACK = 15;
    private static double playerAttack = 0.0;

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

    public int getOutCoordX()
    {
        return this.outCoordX;
    }

    public void setOutCoordX(int x)
    {
        this.outCoordX = x;
    }

    public int getOutCoordY()
    {
        return this.outCoordY;
    }

    public void setOutCoordY(int y)
    {
        this.outCoordY = y;
    }

    public double getHP()
    {
        return this.hp;
    }

    public void setHP(double hp)
    {
        this.hp = hp;
    }

    public boolean getStatus()
    {
        return this.status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public boolean getChangePhase()
    {
        return this.changePhase;
    }

    public void setChangePhase(boolean status)
    {
        this.changePhase = status;
    }

    public String getName() {return this.name;}

    public Enemy(int x, int y, int oX, int oY, String name)
    {
        setX(x);
        setY(y);
        setOutCoordX(oX);
        setOutCoordY(oY);
        setHP(100);
        setStatus(true);
        setChangePhase(true);
        this.name = name;
    }

    public void update(Observable subject, Object arg)
    {
        Player mainCharacter = (Player)subject;         //observando o personagem principal
        playerAttack = mainCharacter.getCharacter().getAttack().getAttackWeight();

        if(getHP() <= 0)
        {
            setStatus(false);
            //subject.deleteObserver(this);
        }


        if((mainCharacter.getX() > this.getX() - 25 && mainCharacter.getX() < this.getX() + 25) &&
                (mainCharacter.getY() > this.getY() - 25 && mainCharacter.getY() < this.getY() + 25))
        {
            //decreasing hp
            //efetudando o ataque
            //rolamos um d6 e quem tirar o maior numero ataca primeiro
            //1 - inimigo ganha 2-player ganha
            switch(Utils.playDices())
            {
                case 2 :
                {
                    System.out.println("O personagem ataca primeiro! O ataque do personagem é de: [" + playerAttack + "]!");
                    this.setHP(this.getHP() - playerAttack);
                    break;
                }

                default :
                {
                    System.out.println("O inimigo ataca primeiro! O ataque do inimigo é de: [" + DEFAULT_ATTACK + "]!");
                    if(mainCharacter.getCharacter().getShield() != null)
                        mainCharacter.getCharacter().getShield().recieveAttack(mainCharacter.getCharacter(), DEFAULT_ATTACK);
                    else
                        mainCharacter.getCharacter().getLifeState().decreaseHP(DEFAULT_ATTACK);
                    break;
                }

            }

        } else {

            //moving horizontaly
            if(mainCharacter.getX() > this.getX())
                this.setX(this.getX() + (int)(10 * Math.random()));
            else 
                this.setX(this.getX() - (int)(10 * Math.random()));
            //moving verticaly
            if(mainCharacter.getY() > this.getY())
                this.setY(this.getY() + (int)(10 * Math.random()));
            else 
                this.setY(this.getY() - (int)(10 * Math.random()));
        }

        if((mainCharacter.getX() > this.getOutCoordX() - 50 && mainCharacter.getX() < this.getOutCoordX() + 50) &&
                (mainCharacter.getY() > this.getOutCoordY() - 50 && mainCharacter.getY() < this.getOutCoordY() + 50))
        {
            System.out.println("Trocando de fase...");
            setChangePhase(false);
        }

        if (mainCharacter.getX() < 0) mainCharacter.setX(100);
        if (mainCharacter.getY() < 0) mainCharacter.setY(100);
        if (mainCharacter.getX() > 1000) mainCharacter.setX(950);
        if (mainCharacter.getY() > 600) mainCharacter.setY(500);

        if (this.getX() < 0)  this.setX(100);
        if (this.getY() < 0)  this.setY(100);
        if (this.getX() > 1000) this.setX(950);
        if (this.getY() > 600) this.setY(500);

    }


}