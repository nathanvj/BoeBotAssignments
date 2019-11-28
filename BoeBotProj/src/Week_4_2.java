import TI.*;

public class Week_4_2 {

    static int speed = 200;

    static Servo s1 = new Servo(12);
    static Servo s2 = new Servo(13);

    static int middleLineSensorValue;
    static int leftLineSensorValue;
    static int rightLineSensorValue;

    public static void main(String[] args) {

        s1.update(1700);
        return;

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
                s1.update(1500 + speed);
                s2.update(1500 - speed);
            }
            else if(leftLineSensorValue >= 200 && middleLineSensorValue < 200 && rightLineSensorValue < 200)
            {
                s1.update(1500 - speed);
                s2.update(1500 + speed);
            }
            else if(rightLineSensorValue >= 200 && middleLineSensorValue < 200 && leftLineSensorValue < 200)
            {
                // stuur naar rechts bij
            }
            else if(leftLineSensorValue >= 200 && middleLineSensorValue >= 200 && rightLineSensorValue < 200)
            {
                // draai -90
            }
            else if(rightLineSensorValue >= 200 && middleLineSensorValue >= 200 && leftLineSensorValue < 200)
            {
                // draai 90
            }
            else if(rightLineSensorValue >= 200 && middleLineSensorValue >= 200 && leftLineSensorValue >= 200)
            {
                // kruising doe iets
            }

            BoeBot.wait(10);
        }
    }


}
