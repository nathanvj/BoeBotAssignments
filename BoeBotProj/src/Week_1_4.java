import TI.*;

public class Week_1_4 {

    public static void main(String[] args) {

        Timer t1 = new Timer(1000);
        Timer t2 = new Timer(1000);
        Timer t3 = new Timer(700);
        Timer t4 = new Timer(700);
        t1.mark();
        t3.mark();

        while (true)
        {
            if (!BoeBot.digitalRead(10)) {
                if (t1.timeout()) {
                    BoeBot.digitalWrite(7, !BoeBot.digitalRead(7));
                    t2.mark();
                }
                if (t2.timeout()) {
                    BoeBot.digitalWrite(7, !BoeBot.digitalRead(7));
                    t1.mark();
                }
            }
            else if (BoeBot.digitalRead(10)) {
                BoeBot.digitalWrite(7, false);
            }
            if (!BoeBot.digitalRead(9)) {
                if (t3.timeout()) {
                    BoeBot.digitalWrite(2, !BoeBot.digitalRead(2));
                    t4.mark();
                }
                if (t4.timeout()) {
                    BoeBot.digitalWrite(2, !BoeBot.digitalRead(2));
                    t3.mark();
                }
            }
            else if (BoeBot.digitalRead(9)) {
                BoeBot.digitalWrite(2, false);
            }
            BoeBot.wait(1);
        }
    }
}