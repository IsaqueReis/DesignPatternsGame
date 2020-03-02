package model.designpatterns.factory;

import model.character.Character;
import model.designpatterns.strategy.*;
import model.designpatterns.decorator.*;
import model.character.Char01;
import model.character.Char02;
import model.character.Char03;

public class RandomSpecialPersonagemFactory{

	public static Character createCharacter(String name){

		Character c = null;
		double rN = Math.random();
		System.out.println(rN);
		if(rN <= 0.2){
			c = new Char01(name);
			Attack_Behavior kenshiroDescendant = new Strong_Attack();
			kenshiroDescendant = new GanzanRyozanHa(kenshiroDescendant);
			c.setAttack(kenshiroDescendant);
		}
		else if(0.2 < rN && rN <= 0.4){
			c = new Char01(name);
			Attack_Behavior kenshiroDescendant = new Strong_Attack();
			kenshiroDescendant = new Average_Attack();
			kenshiroDescendant = new GanzanRyozanHa(kenshiroDescendant);
			c.setAttack(kenshiroDescendant);

		}
		else if(0.4 < rN && rN  <= 0.6){
			c = new Char02(name);
			Attack_Behavior kenshiroDescendant = new Strong_Attack();
			kenshiroDescendant = new Strong_Attack();
			kenshiroDescendant = new HundredCrackFist(kenshiroDescendant);
			c.setAttack(kenshiroDescendant);
		}
		else if(0.6 < rN  && rN <= 0.8){
			c = new Char02(name);
			Attack_Behavior kenshiroDescendant = new Weak_Attack();
			kenshiroDescendant = new Weak_Attack();
			kenshiroDescendant = new HundredCrackFist(kenshiroDescendant);
			c.setAttack(kenshiroDescendant);	
		}
		else if (0.8 < rN  && rN <= 1.0){
			c = new Char03(name);
			Attack_Behavior kenshiroDescendant = new Weak_Attack();
			kenshiroDescendant = new Strong_Attack();
			kenshiroDescendant = new Strong_Attack();
			kenshiroDescendant = new GanzanRyozanHa(kenshiroDescendant);
			c.setAttack(kenshiroDescendant);	
		}
		
		return c;
	}



}
