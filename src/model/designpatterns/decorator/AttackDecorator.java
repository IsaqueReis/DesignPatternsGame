package model.designpatterns.decorator;

import model.designpatterns.strategy.*;

public abstract class AttackDecorator extends Attack_Behavior
{
    private Attack_Behavior attBehavior;
    private double increasing;

    public AttackDecorator(Attack_Behavior b)
    {
        this.attBehavior = b;
    }

    public double getAttackWeight()
    {
        return attBehavior.getAttackWeight() + this.getIncreasing();
    }

    public double getJustIncreasing()
    {
        return this.getIncreasing();
    }

    public void setIncreasing(double d)
    {
        this.increasing = d;
    }

    public double getIncreasing()
    {
        return this.increasing;
    }
}