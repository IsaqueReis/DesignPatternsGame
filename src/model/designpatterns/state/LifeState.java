package model.designpatterns.state;

public interface LifeState
{
    //increase character hp
    public void increaseHP(double amount);
    //decrease character hp
    public void decreaseHP(double amount);
}