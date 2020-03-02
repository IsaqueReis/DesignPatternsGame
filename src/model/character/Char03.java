package model.character;

import model.designpatterns.strategy.*;

public class Char03 extends Character {
	
	public Char03(String name){
		super(new Strong_Attack(), new Low_Jump(), new Fast_Run(), name);
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