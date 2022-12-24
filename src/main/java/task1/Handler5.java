package task1;

public class Handler5 extends Handler{
    @Override
    public void process(int price) throws IllegalArgumentException {
        System.out.println(price/ 5 + " * 5");
        Handler next = getNext();

        if (price % 5 > 0 && next == null) {
            throw new IllegalArgumentException();
        }
        else if(next != null){
            getNext().process(price % 5);
        }
    }
}
