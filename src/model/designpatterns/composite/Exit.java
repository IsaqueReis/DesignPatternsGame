package model.designpatterns.composite;

import model.designpatterns.observer.*;

public class Exit implements Phase {
    private int x, y;

    public Exit(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public void setY(int y) { this.y = y; }

    @Override
    public String typeOfRoom() {
        return "saida";
    }

    @Override
    public Enemy getBoss() {
        return null;
    }

    @Override
    public void play(Player p){
    }
}
