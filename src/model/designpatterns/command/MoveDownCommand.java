package model.designpatterns.command;

public class MoveDownCommand implements Command {
	Moves move;

	public MoveDownCommand(Moves move){
		this.move = move;
	}
	public void execute(){
		this.move.moveDown();
	}
	public String toString() { return "Move Down Command.";}
}