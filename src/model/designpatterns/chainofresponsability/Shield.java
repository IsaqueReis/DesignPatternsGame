package model.designpatterns.chainofresponsability;

import model.character.Character;

public abstract class Shield
{
    private Shield next;
    private boolean status; //shield status

    //recieves an attack from a enemy
    public abstract void recieveAttack(Character ch, double value);

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public boolean getStatus()
    {
        return this.status;
    }

    public void setSucessor(Shield s)
    {
        this.next = s;
    }

    public Shield getSucessor()
    {
        if(this.next != null)
            return this.next;
        return null;
    }

}