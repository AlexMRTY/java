import java.util.Stack;

class Solution {
    public static String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i=0 ; i<s.length() ; i++) {
            lastIndex[s.charAt(i) - 'a'] = i+1;
        }

        boolean[] seen = new boolean[26];

        Stack<Character> stack = new Stack<>();

        stack.push(s.charAt(0));
        seen[s.charAt(0) - 'a'] = true;
        for (int i=1 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if (seen[c - 'a']) {continue;}
//            if (stackTop > c) {                         // Check if stackTop is smaller than c.
//                if (lastIndex[stackTop - 'a'] > i) {        // Check if stackTop exists later in the string s.
//                    seen[stack.pop() - 'a'] = false;
//                    stack.push(c);
//                    seen[c - 'a'] = true;
//                    continue;
//                }
//            }
            while (stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                    seen[stack.pop() - 'a'] = false;
                    if (stack.isEmpty()) {break;}
            }
            stack.push(c);                    // If stackTop does not exist later in the string just push c to stack.
            seen[c - 'a'] = true;

        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.append((char)stack.pop());
        }
        return result.reverse().toString();
    }
}