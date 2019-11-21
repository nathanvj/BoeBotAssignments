import TI.*;

public class Week_3_1 {

    private static Servo servo1 = new Servo(12);
    private static Servo servo2 = new Servo(13);

    private static int speed = 2;
    private static int currentBtn;

    public static void main(String[] args)
    {
        System.out.println("luisteren");
        int[] lengtes = new int[12];

        while(true)
        {
            readIRSignal(lengtes);
            BoeBot.wait(10);

            switch(currentBtn)
            {
                case 1:
                    servo1.update(1500 - (50 * speed));
                    servo2.update(1500 + (20 * speed));
                    break;
                case 2:
                    servo1.update(1500 - (50 * speed));
                    servo2.update(1500 + (50 * speed));
                    break;
                case 3:
                    servo1.update(1500 - (20 * speed));
                    servo2.update(1500 + (50 * speed));
                    break;
                case 4:
                    servo1.update(1500 - (50 * speed));
                    servo2.update(1500 - (50 * speed));
                    currentBtn = 0;
                    break;
                case 5:
                    servo1.update(1500);
                    servo2.update(1500);
                    break;
                case 6:
                    servo1.update(1500 + (50 * speed));
                    servo2.update(1500 + (50 * speed));
                    break;
                case 7:
                    servo1.update(1500 + (50 * speed));
                    servo2.update(1500 - (20 * speed));
                    break;
                case 8:
                    servo1.update(1500 + (50 * speed));
                    servo2.update(1500 - (50 * speed));
                    break;
                case 9:
                    servo1.update(1500 + (20 * speed));
                    servo2.update(1500 - (50 * speed));
                    break;
                case 19:
                    if(speed < 5) speed++;
                    break;
                case 20:
                    if(speed > 1) speed--;
                    break;
                default:
                    BoeBot.wait(10);
            }
            currentBtn = 0;
            BoeBot.wait(10);
        }

    }

    /**
     * Reads IR signal to databits in int array
     * @param lengtes The array that gets filled with databits
     */
    public static void readIRSignal(int[] lengtes)
    {
        int pulseLength = BoeBot.pulseIn(0, false, 6000);
        if (pulseLength > 2000)
        {

            for (int i = 0; i < 12; i++)
                lengtes[i] = BoeBot.pulseIn(0, false, 20000);

            /*for(int i=0 ; i<12 ; i++)
                System.out.println(lengtes[i] + ", ");
            System.out.println("");*/
            currentBtn = getNumber(lengtes);
            //System.out.println(getNumber(lengtes));
        }
    }

    /**
     * converts the first 7 bits of a 12 digit signal to the corresponding button
     * @param array The received signal
     * @return the corresponding button on the TV remote, -1 if input is invalid
     */
    public static int getNumber(int[] array) {
        int total = 0;
        for(int i=1; i<=7 ; i++ ) {
            if (array[i-1] < 0) {
                return -1;
            }
            if (array[i-1] > 900)
            total+= (Math.pow(2, i)) / 2 ;
        }
        total+=1;
        if (total == 10) {
            return 0;
        }
        return total;
    }
}
