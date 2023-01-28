package lab2.spells;
import ru.ifmo.se.pokemon.*;


public class ShadowClaw extends PhysicalMove {
    public ShadowClaw(){
        super(Type.PSYCHIC, 70,100);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        Effect crit = new Effect().chance(0.125).turns(1).stat(Stat.SPEED, 6);
        pokemon.addEffect(crit);
        
    }
    @Override
    protected String describe() {
        return "Shadowclaw";
    }


}

