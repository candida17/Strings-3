// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Using the concept of tail, we evaulate the expression
//tail is the action taken on the current number
//When the operator is / or * which takes higher precedence than + and - the tail becomes helpful to undo the prev action on current number
class Solution {
    public int calculate(String s) {
        int tail = 0;
        int calc = 0;
        char op = '+';
        int curNum = 0;

        for(int i = 0; i < s.length(); i++) {
            //if i is a digit
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                curNum = curNum * 10 + ch - '0';
            }
            //if i is operator or the last element and not a space
            if(!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                if(op == '+') {
                    calc = calc + curNum;
                    tail = curNum;

                } else if(op == '-') {
                    calc = calc - curNum;
                    tail = -curNum;

                } else if(op == '*') {
                    calc = calc - tail + tail * curNum;
                    tail = tail * curNum;

                } else {
                    //for division 
                    calc = calc - tail + (tail/curNum);
                    tail = tail / curNum;
                }
                op = ch;
                curNum = 0;
            }
        }
        return calc;
        
    }
}
