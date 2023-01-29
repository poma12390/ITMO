package lab3.essences;

public class Mountain extends Essence {
    public Mountain(String name) {
        super(name);
        System.out.println("Недалеко от поселения горы");
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

        Mountain guest = (Mountain) obj;
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
    public String toString() {
        return  getName();
    }

}
