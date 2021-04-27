public class Stack<LL>{
    LinkinPark<LL> stck  = new LinkinPark<LL>();

    public void push(LL data)
    {
        stck.addAtTop(data);
    }

    public LL pop()
    {
        LL x= stck.head.element;
        stck.RemoveFromTop();
        return x;
    }

    public boolean isEmpty()
    {
        return stck.length == 0;
    }

    /*@Override
    public String toString() {
        return "Stack{" +
                "stck=" + stck.Display(); +
                '}';
    }*/

    public void display()
    {
        stck.display();
    }

    public LL peek()
    {
        return  stck.getHead().element;
    }
}