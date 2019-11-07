import TI.*;

public class Week_1_4 {

    public static void main(String[] args) {

        Timer t1 = new Timer(1000);
        Timer t2 = new Timer(1000);
        t1.mark();

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
            else {
                BoeBot.digitalWrite(7, false);
            }
            BoeBot.wait(1);
        }
    }
}