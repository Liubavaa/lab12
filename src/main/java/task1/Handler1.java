package task1;

public class Handler1 extends Handler {
    @Override
    public void process(int price) throws IllegalArgumentException {
        System.out.println(price + " * 1");
        Handler next = getNext();
        if(next != null){
            getNext().process(0);
        }
    }
}