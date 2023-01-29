package lab3.essences;

import lab3.enums.Equipment;
import lab3.exceptions.ProhibitedActionException;
import lab3.enums.Works;

public class Human extends Person {
    public Human(String name) {
        super(name);
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

        Human guest = (Human) obj;
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
    public void think(String action) throws ProhibitedActionException {
        throw  new ProhibitedActionException(getName() + " не умеет думать");
    }

    @Override
    public void makeOrderToMove(Person bum, Mountain mountain) throws ProhibitedActionException {
        throw new ProhibitedActionException(getName() + " не имеет права отдавать приказы");
    }

    @Override
    public void makeOrderToTake(Person bum, Equipment equipment) throws ProhibitedActionException {
        throw new ProhibitedActionException(getName() + " не имеет права отдавать приказы");
    }

    @Override
    public void working(Works works) {
        System.out.println(getName() + " works as " + works);

    }

}
