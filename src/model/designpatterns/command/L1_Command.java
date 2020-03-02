package model.designpatterns.command;

import model.character.Character;

public class L1_Command implements Command {
	private Character charac;
	 private Moves move = new Moves();

	public L1_Command(Character charac){
		this.charac = charac;
	}
	public void execute(){
		this.charac.Attack_Action();
		this.charac.Jump_Action();
		this.charac.Run_Action();
		move.moveLeft();
		this.charac.Attack_Action();
	}

	public String toString() { return "L2 Command.";}
}