package lab4.essences;

import lab4.enums.Equipment;
import lab4.enums.Works;
import lab4.exceptions.ProhibitedActionException;

public class Znayka extends Person {

    public Znayka(String name) {
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

        Znayka guest = (Znayka) obj;
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
    public void think(String action) {
        System.out.println(getName() + " думал, что " + action);
    }

    @Override
    public void makeOrderToMove(Person bum, Mountain mountain) throws ProhibitedActionException {
        System.out.println(getName() + " отдал приказ " + bum.getName() + " идти к " + mountain);
    }

    @Override
    public void makeOrderToTake(Person bum, Equipment equipment) throws ProhibitedActionException {
        System.out.println(getName() + " отдал приказ " + bum.getName() + " взять " + equipment);

    }


    @Override
    public void working(Works works) {
        System.out.println(getName() + " работает " + works);

    }


}
