import TI.BoeBot;

public class Week_1_1 {

    public static void main(String[] args) {

        while (true) {

            BoeBot.digitalWrite(8, true);
            BoeBot.wait( 15);
            BoeBot.digitalWrite(8,false);
            BoeBot.wait(15);
        }
    }
}