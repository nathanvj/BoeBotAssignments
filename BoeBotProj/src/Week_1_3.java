import TI.BoeBot;
import TI.Timer;

public class Week_1_3 {

    public static void main(String[] args) {

        Timer timer = new Timer(1000);

        timer.mark();

        while (true)
        {
            if (!BoeBot.digitalRead(10)) {
                if(timer.timeout()) {
                    BoeBot.digitalWrite(7, !BoeBot.digitalRead(7));
                    BoeBot.wait(998);
                }
            }
            else
            {
                BoeBot.digitalWrite(7, false);
            }

        }
    }
}