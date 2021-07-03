/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abuslabweek7;

/**
 * RecursionApp.java N Varadi 11 03 2021
 */
public class RecursionApp {

    /**
     * @param str
     * @return
     */
    //Exercise 1: count "hi" substring occurences in a string
    public int countHi(String str) {
        if (str.length() < 2) { //base case 
            return 0;//if string is shorter than 2 char, it's not possible to find "hi" in it
        } else if (str.substring(0, 2).equalsIgnoreCase("hi")) {//check if first 2 letters were hi
            return 1 + countHi(str.substring(2));
        } else {//if first 2 letters are not hi, keep checking from second char onwards
            return countHi(str.substring(1));
        }
    }

    //Exercise 2: remove all occurences of letter 'x' from a string
    public String removeX(String str) {
        if (str.length() == 0) {//if the string is empty, there's no char x in it
            return " ";//base case
        } else if (str.charAt(0) == 'x') {//check if first letter was x
            return removeX(str.substring(1));//keep on checking if any subsequent char was x
        } else {
            return str.charAt(0) + removeX(str.substring(1));
        }
    }

    //Exercise 3: check if array has a number followed by number*10, start the check from a specific index
    public boolean containsTimesTen(int[] arr, int index) {

        if (index >= arr.length - 1) {//if the specified index number is invalid
            return false;//base case
        } else if ((arr[index] * 10) == arr[index + 1]) {//check if the number at the given index * 10 was equal to the next number
            return true;
        } else {
            return containsTimesTen(arr, index + 1); //move on the the next index
        }

    }

    //Exercise 4: Move letter x in a string to the end of string
    public String moveXToEnd(String str) {
        int position = str.indexOf('x');//find index position of letter x in the string
        if (position < 0 || str.length() == 0) {//if x is not found in the string or the string is empty
            return str;
        } else {
            //first, chop the string into 2 sections:
            //from the 1st letter until the position of x,
            //then concatenate the rest of the string to it, after the postion of x, then add x at the end 
            return str.substring(0, position) + moveXToEnd(str.substring(position + 1)) + 'x';
        }

    }

    //Exercise 5: return the sum of the digits of an integer n
    public int sumDigits(int n) {
        if (n == 0) {//base case
            return 0;
        } else {

            //first, using modulus operator, find the remainder when dividing the number by 10(result will be between 0 and 9)
            //then, we call our method recursively, dividing the number by 10, the result will be between 0 and 9
            //finally, we add the result of the 2 operations
            return (n % 10 + sumDigits(n / 10));
        }
    }

    //Exercise 6: change all letter x to letter y in a string
    public String swapCharacter(String str, char from, char to) {
        if (str.length() < 1) {//base case, string is shorter than 1 char
            return str;
        } else {
            for (int i = 0; i < str.length(); i++) {//loop through the whole string
                if (str.charAt(i) == from) {//wherever the char is the one we want to swap away
                    str = str.substring(0, i) + to + str.substring(i + 1);//grab the chars of the string from the first one to the position of x
                    //concatenate the char we want to use as replacement(y), concatenate the rest of the string to it
                    return swapCharacter(str, from, to);//call method recursively until the whole string is checked
                }
            }
            return str;
        }
    }

    //Exercise 7: return a string without adjacent duplicate characters in it: "yyzzza -> yza"
    public String noDuplicateChars(String str) {

        if (str.length() <= 1) {//base case
            return str;//if the string only contains 1 or less characters, there could be no duplicates
        } else if (str.charAt(0) == str.charAt(1)) {//if 1st and 2nd chars are the same
            return noDuplicateChars(str.substring(1));//call method recursively, continue checking the string from index 1 onwards
        } else {
            return str.charAt(0) + noDuplicateChars(str.substring(1));
        }
    }

    public static void main(String[] args) {      
        RecursionApp rec = new RecursionApp();
        System.out.println(rec.countHi("hippopotamushi"));

        System.out.println(rec.removeX("ilovexjavax"));

        int[] intArray = {1, 10, 2, 3, 30};
        System.out.println(rec.containsTimesTen(intArray, 3));

        System.out.println(rec.moveXToEnd("IxlovexJava"));

        int number = 111;
        int result = rec.sumDigits(number);
        System.out.println(result);

        String str = "xerox";
        char from = 'x';
        char to = 'y';
        String newString = rec.swapCharacter(str, from, to);
        System.out.println(newString);

        System.out.println(rec.noDuplicateChars("yyzza"));
    }

}
