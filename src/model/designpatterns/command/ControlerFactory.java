package model.designpatterns.command;

import model.character.Character;
import model.designpatterns.decorator.*;
import model.designpatterns.strategy.*;

public class ControlerFactory{

		
	
	public Controler getInvoker(Character ryu){

		Controler control = new Controler();
		
		
       Attack_Command att = new Attack_Command(ryu);
       Run_Command	run = new Run_Command(ryu);
       Jump_Command jump = new Jump_Command(ryu);
       Magic_Command magic = new Magic_Command(new GanzanRyozanHa(new Strong_Attack()));
       MoveUpCommand moveUP = new MoveUpCommand(new Moves());
       MoveDownCommand moveDown = new MoveDownCommand(new Moves());
       MoveLeftCommand moveLeft = new MoveLeftCommand(new Moves());
       MoveRightCommand	moveRight = new MoveRightCommand(new Moves());
       L1_Command l1 = new L1_Command(ryu);
       L2_Command l2 = new L2_Command(ryu);


        control.setCommand(att,0);
        control.setCommand(run,1);
        control.setCommand(jump,2);
        control.setCommand(magic,3);
        control.setCommand(moveUP,4);
        control.setCommand(moveDown,5);
        control.setCommand(moveLeft,6);
        control.setCommand(moveRight,7);
        control.setCommand(l1,8);
        control.setCommand(l2,9);
		
        return control;
		}




}
