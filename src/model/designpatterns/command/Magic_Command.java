package model.designpatterns.command;

import model.designpatterns.decorator.*;

public class Magic_Command implements Command {
	AttackDecorator special;

	public Magic_Command(AttackDecorator magic){
		this.special = magic;
	}
	public void execute(){
		this.special.Attack();
	}
	public String toString() { return "Magic Command.";}
}