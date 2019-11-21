import TI.*;

public class Week_3_3 {

    static Servo s1 = new Servo(12);
    static Servo s2 = new Servo(13);
    static Week_2_5 boeBotControls = new Week_2_5();
    public static void main(String[] args) {

        System.out.println("Starten...");
        while(true) {


            BoeBot.digitalWrite(6, true);
            BoeBot.wait(1);
            BoeBot.digitalWrite(6, false);

            int pulseLength = BoeBot.pulseIn(7, true, 10000);
            System.out.println("Pulse: "+ pulseLength);
            if (pulseLength > 500 || pulseLength < 0 ) {
                s1.update(1540);
                s2.update(1460);
                BoeBot.wait(50);
            }
            else {
                s1.update(1500);
                s2.update(1500);
                BoeBot.wait(1000);
                s1.update(1460);
                s2.update(1540);
                BoeBot.wait(800);
                boeBotControls.turnDegrees(180,40);
            }
            BoeBot.wait(50);

        }
    }
}
