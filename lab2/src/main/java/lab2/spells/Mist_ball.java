package lab2.spells;
import ru.ifmo.se.pokemon.*;
import ru.ifmo.se.pokemon.PhysicalMove;


public class Mist_ball extends SpecialMove {


    public Mist_ball() {
        super(Type.PSYCHIC,70, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        Effect spAtt = new Effect().chance(0.5).turns(1).stat(Stat.SPECIAL_ATTACK, -6);
        pokemon.addEffect(spAtt);
    }

        @Override
        protected String describe() {
            return "mist_ball attack";
        }

}




