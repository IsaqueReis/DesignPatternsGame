package model.designpatterns.factory;

import model.character.Character;
import model.designpatterns.strategy.*;
import model.character.Char01;
import model.character.Char02;
import model.character.Char03;

public class RandomPersonagemFactory{


	
	public static Character createCharacter(double rN, String name){

		Character c = null;
		if(rN < 0)
			rN = Math.random();
		System.out.println(rN);
		if(rN <= 0.2){
			c = new Char01(name);
			Attack_Behavior kenshiroDescendant = new Strong_Attack();
			kenshiroDescendant.setAttackWeight(100.0);
			c.setAttack(kenshiroDescendant);
		}
		else if(0.2 < rN && rN <= 0.4){
			c = new Char01(name);
			Attack_Behavior kenshiroDescendant = new Strong_Attack();
			kenshiroDescendant.setAttackWeight(150.0);
			c.setAttack(kenshiroDescendant);

		}
		else if(0.4 < rN && rN  <= 0.6){
			c = new Char02(name);
			Attack_Behavior kenshiroDescendant = new Strong_Attack();
			kenshiroDescendant.setAttackWeight(200.0);
			c.setAttack(kenshiroDescendant);
		}
		else if(0.6 < rN  && rN <= 0.8){
			c = new Char02(name);
			Attack_Behavior kenshiroDescendant = new Strong_Attack();
			kenshiroDescendant.setAttackWeight(250.0);
			c.setAttack(kenshiroDescendant);
		}
		else if (0.8 < rN  && rN <= 1.0){
			c = new Char03(name);
			Attack_Behavior kenshiroDescendant = new Strong_Attack();
			kenshiroDescendant.setAttackWeight(300.0);
			c.setAttack(kenshiroDescendant);
		}
		
		return c;
	}



}
