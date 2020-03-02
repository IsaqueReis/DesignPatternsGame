package model.designpatterns.decorator;

import model.designpatterns.strategy.*;

public class KoretsuHa extends AttackDecorator
{
    public KoretsuHa(Attack_Behavior attackDecoreated)
    {
        super(attackDecoreated);
        setIncreasing(7);
        System.out.println("Esse decorador acrescenta 500 no poder de ataque!");
    }

    public void Attack()
    {
        System.out.println("Atacando com o golpe KoretsuHa");
    }
}