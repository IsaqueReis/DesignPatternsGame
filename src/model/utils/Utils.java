package model.utils;

public class Utils
{
    public static int getRandomIntegerBetweenRange(int min, int max)
    {
        double x = (int) (Math.random()* ((max-min)+1)) + min;
        return (int) x;
    }

    //1 - inimigo ganha
    //2 - player ganha
    public static int playDices()
    {
        int fstD6 = getRandomIntegerBetweenRange(1, 6);
        int sndD6 = getRandomIntegerBetweenRange(1, 6);

        if(fstD6 > sndD6)
            return 1;
        else if(sndD6 > fstD6)
            return 2;
        else
            return playDices();
    }
}
