package dynamic_programming;

public class ReverseString {
    public static void main(String[] args) {
       char[] x= new char []{'h','e','l','l','o'};
        ReverseString r = new ReverseString();
        r.reverseString(x);
        for (char c:x){
            System.out.print(c+"  ");

        }
    }


    public void reverseString(char[] s) {
        String x = palindromeHelper(s, s.length - 1);
        s = x.toCharArray();



    }

    public String palindromeHelper(char[] str, int len) {
        if (len >= 0) {
            return str[len] + palindromeHelper(str, len - 1);
        }
        return "";
    }
}
