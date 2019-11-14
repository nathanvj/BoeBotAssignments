import TI.*;

public class Week_2_1 {
    public Week_2_1() {
    }

    public static void main(String[] args) {

        PWM pwm = new PWM(8, 0);

        while(true) {
            for( int i = 0; i < 256; i++) {
                pwm.update(i);
                BoeBot.wait(2000/256);
            }

        }
    }
}
