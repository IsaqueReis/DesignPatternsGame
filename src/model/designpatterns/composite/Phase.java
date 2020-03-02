package model.designpatterns.composite;

import model.designpatterns.observer.*;

public interface Phase {

    public String typeOfRoom();
    public Enemy getBoss();
    public void play(Player p);
}
