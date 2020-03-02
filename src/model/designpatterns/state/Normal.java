package model.designpatterns.state;

import model.designpatterns.strategy.*;
import model.character.Character;

public class Normal implements LifeState
{
    private Character character;

    public Normal(Character ch)
    {
        character = ch;
        double increasing = ch.getAttack().getJustIncreasing();
        double defaultAttack;
        //setting up life state
        System.out.printf("Atenção！ [Mudança de estado: Normal]. [hp: %.2f].\n", ch.getHP());
        character.setAttack(new Average_Attack());
        defaultAttack = character.getAttack().getAttackWeight();
        character.getAttack().setAttackWeight(increasing + defaultAttack);
        character.setRun(new Average_Run());
        character.setLifeState(this);
    }

    //increase character hp
    public void increaseHP(double amount)
    {
        double tmp = character.getHP() + amount;
        //health is aways in [0, 100]
        if(tmp < 0)
            tmp = 0;
        if(tmp > 100)
            tmp = 100;
        
        if(tmp > 0 && tmp < 30)
        {
            character.setLifeState(this);
            character.setHP(tmp);
        } else if(tmp >= 30 && tmp < 70) {
            character.setLifeState(new Normal(character));
            character.setHP(tmp);
        } else if(tmp >= 70 && tmp <= 100){
            character.setLifeState(new Strong(character));
            character.setHP(tmp);
        } else {
            character.setLifeState(new Dead(character));
        }
    }
    
    //decrease character hp
    public void decreaseHP(double amount)
    {
        double tmp = character.getHP() - amount;
        //health is aways in [0, 100]
        if(tmp < 0)
            tmp = 0;
        if(tmp > 100)
            tmp = 100;
        
        if(tmp > 0 && tmp < 30)
        {
            character.setLifeState(new Danger(character));
            character.setHP(tmp);
        } else if(tmp >= 30 && tmp < 70) {
            character.setLifeState(this);
            character.setHP(tmp);
        } else if(tmp >= 70 && tmp <= 100){
            character.setLifeState(new Strong(character));
            character.setHP(tmp);
        } else {
            character.setLifeState(new Dead(character));
        }
    }

    public String toString()
    {
        return "normal";
    }

}
