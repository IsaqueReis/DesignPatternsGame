package model.designpatterns.strategy;

public class Weak_Attack extends Attack_Behavior {

	public Weak_Attack()
	{
		super.setAttackWeight(0.3);
	}
	
	public void Attack(){
		System.out.println("Weak attack");
	}
}