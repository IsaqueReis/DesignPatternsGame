package model.designpatterns.state;

import model.character.Character;

public class Dead implements LifeState
{
    private Character character;

    public Dead(Character ch)
    {
        character = ch;

        //setting up life state
        System.out.println("Atenção! [Mudança de estado: Morto].");
        ch.setHP(0.0);
    }      

    //increase character hp
    public void increaseHP(double amount)
    {
        System.out.println("Você já morreu!");
    }
        
    //decrease character hp
    public void decreaseHP(double amount)
    {
        System.out.println("Você já morreu!");
    }

    public String toString()
    {
        return "morto";
    }

}