package model.designpatterns.observer;

import model.designpatterns.chainofresponsability.MarvelousShield;

import java.util.Observable;
import java.util.Observer;

public class ObservableShield implements Observer
{
    private int x;
    private int y;
    private boolean status;

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

    public boolean getStatus()
    {
        return this.status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public ObservableShield(int x, int y)
    {
        setX(x);
        setY(y);
        setStatus(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        Player mainCharacter = (Player) o;
        if((mainCharacter.getX() > this.getX() - 50 && mainCharacter.getX() < this.getX() + 50) &&
                (mainCharacter.getY() > this.getY() - 50 && mainCharacter.getY() < this.getY() + 50))
        {
            System.out.println("Escudo coletado!");
            mainCharacter.getCharacter().insertShield(new MarvelousShield());
            mainCharacter.deleteObserver(this);
            setStatus(false);
        }
    }
}
