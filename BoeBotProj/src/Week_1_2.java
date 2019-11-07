import TI.BoeBot;
import TI.Timer;

public class Week_1_2 {

    public static void main(String[] args) {

        Timer t1 = new Timer(1000);
        Timer t2 = new Timer(500);

        t1.mark();
        t2.mark();

        BoeBot.digitalWrite(8, false);
        BoeBot.digitalWrite(13, false);
        while (true) {

            if (t1.timeout()) {
                BoeBot.digitalWrite(8, !BoeBot.digitalRead(8));
                t1.mark();
            }
            if (t2.timeout()) {
                BoeBot.digitalWrite(13, !BoeBot.digitalRead(13));
                t2.mark();
            }
            BoeBot.wait(1);
        }
    }
}