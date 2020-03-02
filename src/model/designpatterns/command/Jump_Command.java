package model.designpatterns.command;

import model.character.Character;

public class Jump_Command implements Command {
	Character charac;

	public Jump_Command(Character charac){
		this.charac = charac;
	}
	public void execute(){
		this.charac.Jump_Action();
	}
	public String toString() { return "Jump Command.";}
}