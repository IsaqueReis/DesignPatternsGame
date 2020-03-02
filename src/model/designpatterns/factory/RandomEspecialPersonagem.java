package model.designpatterns.factory;

import model.character.Character;
import model.designpatterns.composite.Phase;

public class RandomEspecialPersonagem extends FactoryMethod {

	private static RandomEspecialPersonagem instance = null;
	private RandomEspecialPersonagem(){

	}

	public static synchronized RandomEspecialPersonagem getInstance(){
		if(instance == null)
			instance = new RandomEspecialPersonagem();
		return instance;
	}

	public Character createCharacter(double rN, String name){
		return RandomSpecialPersonagemFactory.createCharacter(name);
	}

	@Override
	public Phase createPhase(double rN) {
		return null;
	}

}