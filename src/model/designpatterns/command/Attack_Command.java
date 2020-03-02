package model.designpatterns.command;

import model.character.Character;

public class Attack_Command implements Command {
	Character charac;

	public Attack_Command(Character charac){
		this.charac = charac;
	}
	public void execute(){
		this.charac.Attack_Action();
	}
	public String toString() { return "Attack Command.";}
}