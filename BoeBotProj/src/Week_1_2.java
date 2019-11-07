import TI.BoeBot;
import TI.Timer;

public class Week_1_2 {

    public static void main(String[] args) {

        Timer t1 = new Timer(1300);
        Timer t2 = new Timer(800);
        Timer t1Uit = new Timer(700);
        Timer t2Uit = new Timer(1700);

        t1.mark();
        t2.mark();

        BoeBot.digitalWrite(8, true);
        BoeBot.digitalWrite(13, true);
        while (true) {

            if (t1.timeout()) {
                BoeBot.digitalWrite(8, !BoeBot.digitalRead(8));
                t1Uit.mark();
            }
            if (t2.timeout()) {
                BoeBot.digitalWrite(13, !BoeBot.digitalRead(13));
                t2Uit.mark();
            }
            if (t1Uit.timeout()) {
                BoeBot.digitalWrite(8, !BoeBot.digitalRead(8));
                t1.mark();
            }
            if (t2Uit.timeout()) {
                BoeBot.digitalWrite(13, !BoeBot.digitalRead(13));
                t2.mark();
            }
            BoeBot.wait(1);
        }
    }
}