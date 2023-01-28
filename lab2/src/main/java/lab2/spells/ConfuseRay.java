package lab2.spells;
import ru.ifmo.se.pokemon.*;

public class ConfuseRay extends StatusMove {
    public ConfuseRay (){
        super(Type.GHOST, 0, 0);
    }

    @Override
    protected boolean checkAccuracy(Pokemon pokemon, Pokemon pokemon1) {
        return true;
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {

        Effect.confuse(pokemon);
    }
    @Override
    protected String describe() {
        return "ConfuseRay";
    }
}
