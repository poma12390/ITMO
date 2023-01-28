package lab2.pokemons;
import lab2.spells.Confide;
import ru.ifmo.se.pokemon.*;

public class Raichu extends Pikachu{
    public Raichu(String name, int lvl){
        super(name,lvl);
        setStats(60,90,55,90,80,110);
        Move confide = new Confide();
        addMove(confide);
    }
}
