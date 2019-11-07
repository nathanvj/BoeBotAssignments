import TI.*;

public class RobotMain {
    private static Servo s1 = new Servo(12);
    private static Servo s2 = new Servo(13);


    public static void main(String[] args) {

        boolean state = true;
        s1.update(1500);
        s2.update(1500);


        while (true) {
            state = !state;
            BoeBot.digitalWrite(0, state);
            BoeBot.wait(0, 20000);
        }
    }
}
