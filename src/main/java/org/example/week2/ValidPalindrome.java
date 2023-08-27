package org.example.week2;

import java.util.function.IntFunction;
import java.util.function.IntPredicate;

// 출처 : https://leetcode.com/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150
public class ValidPalindrome {

    public static void main(String[] args) {
//        charAsciiPractice();

        String s = "A man, a plan, a canal: Panama";
        myValidPalindrome(s);
        myValidPalindromeWithPredicate(s);
        solutionValidPalindrome(s);
    }

    private static boolean myValidPalindrome(String s) {
        int firstIdx = 0;
        int lastIdx = s.length()-1;

        int firstAscii;
        int lastAscii;

        while (firstIdx < lastIdx) {
            firstAscii = s.charAt(firstIdx);
            lastAscii = s.charAt(lastIdx);

            while (firstIdx < lastIdx &&
                    (firstAscii < '0' || (firstAscii > '9' && firstAscii < 'A') || (firstAscii > 'Z' && firstAscii < 'a') || firstAscii > 'z')
            ) {
                firstAscii = s.charAt(++firstIdx);
            }

            while (firstIdx < lastIdx &&
                    (lastAscii < '0' || (lastAscii > '9' && lastAscii < 'A') || (lastAscii > 'Z' && lastAscii < 'a') || lastAscii > 'z')
            ) {
                lastAscii = s.charAt(--lastIdx);
            }

            if (firstAscii != lastAscii) {
                if ((firstAscii >= '0' && firstAscii <= '9') || (lastAscii >= '0' && lastAscii <= '9')) {
                    return false;
                }

                if (Math.abs(firstAscii - lastAscii) != ' ') {
                    return false;
                }
            }

            firstIdx++;
            lastIdx--;
        }

        return true;
    }

    private static boolean myValidPalindromeWithPredicate(String s) {
        int firstIdx = 0;
        int lastIdx = s.length()-1;

        int firstAscii;
        int lastAscii;

        IntPredicate isNum = ascii -> ascii >= '0' && ascii <= '9';
        IntPredicate isNotNum = isNum.negate();

        IntPredicate isLetter = ascii -> (ascii >= 'A' && ascii <= 'Z') || (ascii >= 'a' && ascii <= 'z');
        IntPredicate isNotLetter = isLetter.negate();

        while (firstIdx < lastIdx) {
            firstAscii = s.charAt(firstIdx);
            lastAscii = s.charAt(lastIdx);


            while (firstIdx < lastIdx && isNotNum.and(isNotLetter).test(firstAscii)) {
                firstAscii = s.charAt(++firstIdx);
            }

            while (firstIdx < lastIdx && isNotNum.and(isNotLetter).test(lastAscii)) {
                lastAscii = s.charAt(--lastIdx);
            }

            if (firstAscii != lastAscii) {
                if (isNum.test(firstAscii) || isNum.test(lastAscii)) {
                    return false;
                }

                if (Math.abs(firstAscii - lastAscii) != ' ') {
                    return false;
                }
            }

            firstIdx++;
            lastIdx--;
        }

        return true;
    }

    private static boolean solutionValidPalindrome(String s) {
        // 출처 :  https://1minute-before6pm.tistory.com/25

        s = s.toLowerCase();
        String alphanumericInput = s.replaceAll("[^A-Za-z0-9]", "");

        char[] targets = alphanumericInput.toCharArray();

        int left = 0;
        int right = targets.length-1;
        for(int idx=0; idx < targets.length/2; idx++){
            if(targets[left++] != targets[right--]){
                return false;
            }
        }

        return true;
    }

    private static void charAsciiPractice() {
        int space = ' ';
        int a = 'a';
        int b = 'b';
        int A = 'A';
        int B = 'B';
        int Z = 'Z';
        int z = 'z';
        int comma = ',';
        int colone = ':';
        int zero = '0';
        int one = '1';
        int nine = '9';
        int underscore = '_';
        int bracket = '[';

//        System.out.println(zero + " " + nine + " -> " + (zero - nine));
//        System.out.println(A + " " + Z + " -> " + (A - Z));
//        System.out.println(a + " " + z + " -> " + (a - z));
//        System.out.println(space);
//        System.out.println(b + " " + B + " -> " + (b - B));
//        System.out.println(z + " " + A + " -> " + (z - A));
//        System.out.println(A + " " + z + " -> " + (A - z));
//        System.out.println(comma);
//        System.out.println(colone);
//        System.out.println((97-65) != 32);
//        System.out.println(zero);
//        System.out.println(one);
//        System.out.println(nine);
//        System.out.println(underscore);
//        System.out.println(bracket);
    }
}
