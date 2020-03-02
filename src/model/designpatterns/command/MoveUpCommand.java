package model.designpatterns.command;

public class MoveUpCommand implements Command {
	Moves move;

	public MoveUpCommand(Moves move){
		this.move = move;
	}
	public void execute(){
		this.move.moveUP();
	}
	public String toString() { return "Move Up Command.";}
}