package back_tracking;

public class TowerOfHanoi {
    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.towerArrange(3,'A','C','B');
    }

    public void towerArrange(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("move disc from " + fromRod + "to  " + toRod);
            return;
        }
        towerArrange(n - 1, fromRod, auxRod, toRod);
        System.out.println("move disc from " + fromRod + "to  " + toRod);
        towerArrange(n - 1, auxRod, toRod, fromRod);
    }
}
