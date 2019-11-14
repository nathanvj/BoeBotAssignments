import TI.*;

public class Week_2_5 {

    static Servo s1 = new Servo(12);
    static Servo s2 = new Servo(13);
    static int currentSpeed = 0;
    static int currentTurnSpeed = 0;

    public static void main(String[] args) {

        s1.update(1500);
        s2.update(1500);

        turn(10);
        BoeBot.wait(5000);
        turn(-10);
        BoeBot.wait(5000);
        emergencyBreak();
        while(true) {

        }
    }

    public static void goToSpeed(int speed) {
        if (speed < -200 || speed > 200) {
            System.out.println("Invalid input");
            return;
        }
        if (speed == currentSpeed) {
            return;
        }
        if (speed > currentSpeed) {
            int s1Speed = (1500-currentSpeed);
            int s2Speed = (1500+currentSpeed);

            //loop om de speed te krijgen naar 1500 + speed
            while(speed != currentSpeed)
            {
                s1Speed--;
                s2Speed++;
                s1.update(s1Speed);
                s2.update(s2Speed);
                BoeBot.wait(100);
                currentSpeed++;
            }
        }
        if (speed < currentSpeed) {
            int s1Speed = (1500-currentSpeed);
            int s2Speed = (1500+currentSpeed);

            while(speed != currentSpeed)
            {
                s1Speed++;
                s2Speed--;
                s1.update(s1Speed);
                s2.update(s2Speed);
                BoeBot.wait(100);
                currentSpeed--;
            }
        }
    }

    public static void emergencyBreak() {
        System.out.println("Stop!");
        s1.update(1500);
        s2.update(1500);
        currentSpeed = 0;
    }

    public static void turn(int speed) {
        if (speed < -200 || speed > 200) {
            System.out.println("Invalid input");
            return;
        }
        if (speed == currentTurnSpeed) {
            return;
        }
        if (speed > 0) {
            s1.update(1500+speed);
            s2.update(1500+speed);
        }
        if (speed < 0) {
            s1.update(1500 + speed);
            s2.update(1500 + speed);
        }
        currentTurnSpeed = speed;
    }
}