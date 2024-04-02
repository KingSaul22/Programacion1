package Kata9;

import java.util.*;

/**
 * Given an array (arr) as an argument complete the function countSmileys that should return the total number of smiling faces.
 * <p><p>
 * Rules for a smiling face:
 * <p>
 * Each smiley face must contain a valid pair of eyes. Eyes can be marked as : or ;
 * <p>
 * A smiley face can have a nose but it does not have to. Valid characters for a nose are - or ~
 * <p>
 * Every smiling face must have a smiling mouth that should be marked with either ) or D
 * <p>
 * No additional characters are allowed except for those mentioned.
 * <p>
 * Valid smiley face examples: :) :D ;-D :~)
 * <p>
 * Invalid smiley faces: ;( :> :} :]
 * <p><p>
 * Example
 * <p>
 * countSmileys([':)', ';(', ';}', ':-D']);       // should return 2;
 * <p>
 * countSmileys([';D', ':-(', ':-)', ';~)']);     // should return 3;
 * <p>
 * countSmileys([';]', ':[', ';*', ':$', ';-D']); // should return 1;
 * <p><p>
 * Note
 * <p>
 * In case of an empty array return 0. You will not be tested with invalid input (input will always be an array). Order of the face (eyes, nose, mouth) elements will always be the same.
 */
public class Main {
    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add(":)");
        a.add(":D");
        a.add("X-}");
        a.add("xo)");
        a.add(":X");
        a.add(":-3");
        a.add(":3");

        System.out.println(countSmileys(a));
        System.out.println(countSmileysB(a));

    }

    public static int countSmileys(List<String> arr) {
        int smile = 0;
        String[] auxArr = arr.toArray(new String[0]);

        for (String str : auxArr) {

            if (str.charAt(0) == ':' || str.charAt(0) == ';') {

                if (str.charAt(1) == '-' || str.charAt(1) == '~') {
                    if (str.charAt(2) == ')' || str.charAt(2) == 'D') {
                        if (str.length() == 3) {
                            smile++;
                        }
                    }

                } else if (str.charAt(1) == ')' || str.charAt(1) == 'D') {
                    if (str.length() == 2) {
                        smile++;
                    }
                }
            }
        }

        // Just Smile :)
        return smile;
    }

    public static int countSmileysB(List<String> arr) {
        int smile = 0;
        String[] auxArr = arr.toArray(new String[0]);

        for (String str : auxArr) {

            if (str.charAt(0) == ':' || str.charAt(0) == ';') {

                if (str.length() == 2 && (str.charAt(1) == ')' || str.charAt(1) == 'D')) {
                    smile++;

                } else if (str.length() == 3 && (str.charAt(1) == '-' || str.charAt(1) == '~') && (str.charAt(2) == ')' || str.charAt(2) == 'D')) {
                    smile++;
                }
            }
        }

        // Just Smile :)
        return smile;
    }
}
