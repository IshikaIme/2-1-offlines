public class LinkinPark <LL>{
      public static class Node<LL>
    {
        LL element;
        Node<LL> next;

        public Node(LL data)
        {
            this.element= data;
            this.next=null;
        }

        public Node()
        {
            this.element= null;
            this.next=null;
        }
    }

    public Node<LL> getHead() {
        return head;
    }

    public void setHead(Node<LL> head) {
        this.head = head;
    }

    Node<LL> head,tail;
    int length=0;

    public LinkinPark()
    {
        head= tail=null;
    }
//    public LinkinPark(String s)
//    {
//        String [] token= new String.split(" ")
//        length=s.length;
//        for(int i=0; i<length; i++)
//            this.addAtLast(s);
//    }

    public void addAtLast(LL x) {
        Node<LL> addnode = new Node<>(x);
        if (head == null) {
            tail = head = addnode;
            head.next = null;

        } else {
            tail.next = addnode;
            tail = addnode;

        }
        length = length + 1;

    }
    public void addAtTop(LL first)
    {

        Node<LL> newtop= new Node<>(first);
        newtop.next=head;
        head=newtop;
        length=length+1;
    }
    public void RemoveFromTop()
    {

        //System.out.println("Removed item is "+ head.element);
        head= head.next;
        length=length-1;


    }


    public void display()
    {
        Node<LL> printnode=head;
        while ((printnode)!=null){
            System.out.println(printnode.element);
            printnode= printnode.next;

        }
    }


}
