package lab2.spells;
import ru.ifmo.se.pokemon.*;
import ru.ifmo.se.pokemon.SpecialMove;

public class Thunder extends SpecialMove {
    public Thunder(){
        super(Type.ELECTRIC, 110, 70);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        Effect par = new Effect().condition(Status.PARALYZE).chance(0.3).turns(1);
        pokemon.addEffect(par);
    }
    @Override
    protected String describe() {
        return "Thunder attack";
    }
}
