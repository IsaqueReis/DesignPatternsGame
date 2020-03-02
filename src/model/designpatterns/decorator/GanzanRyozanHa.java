package model.designpatterns.decorator;

import model.designpatterns.strategy.*;

public class GanzanRyozanHa extends AttackDecorator
{
    public GanzanRyozanHa(Attack_Behavior attackDecoreated)
    {
        super(attackDecoreated);
        setIncreasing(25);
        System.out.println("Esse decorador acrescenta 10000 no poder de ataque!");
    }

    public void Attack()
    {
        System.out.println("Atacando com o golpe GanzanRyozanHa");
    }
}