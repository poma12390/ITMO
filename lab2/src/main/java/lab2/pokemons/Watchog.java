package lab2.pokemons;
import lab2.spells.ConfuseRay;
import ru.ifmo.se.pokemon.*;

public class Watchog extends Patrat {
    public Watchog(String name, int lvl){
        super(name,lvl);
        setStats(60,85,69,60,69,77);
        Move confuseRay = new ConfuseRay();
        addMove(confuseRay);

    }
}
