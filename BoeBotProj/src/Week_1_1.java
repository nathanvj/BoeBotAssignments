import TI.*;

public class Week_1_1 {

    public static void main(String[] args) {

        while (true) {

            BoeBot.digitalWrite(8, true);
            BoeBot.wait( 1000);
            BoeBot.digitalWrite(8,false);
            BoeBot.wait(1000);
        }
    }
}