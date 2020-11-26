/**
 * . Given a string , transform It and return a string so that aabbcc -> a2b2c2
 * , abb -> a1b2 , aaba -> a2b1a1
 */

public class StringNumberCount {
    public static void main(String[] args) {
        System.out.println(transform("aabbcc"));
        System.out.println(transform("a"));
        System.out.println(transform(""));
        System.out.println(transform("wwwwaaadexxxxxx"));
    }

    public static String transform(String input) {
        if (input == null) return "";
        String result = "";
        int currentCharCount = 0;
        char currentChar = '\'';

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == currentChar) {
                currentCharCount += 1;
            } else {
                if (currentCharCount > 0) {
                    result += currentChar + Integer.toString(currentCharCount);
                }
                currentChar = input.charAt(i);
                currentCharCount = 1;
            }
        }

        if (currentCharCount > 0) {
            result += currentChar + Integer.toString(currentCharCount);   
        }

        return result;
    }
}
