package lab3.essences;

import lab3.interfaces.MakingOrderToMove;
import lab3.interfaces.MakingOrderToTake;
import lab3.interfaces.Thinking;
import lab3.interfaces.Working;

public abstract class Person implements MakingOrderToMove, MakingOrderToTake, Working, Thinking {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }

    @Override
    public String toString() {
        return "Имя: " + getName();
    }
}
