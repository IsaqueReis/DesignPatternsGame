package model.designpatterns.command;

public class MoveLeftCommand implements Command {
	Moves move;

	public MoveLeftCommand(Moves move){
		this.move = move;
	}
	public void execute(){
		this.move.moveLeft();
	}
	public String toString() { return "Move Left Command.";}
}