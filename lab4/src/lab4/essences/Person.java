package lab4.essences;

import lab4.enums.Places;
import lab4.interfaces.*;

public abstract class Person implements MakingOrderToMove, MakingOrderToTake, Working, Thinking, Leaving, Walking {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private int id;
    private String firstName;
    private String lastName;

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Person guest = (Person) obj;
        return id == guest.id
                && (firstName == guest.firstName
                || (firstName != null &&firstName.equals(guest.getFirstName())))        && (lastName == guest.lastName
                || (lastName != null && lastName .equals(guest.getLastName())
        ));
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());             result = prime * result + id; result = prime * result +
                ((lastName == null) ? 0 : lastName.hashCode()); return result;
    }
    @Override
    public void walking(Places place) {
        System.out.println(getName() + " зашагал по " + place);
    }
    @Override
    public void leaving(Places place) {
        System.out.println(getName() + " покидает " + place);
    }

    @Override
    public String toString() {
        return "Имя: " + getName();
    }
}
