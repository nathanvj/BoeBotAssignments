import TI.*;

public class Week_3_1 {


    private static int currentBtn;
    public static void main(String[] args)
    {
        System.out.println("luisteren");
        int[] lengtes = new int[12];

        while(true)
        {
            readIRSignal(lengtes);
            BoeBot.wait(10);
        }

    }

    public static void readIRSignal(int[] lengtes)
    {
        int pulseLength = BoeBot.pulseIn(0, false, 6000);
        if (pulseLength > 2000)
        {

            for (int i = 0; i < 12; i++)
                lengtes[i] = BoeBot.pulseIn(0, false, 20000);

            /*for(int i=0 ; i<12 ; i++)
                System.out.println(lengtes[i] + ", ");*/
            System.out.println("");
            currentBtn = getNumber(lengtes);
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
        if (total > 10) {
            return -1;
        }
        return total;
    }
}
