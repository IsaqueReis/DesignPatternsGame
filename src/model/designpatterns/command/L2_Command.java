package model.designpatterns.command;

import model.character.Character;

public class L2_Command implements Command {
	private Character charac;
	 private Moves move = new Moves();

	public L2_Command(Character charac){
		this.charac = charac;
	}
	public void execute(){
		move.moveLeft();
		move.moveRight();
		this.charac.Attack_Action();

		this.charac.Jump_Action();
		this.charac.Run_Action();
		move.moveDown();
		move.moveLeft();
		this.charac.Attack_Action();
	}

	public String toString() { return "L1 Command.";}
}