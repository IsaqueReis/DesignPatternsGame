package model.designpatterns.composite;

import model.designpatterns.observer.*;
import model.utils.Utils;

import java.util.ArrayList;

public class Room implements Phase {

    private ArrayList<Phase> c1 = new ArrayList<Phase>();
    private ArrayList<Phase> c2 = new ArrayList<Phase>();

    private Enemy boss;

    public Room(Phase c1, Phase c2, Enemy boss)
    {
        this.c1.add(c1);
        this.c2.add(c2);
        this.boss = boss;
    }

    @Override
    public String typeOfRoom() {
        return "sala";
    }

    @Override
    public Enemy getBoss() {
        return this.boss;
    }

    public void play(Player p)
    {
        switch (Utils.playDices())
        {
            case 2 :
                {
                    //select a random path c1
                    int index = Utils.getRandomIntegerBetweenRange(0, c2.size() - 1);
                    p.setPhase(c2.get(index));
                    break;
                }
            default:
                {
                    //select a random path c2
                    int index = Utils.getRandomIntegerBetweenRange(0, c2.size() - 1);
                    p.setPhase(c1.get(index));
                    break;
                }
        }
    }
}
