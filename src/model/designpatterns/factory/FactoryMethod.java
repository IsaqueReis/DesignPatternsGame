package model.designpatterns.factory;

import model.character.Character;
import model.designpatterns.composite.*;

public abstract class FactoryMethod{
	
	public abstract Character createCharacter(double rN, String name);
	public abstract Phase createPhase(double rN);

}