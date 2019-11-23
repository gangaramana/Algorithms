package recurrsion;

public class PalindromeRecurrsion {
    public static void main(String[] args) {
        PalindromeRecurrsion palindromeRecurrsion = new PalindromeRecurrsion();
       boolean b= palindromeRecurrsion.palindrome("able was i ere i saw elba");
        System.out.println(b);
    }

    public boolean palindrome(String s) {
        String x = palindromeHelper(s, s.length() - 1);
        if (x.equalsIgnoreCase(s)) {
            return true;
        } else {
            return false;
        }


    }

    public String palindromeHelper(String str, int len) {
        if (len >= 0) {
            return str.charAt(len) + palindromeHelper(str, len - 1);
        }
        return "";
    }
}
