package model.designpatterns.command;

public class MoveRightCommand implements Command {
	Moves move;

	public MoveRightCommand(Moves move){
		this.move = move;
	}
	public void execute(){
		this.move.moveRight();
	}
	public String toString() { return "Move Right Command.";}
}