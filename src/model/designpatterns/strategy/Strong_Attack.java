package model.designpatterns.strategy;

public class Strong_Attack extends Attack_Behavior {

	public Strong_Attack()
	{
		super.setAttackWeight(1.0);
	}
	
	public void Attack(){
		System.out.println("Strong attack!");
	}
}