package model.character;

import model.designpatterns.strategy.*;

public class Char01 extends Character {
	
	public Char01(String name){ super(new Strong_Attack(), new Average_Jump(), new Average_Run(), name); }

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