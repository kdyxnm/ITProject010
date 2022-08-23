package Medione.utils;

import java.util.Random;
public class RandomCode {
    private static Random random  = new Random();
    private static final int SIX = 6;
    public static String getRandom(){
        String code= "";
        for (int i = 0; i < SIX; i++) {
            code +=  String.valueOf(random.nextInt(9));
        }

        System.out.println(code);
        return code;
    }
}
