package model.designpatterns.strategy;

public class Average_Attack extends Attack_Behavior {

	public Average_Attack()
	{
		super.setAttackWeight(0.5);
	}
	
	public void Attack(){
		System.out.println("Average attack");
	}
}