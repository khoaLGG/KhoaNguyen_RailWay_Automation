package Common.Common;


import java.util.Random;


public class GenerateSuffixOfEmail {

    private static final String alpha = "abcdefghijklmnopqrstwvxyzABCDEFGHIJKLMNOPQRSTWVXYZ";
    private static final String digits = "0123456789";


    public static String GenRandomString() {
        int rdText;
        int rdNumber;
        String randomString = "";
        Random rd = new Random();
        for (int i = 0; i < 3; i++) {
            rdText = rd.nextInt(alpha.length() - 1);
            randomString+=(Character.toString(alpha.charAt(rdText)));
            rdNumber = rd.nextInt(digits.length() - 1);
            randomString+=(Character.toString(digits.charAt(rdNumber)));
        }
        return randomString ;
    }

    public static void main(String a[]) {

        System.out.println(GenRandomString() + "@"+GenRandomString()+".com");
    }
}


