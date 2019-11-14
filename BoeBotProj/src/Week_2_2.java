import TI.*;

public class Week_2_2 {

    public static void main(String[] args) {

        PWM pwm = new PWM(8, 0);
        PWM pwm2 = new PWM(7, 255);

        while(true) {

            for( int i = 0; i < 256; i++) {
                pwm.update(i);
                pwm2.update(255-i);
                BoeBot.wait(1000/256);
            }

            for( int i = 255; i>=0; i--) {
                pwm.update(i);
                pwm2.update(255-i);
                BoeBot.wait(1000/256);
            }
        }
    }
}