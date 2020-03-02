package model.designpatterns.decorator;

import model.designpatterns.strategy.*;

public class HundredCrackFist extends AttackDecorator
{
    public HundredCrackFist(Attack_Behavior attackDecoreated)
    {
        super(attackDecoreated);
        setIncreasing(16);
        System.out.println("Esse decorador acrescenta 100 no poder de ataque!");
    }

    public void Attack()
    {
        System.out.println("Atacando com o golpe HundredCrackFist");
    }
}