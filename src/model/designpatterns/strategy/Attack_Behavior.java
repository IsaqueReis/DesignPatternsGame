package model.designpatterns.strategy;

public abstract class Attack_Behavior{
	
	private double attackWeight;

	public abstract void Attack();

	public double getAttackWeight()
	{
		return this.attackWeight;
	}

	public double getJustIncreasing()
	{
		return this.attackWeight;
	}

	public void setAttackWeight(double aw)
	{
		this.attackWeight = aw;
	}
	

}