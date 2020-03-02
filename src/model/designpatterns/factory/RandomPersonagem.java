package model.designpatterns.factory;

import model.character.Character;
import model.designpatterns.composite.Phase;

public class RandomPersonagem extends FactoryMethod {

	private static RandomPersonagem instance = null;
	private RandomPersonagem(){

	}

	public static synchronized RandomPersonagem getInstance(){
		if(instance == null)
			instance = new RandomPersonagem();
		return instance;
	}

	public Character createCharacter(double rN, String name){
		return RandomPersonagemFactory.createCharacter(rN, name);
	}

	@Override
	public Phase createPhase(double rN) {
		return null;
	}

}