package model.character;

import model.designpatterns.strategy.*;

public class Char02 extends Character {
	
	public Char02(String name){
		super(new Average_Attack(), new High_Jump(), new Fast_Run(), name);
	}
	public void setAttack(Attack_Behavior attack){
		super.setAttack(attack);
	}

	public void setJump(Jump_Behavior jump){
		super.setJump(jump);
	}

	public void setRun(Run_Behavior run){
		super.setRun(run);
	}
}