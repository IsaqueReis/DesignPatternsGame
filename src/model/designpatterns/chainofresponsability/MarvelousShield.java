package model.designpatterns.chainofresponsability;

import model.character.Character;

public class MarvelousShield extends Shield
{
    private static double SHIELD_VALUE = 15.0;

    //recieves an attack from a enemy
    public void recieveAttack(Character ch, double value)
    {
        double diff = value - SHIELD_VALUE;

        if(diff <= 0)
        {
            System.out.println("O escudo defendeu o ataque!");
            return;
        }

        if(diff > 0 && getSucessor() != null) 
        {
            System.out.printf("O escudo defendeu parte do ataque, no entanto soubrou %.2f de dano. Chamaremos o próximo escudo...\n", diff);
            getSucessor().recieveAttack(ch, diff);
        }

        else if(diff > 0 && getSucessor() == null)
        {
            System.out.printf("O escudo defendeu parte do ataque, no entanto %.2f sobrou para o personagem. Esse é o ultimo escudo da cadeia.\n", diff);
            ch.getLifeState().decreaseHP(diff);
            return;
        }

        else {
            return;
        }
    }
}