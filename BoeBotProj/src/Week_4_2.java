import TI.*;

public class Week_4_2 {

    static Servo leftServo = new Servo(12);
    static Servo rightServo = new Servo(13);

    static int middleLineSensorValue;
    static int leftLineSensorValue;
    static int rightLineSensorValue;

    public static void main(String[] args) {

        System.out.println("Spoorzoeken...");
        while(true) {
            middleLineSensorValue = BoeBot.analogRead(0);
            leftLineSensorValue = BoeBot.analogRead(1);
            rightLineSensorValue = BoeBot.analogRead(2);

            System.out.print(leftLineSensorValue);
            System.out.print(" middle: "+middleLineSensorValue);
            System.out.print(" right: "+rightLineSensorValue);
            System.out.println();
            /*
            Als alleen midden hoog -> blijven rijden
            Als alleen links hoog -> stuur naar links bij
            Als alleen rechts hoog -> stuur naar rechts bij
            Als links en midden hoog -> draai -90 graden
            Als rechts midden hoog -> draai 90 graden
            Als midden, links en rechts hoog -> kruising
             */
            BoeBot.wait(50);
            if(middleLineSensorValue >= 200 && leftLineSensorValue < 200 && rightLineSensorValue < 200)
            {
                leftServo.update(1540);
                rightServo.update(1460);
            }
            else if(leftLineSensorValue >= 200 && middleLineSensorValue < 200 && rightLineSensorValue < 400)
            {
                // stuur links
                int rightPulseWidth = rightServo.getPulseWidth();
                leftServo.update(1600);
            }
            else if(rightLineSensorValue >= 400 && middleLineSensorValue < 400 && leftLineSensorValue < 400)
            {
                // stuur naar rechts bij
                int leftPulseWidth = leftServo.getPulseWidth();
                rightServo.update(1400);
            }
            else if(leftLineSensorValue >= 400 && middleLineSensorValue >= 400 && rightLineSensorValue < 400)
            {
                rightServo.update(1500);
                leftServo.update(1650);
                BoeBot.wait(500);
                // draai -90
            }
            else if(rightLineSensorValue >= 400 && middleLineSensorValue >= 400 && leftLineSensorValue < 400)
            {
                leftServo.update(1500);
                rightServo.update(1350);
                BoeBot.wait(500);
                // draai 90
            }
            else if(rightLineSensorValue >= 400 && middleLineSensorValue >= 400 && leftLineSensorValue >= 400)
            {
                Week_2_5.emergencyBreak();
                // kruising doe iets
            }

            BoeBot.wait(50);
        }
    }


}
