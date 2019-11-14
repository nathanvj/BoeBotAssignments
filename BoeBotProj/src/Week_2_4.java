import TI.*;

public class Week_2_4 {

    public static void main(String[] args) {

        Servo s1 = new Servo(12);
        Servo s2 = new Servo(13);

        s1.update(1500);
        s2.update(1500);

        boolean duration = true;
        while(duration) {
            for(int i = 0; i <= 200; i += 10) {
                s1.update(1500+i);
                //s2.update(1500-i);
                System.out.println("S1: "+(1500+i));
                System.out.println("S2: "+(1500-i));
                BoeBot.wait(2000);

            }
            s1.update(1500);
            s2.update(1500);

            duration = false;

        }
    }
}