package lab3;

import lab3.enums.Equipment;
import lab3.enums.Works;
import lab3.essences.Human;
import lab3.essences.Mountain;
import lab3.essences.Person;
import lab3.essences.Znayka;
import lab3.exceptions.ProhibitedActionException;

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

          //  System.out.println(klepa.equals(zvezdochin));
            znayka.working(Works.bum);
            znayka.think("если они и отправились куда-нибудь, то, безусловно, пошли по этой дорожке");
            znayka.makeOrderToMove(cubic, piramid);
            znayka.makeOrderToMove(tubic, piramid);
            znayka.makeOrderToMove(zvezdochin, piramid);
            //tubic.makeOrderToMove(cubic, piramid);
            znayka.makeOrderToMove(steklyashkin, piramid);
            znayka.makeOrderToMove(klepa, piramid);
            klepa.working(Works.engineer);
            znayka.makeOrderToTake(cubic, Equipment.eqForMountains);
            znayka.makeOrderToTake(tubic, Equipment.eqForMountains);
            znayka.makeOrderToTake(zvezdochin, Equipment.eqForMountains);
            znayka.makeOrderToTake(steklyashkin, Equipment.eqForMountains);
            znayka.makeOrderToTake(klepa, Equipment.eqForMountains);
        } catch (ProhibitedActionException ex) {
            System.out.println("Нарушение запретов: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Произошла страшная ошибка: " + ex.getMessage());
        }
    }
}
