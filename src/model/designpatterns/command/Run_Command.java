package model.designpatterns.command;

import model.character.Character;

public class Run_Command implements Command {
	Character charac;

	public Run_Command(Character charac){
		this.charac = charac;
	}
	public void execute(){
		this.charac.Run_Action();
	}
	public String toString() { return "Run Command.";}
}