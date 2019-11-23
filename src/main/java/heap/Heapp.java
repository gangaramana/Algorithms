package heap;

public class Heapp {
    final int MAX_SIZE;

    Heapp(int maxsize) {

        MAX_SIZE = maxsize;
    }


    public int left(int i) {
        return 2 * i;
    }

    public int right(int i) {
        return 2 * i + 1;
    }

    public int parent(int i) {
        return (i / 2);
    }


}
