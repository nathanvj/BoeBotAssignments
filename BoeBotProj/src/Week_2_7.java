import TI.*;

public class Week_2_7 {

    public static void main(String[] args) {


        while(true) {

            for(int i =1000;i<=2000;i++) {
                BoeBot.freqOut(8, i, 1);
            }
            for(int i =2000;i>=1000;i--) {
                BoeBot.freqOut(8, i, 1);
            }
        }
    }
}