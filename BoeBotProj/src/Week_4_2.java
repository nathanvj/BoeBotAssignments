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

            /*
            Als alleen midden hoog -> blijven rijden
            Als alleen links hoog -> stuur naar links bij
            Als alleen rechts hoog -> stuur naar rechts bij
            Als links en midden hoog -> draai -90 graden
            Als rechts midden hoog -> draai 90 graden
            Als midden, links en rechts hoog -> kruising
             */
            if(middleLineSensorValue >= 200 && leftLineSensorValue < 200 && rightLineSensorValue < 200)
            {
                leftServo.update(1530);
                rightServo.update(1470);
            }
            else if(leftLineSensorValue >= 200 && middleLineSensorValue < 200 && rightLineSensorValue < 200)
            {
                // stuur links
                int rightPulseWidth = rightServo.getPulseWidth();
                rightServo.update(1450);
            }
            else if(rightLineSensorValue >= 200 && middleLineSensorValue < 200 && leftLineSensorValue < 200)
            {
                // stuur naar rechts bij
                int leftPulseWidth = leftServo.getPulseWidth();
                leftServo.update(1550);
            }
            else if(leftLineSensorValue >= 200 && middleLineSensorValue >= 200 && rightLineSensorValue < 200)
            {
                Week_2_5.emergencyBreak();
                // draai -90
            }
            else if(rightLineSensorValue >= 200 && middleLineSensorValue >= 200 && leftLineSensorValue < 200)
            {
                Week_2_5.emergencyBreak();
                // draai 90
            }
            else if(rightLineSensorValue >= 200 && middleLineSensorValue >= 200 && leftLineSensorValue >= 200)
            {
                Week_2_5.emergencyBreak();
                // kruising doe iets
            }

            BoeBot.wait(10);
        }
    }


}
