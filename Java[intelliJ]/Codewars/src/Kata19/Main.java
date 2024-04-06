package Kata19;

/**
 * Complete the solution so that it strips all text that follows any of a set of comment markers passed in. Any whitespace at the end of the line should also be stripped out.
 * <p>
 * Example:
 * <p>
 * Given an input string of:
 * <p>
 * apples, pears # and bananas
 * <p>
 * grapes
 * <p>
 * bananas !apples
 * <p>
 * The output expected would be:
 * <p>
 * apples, pears
 * <p>
 * grapes
 * <p>
 * bananas
 * <p>
 * The code would be called like so:
 * <p>
 * var result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"])
 * // result should == "apples, pears\ngrapes\nbananas"
 */
public class Main {
    public static void main(String[] args) {
        String str = "apples, pears # and bananas\ngrapes\nbananas !apples";
        String[] symbols = {"#", "!"};
        System.out.println("\n\nOrignal:\n"+str);
        System.out.println("\nPost:\n"+stripComments(str, symbols));

        str = "a #b\nc\nd $e f g";
        symbols = new String[]{"#", "$"};
        System.out.println("\n\nOrignal:\n"+str);
        System.out.println("\nPost:\n"+stripComments(str, symbols));

        str = "a #b\n[ ]c\nd $e f g";
        symbols = new String[]{"#", "$"};
        System.out.println("\n\nOrignal:\n"+str);
        System.out.println("\nPost:\n"+stripComments(str, symbols));
    }

    public static String stripComments(String text, String[] commentSymbols) {
        StringBuilder str = new StringBuilder();
        String[] lines = text.split("\n");
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            int index = line.length();
            for (String commentSymbol : commentSymbols) {
                if (line.contains(commentSymbol) && index > line.indexOf(commentSymbol)) {
                    index = line.indexOf(commentSymbol);
                }
            }
            str.append(line.substring(0, index).stripTrailing());
            if (i != lines.length - 1) str.append("\n");
        }
        return str.toString();
    }

    public static String stripCommentsB(String text, String[] commentSymbols) {
        //return text.replaceAll("(?m)\\h*([" + String.join("",commentSymbols) + "].*)?$", "");
        return text.replaceAll(" *([" + String.join("", commentSymbols) + "].*)?(\n|$)", "$2");
    }
}
