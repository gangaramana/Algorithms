package recurrsion;

public class PrintBinary {
    public static void main(String[] args) {
        PrintBinary printBinary = new PrintBinary();
        String x=printBinary.binary(63);
        System.out.println(x);
    }

    public String binary(int num) {
        if (num > 0) {
            return binary(num / 2) + "" + num % 2;
        }
        return "";
    }


}
