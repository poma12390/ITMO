package lab2.spells;
import ru.ifmo.se.pokemon.*;

public class HornAttack extends SpecialMove{
    public HornAttack(){
        super(Type.PSYCHIC,65,100);
    }


    @Override
    protected String describe() {
        return "Horn Attack";
    }
}
