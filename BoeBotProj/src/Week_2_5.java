import TI.*;

public class Week_2_5 {

    static Servo s1 = new Servo(12);
    static Servo s2 = new Servo(13);
    static int currentSpeed = 0;
    static int currentTurnSpeed = 0;

    public static void main(String[] args) {

        s1.update(1500);
        s2.update(1500);

        BoeBot.wait(10000);
        doCircle();

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
                BoeBot.wait(20);
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
                BoeBot.wait(20);
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
        currentTurnSpeed = 0;
    }


    public static void turnDegrees(int degrees, int turnSpeed) {
        double time = (double) degrees / (double) turnSpeed / 2.28;
        turn(turnSpeed);
        time *= 1000;
        int timeInt = (int) Math.round(time);
        BoeBot.wait(timeInt);
        s1.update(1500);
        s2.update(1500);
    }

    public static void doSquare() {
        goToSpeed(40);
        BoeBot.wait(3000);
        emergencyBreak();
        turnDegrees(90, 20);
        goToSpeed(40);
        BoeBot.wait(3000);
        emergencyBreak();
        turnDegrees(90, 20);
        goToSpeed(40);
        BoeBot.wait(3000);
        emergencyBreak();
        turnDegrees(90, 20);
        goToSpeed(40);
        BoeBot.wait(3000);
        emergencyBreak();
        turnDegrees(90, 20);
    }

    public static void doCircle() {

        /*for (int i = 0; i < 36; i++) {
            s1.update(1430);
            s2.update(1570);
            BoeBot.wait(100);
            turnDegrees(10, 60);
        }*/
        s1.update(1440);
        s2.update(1600);
        BoeBot.wait(10000);
        emergencyBreak();
    }
}