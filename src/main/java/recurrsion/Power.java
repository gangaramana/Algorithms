package recurrsion;

public class Power {
    public static void main(String[] args) {
        Power power = new Power();
        int x=power.power(10, 4);
        System.out.println(x);

    }

    public int power(int base, int pow) {
        if (pow > 0) {
            return base * power(base, pow - 1);
        }
        return 1;

    }
}
