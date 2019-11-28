import TI.*;

public class Week_4_1 {

    static int analogeWaarde;
    static int analogeWaarde2;
    static int analogeWaarde3;
    public static void main(String[] args) {

        System.out.println("Spoorzoeken...");
        while(true) {
            analogeWaarde = BoeBot.analogRead(0);
            analogeWaarde2 = BoeBot.analogRead(1);
            analogeWaarde3 = BoeBot.analogRead(2);
            BoeBot.wait(100);
            System.out.print("Analoge waarde: "+analogeWaarde);
            System.out.print(" Analoge waarde 2: "+analogeWaarde2);
            System.out.print(" Analoge waarde 3: "+analogeWaarde3);
            System.out.println();
            BoeBot.wait(50);

        }
    }
}
