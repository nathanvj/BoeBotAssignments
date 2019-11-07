import TI.*;

public class Week_1_3 {

    public static void main(String[] args) {

        boolean state = false;

        while (true)
        {
            if (!BoeBot.digitalRead(10)) {
                BoeBot.digitalWrite(2, false);
                state = !state;

                if (state) {
                    BoeBot.digitalWrite(7, true);
                    BoeBot.wait(1300);
                }
                else {
                    BoeBot.digitalWrite(7, false);
                    BoeBot.wait(700);
                }
            }
            else
            {
                BoeBot.digitalWrite(7, false);
                BoeBot.digitalWrite(2, true);
            }

        }
    }
}