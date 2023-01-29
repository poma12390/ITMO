package lab4;

import lab4.enums.Equipment;
import lab4.enums.Places;
import lab4.enums.Works;
import lab4.essences.Human;
import lab4.essences.Mountain;
import lab4.essences.Person;
import lab4.essences.Znayka;
import lab4.exceptions.ProhibitedActionException;

public class Main {

    public static void main(String[] args) {
        try {

                    Person znayka = new Znayka("Знайка");
            Person cubic = new Human("Кубик");
            Person tubic = new Human("Тубик");
            Person zvezdochin = new Human("Звездочкин");
            Person steklyashkin = new Human("стекляшкин");
            Person klepa = new Human("Клепа");
            Mountain piramid = new Mountain("пирамидальная гора");
            Person jora = new Human("фыв");

             //System.out.println(klepa.equals(jora));
            znayka.think("если они и отправились куда-нибудь, то, безусловно, пошли по этой дорожке");
            znayka.makeOrderToMove(cubic, piramid);
            znayka.makeOrderToMove(tubic, piramid);
            znayka.makeOrderToMove(zvezdochin, piramid);
           // tubic.makeOrderToMove(znayka, piramid);
            znayka.makeOrderToMove(steklyashkin, piramid);
            znayka.makeOrderToMove(klepa, piramid);
            klepa.working(Works.ENGINEER);
            znayka.makeOrderToTake(cubic, Equipment.EQ_FOR_MOUNTAINS);
            znayka.makeOrderToTake(tubic, Equipment.EQ_FOR_MOUNTAINS);
            znayka.makeOrderToTake(zvezdochin, Equipment.EQ_FOR_MOUNTAINS);
            znayka.makeOrderToTake(steklyashkin, Equipment.EQ_FOR_MOUNTAINS);
            znayka.makeOrderToTake(klepa, Equipment.EQ_FOR_MOUNTAINS);
            cubic.leaving(Places.ROCKET);
            tubic.leaving(Places.ROCKET);
            zvezdochin.leaving(Places.ROCKET);
            steklyashkin.leaving(Places.ROCKET);
            cubic.walking(Places.MOON_ROAD);
        } catch (ProhibitedActionException ex) {
            System.err.println("Нарушение запретов: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Произошла страшная ошибка: " + ex.getMessage());
        }
    }
}
