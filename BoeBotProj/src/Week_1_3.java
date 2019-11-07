import TI.BoeBot;
import TI.Timer;

public class Week_1_3 {

    public static void main(String[] args) {

        while (true) {

            if (BoeBot.digitalRead(13)) {
                BoeBot.digitalWrite(7, true);
            }
            else {
                BoeBot.digitalWrite(7, false);
            }
        }
    }
}