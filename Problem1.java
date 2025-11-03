// Time Complexity : O(N) - N - number of digits
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We get the triplet of each number and add suffixes from the suffix array defined except for the first triplet
//We divide the triplet and form the number ie ones from below 20 array and tens from tens array
class Solution {
    String[] thousands = { "", "Thousand", "Million", "Billion" }; //suffix array

    String[] below_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        String res = "";
        int i = 0;
        while (num != 0) {
            //get the triplet
            int triplet = num % 1000;
            if (triplet != 0) {
                res = helper(triplet).trim() + " " + thousands[i] + " " + res;
            }
            i++;
            num = num / 1000;
        }
        return res.trim();

    }

    private String helper(int num) {
        if (num < 20) {
            return below_20[num];
        } else if (num < 100) { //ex:34
            return tens[num / 10] + " " + helper(num % 10);
        } else { // ex: 534
            return below_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
