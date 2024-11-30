package edu.gematria;

public class Calc {

    public static int calc(/*@org.jetbrains.annotations.NotNull*/ String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); ++ i) {
            // vals += String.valueOf((int)str.charAt(i)) + " ";
            // Aleph's unicode
            if ((int)str.charAt(i) >= 1488 && (int)str.charAt(i) <= (1488+10-1)) {
                // vals += "* ";
                sum += (int)str.charAt(i) - (1488-1);
            }
            else if ((int)str.charAt(i) == 1488+10 || (int)str.charAt(i) == 1488+11) {
                sum += 20;
            }
            else if ((int)str.charAt(i) == 1488+12) {
                sum += 30;
            }
            else if ((int)str.charAt(i) == 1488+13 || (int)str.charAt(i) == 1488+14) {
                sum += 40;
            }
            else if ((int)str.charAt(i) == 1488+15 || (int)str.charAt(i) == 1488+16 || (int)str.charAt(i) == 1487 /* U+05C6 Hebrew Punctuation Nun Hafukha */ ) {
                sum += 50;
            }
            else if ((int)str.charAt(i) == 1488+17) {
                sum += 60;
            }
            else if ((int)str.charAt(i) == 1488+18) {
                sum += 70;
            }
            else if ((int)str.charAt(i) == 1488+19 || (int)str.charAt(i) == 1488+20) {
                sum += 80;
            }
            else if ((int)str.charAt(i) == 1488+21 || (int)str.charAt(i) == 1488+22) {
                sum += 90;
            }
            else if ((int)str.charAt(i) >= 1488+23 && (int)str.charAt(i) <= 1488+23+4-1) {
                sum += 100 * ((int)str.charAt(i) - (1488+23) + 1);
            }
        }
        return sum;
    }
}