package model.designpatterns.factory;

import model.designpatterns.composite.*;
import model.designpatterns.observer.*;

import model.utils.Utils;

public class PhaseFactory {


    private static Abyss generateRandomAbyss(int rangeMinX, int rangeMaxX, int rangeMinY, int rangeMaxY)
    {
        return new Abyss(Utils.getRandomIntegerBetweenRange(rangeMinX, rangeMaxX),
            Utils.getRandomIntegerBetweenRange(rangeMinY, rangeMaxY));
    }

    private static Exit generateRandomExit(int rangeMinX, int rangeMaxX, int rangeMinY, int rangeMaxY)
    {
        return new Exit(Utils.getRandomIntegerBetweenRange(rangeMinX, rangeMaxX),
                Utils.getRandomIntegerBetweenRange(rangeMinY, rangeMaxY));
    }

    private static Enemy generateRandomEnemy(String name, int x, int y,int rangeMinX, int rangeMaxX,
                                                                int rangeMinY, int rangeMaxY)
    {
        return new Enemy(x, y, Utils.getRandomIntegerBetweenRange(rangeMinX, rangeMaxX),
                Utils.getRandomIntegerBetweenRange(rangeMinY, rangeMaxY), name);
    }


    public static Phase generatePhase(double rN) {

        int
                minRange = Utils.getRandomIntegerBetweenRange(250, 800),
                maxRange = Utils.getRandomIntegerBetweenRange(250,800),
                bossX = Utils.getRandomIntegerBetweenRange(250,800),
                bossY = Utils.getRandomIntegerBetweenRange(250,600);


        /*Leaf node types*/
        Phase abyss1 = generateRandomAbyss(minRange, maxRange, minRange, maxRange);
        Phase abyss2 = generateRandomAbyss(minRange, maxRange, minRange, maxRange);
        Phase abyss3 = generateRandomAbyss(minRange, maxRange, minRange, maxRange);
        Phase out1 = generateRandomAbyss(minRange, maxRange, minRange, maxRange);
        Phase out2 = generateRandomAbyss(minRange, maxRange, minRange, maxRange);
        Phase out3 = generateRandomAbyss(minRange, maxRange, minRange, maxRange);

        /*Bosses */
        Enemy boss1 = generateRandomEnemy("BOSS 1", bossX, bossY, minRange, maxRange, minRange, maxRange);
        Enemy boss2 = generateRandomEnemy("BOSS 2", bossX, bossY, minRange, maxRange, minRange, maxRange);
        Enemy boss3 = generateRandomEnemy("BOSS 3", bossX, bossY, minRange, maxRange, minRange, maxRange);
        Enemy boss4 = generateRandomEnemy("BOSS 4", bossX, bossY, minRange, maxRange, minRange, maxRange);
        Enemy boss5 = generateRandomEnemy("BOSS 5", bossX, bossY, minRange, maxRange, minRange, maxRange);
        Enemy boss6 = generateRandomEnemy("BOSS 6", bossX, bossY, minRange, maxRange, minRange, maxRange);

        /*Rooms*/
        Phase room1 = new Room(abyss1, out2, boss1);
        Phase room2 = new Room(abyss1, out2, boss2);
        Phase room3 = new Room(room1, out2, boss3);
        Phase room4 = new Room(out1, room1, boss4);
        Phase room5 = new Room(room4, room2, boss5);
        Phase room6 = new Room(room5, room3, boss6);

        Phase p = null;
        if(rN < 0)
            rN = Math.random();

        if(rN <= 0.2)
        {
            return room3;
        }
        else if(0.2 < rN && rN <= 0.4)
        {
            return room4;
        }
        else if(0.4 < rN && rN  <= 0.6)
        {
            return room5;
        }
        else
        {
            return room6;
        }
    }
}
