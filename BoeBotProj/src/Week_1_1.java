import TI.*;

public class Week_1_1 {

    public static void main(String[] args) {

        while (true) {

            BoeBot.digitalWrite(8, true);
            BoeBot.wait( 100);
            BoeBot.digitalWrite(8,false);
            BoeBot.wait(100);
        }
    }
}