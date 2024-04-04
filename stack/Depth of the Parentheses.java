// Approach 1: Using stack
class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int sLen = s.length();
        int depth = 0;
        for (int i = 0; i < sLen; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push('(');
            } else if (ch == ')') {
                st.pop();
            }
            depth = Math.max(depth, st.size());
        }
        return depth;
    }
}

// Approach 2: Without stack
class Solution {
    public int maxDepth(String s) {
        int openBracketCount = 0;
        int sLen = s.length();
        int depth = 0;
        for (int i = 0; i < sLen; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                openBracketCount++;
            } else if (ch == ')') {
                openBracketCount--;
            }
            depth = Math.max(depth, openBracketCount);
        }
        return depth;
    }
}