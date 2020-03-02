package model.designpatterns.command;

public class Moves{
	private String up    = "moved up";
	private String down  = "moved down";
	private String left  = "moved left";
	private String right = "moved right";

	public void moveUP(){
		System.out.println(up);
	}
	public void moveDown(){
		System.out.println(down);
	}
	public void moveLeft(){
		System.out.println(left);
	}
	public void moveRight(){
		System.out.println(right);
	}

}