import TI.*;

public class Week_2_3 {

    public static void main(String[] args) {

        final int redPin = 6;
        final int greenPin = 7;
        final int bluePin = 8;

        while(true) {

            BoeBot.digitalWrite(redPin, true);
            BoeBot.digitalWrite(greenPin, true);
            BoeBot.digitalWrite(bluePin, false);
            BoeBot.wait(1000);

            BoeBot.digitalWrite(redPin, true);
            BoeBot.digitalWrite(greenPin, false);
            BoeBot.digitalWrite(bluePin, true);
            BoeBot.wait(1000);

            BoeBot.digitalWrite(redPin, false);
            BoeBot.digitalWrite(greenPin, true);
            BoeBot.digitalWrite(bluePin, true);
            BoeBot.wait(1000);

            /*BoeBot.digitalWrite(redPin, true);
            BoeBot.digitalWrite(greenPin, true);
            BoeBot.digitalWrite(bluePin, true);
            BoeBot.wait(1000);
            */
        }
    }
}