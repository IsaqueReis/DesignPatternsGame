package model.designpatterns.factory;

import model.designpatterns.composite.Phase;
import model.character.Character;

public class GeneratePhase extends FactoryMethod {

    private static GeneratePhase instance = null;

    @Override
    public Character createCharacter(double rN, String name) {
        return null;
    }

    @Override
    public Phase createPhase(double rN) {
        return PhaseFactory.generatePhase(rN);
    }

    public static synchronized GeneratePhase getInstance(){
        if(instance == null)
            instance = new GeneratePhase();
        return instance;
    }
}
