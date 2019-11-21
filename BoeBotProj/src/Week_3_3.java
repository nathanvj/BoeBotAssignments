import TI.*;

public class Week_3_3 {

    public static void main(String[] args) {
        System.out.println("Starten...");
        while(true) {
            BoeBot.digitalWrite(6, true);
            BoeBot.wait(1);
            BoeBot.digitalWrite(6, false);

            int pulseLength = BoeBot.pulseIn(7, true, 10000);
            System.out.println("Pulse: "+ pulseLength);
            BoeBot.wait(50);

        }
    }
}
