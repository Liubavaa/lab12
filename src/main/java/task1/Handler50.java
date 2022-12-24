package task1;

public class Handler50 extends Handler {
    @Override
    public void process(int price) throws IllegalArgumentException {
        System.out.println(price / 50 + " * 50");
        Handler next = getNext();
        if (price % 50 > 0 && next == null) {
            throw new IllegalArgumentException();
        }
        else if (next != null) {
            getNext().process(price % 50);
        }
    }
}
