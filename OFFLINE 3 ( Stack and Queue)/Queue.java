
public class Queue<LL>{
    LinkinPark<LL> q  = new LinkinPark<LL>();


    public void enq(LL data)
    {
        q.addAtLast(data);
    }

    public LL deq()
    {
        LL x= q.getHead().element;
        q.RemoveFromTop();
        return x;
    }

    public boolean isEmpty()
    {
        return q.length == 0;
    }
    public void display()
    {
        q.display();
    }
    public LL peek()
    {
        return  q.getHead().element;
    }

}