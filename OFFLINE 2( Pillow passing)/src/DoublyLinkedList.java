import java.net.PortUnreachableException;
import java.util.Scanner;

public class DoublyLinkedList {
    Node start;
    int direction;
    Node currentplayer;
    int totalsum=0;


    public Node getCurrentplayer(int time) throws NullPointerException {
        Node temp= currentplayer;
        if(totalsum>time) {
            System.out.println("Sorry , time can't be reversed.");
            return null;
        }

        while((totalsum + temp.reflex)<time)
        {
            totalsum = totalsum + temp.reflex;


            if(direction>0) {

                temp = temp.next;
                currentplayer= temp;

            }
            else {

                temp = temp.previous;
                currentplayer= temp;
            }

        }

        return currentplayer;
    }


    public class Node {
        int player;
        Node next;
        Node previous;
        int reflex;
    }

    public DoublyLinkedList()
    {
        start=null;
        direction=1;

    }

    void showlists(int direction) {

        Node temp = start;

        if(direction==1) {
            System.out.println("Traversal in forward direction ");
            while (temp.next != start) {
                System.out.print( "Player " +temp.player+ "  " );
                temp = temp.next;
            }
            System.out.print("Player " +temp.player+ "  " );
        }
        if(direction==-1) {
            System.out.println("Traversal in reverse direction ");
            Node last = start;
            temp = last;
            while (temp.previous != last) {
                System.out.print( "Player " +temp.player+ " " );
                temp = temp.previous;
            }
            System.out.print("Player " +temp.player+ " " );

        }
    }

    void showlists(int i,int direction) {

        Node x= getCurrentplayer(i);
        Node temp = x;

        if(direction==1) {
            System.out.print("Traversal in forward direction : Player ");
            while (temp.next != x) {
                System.out.print( temp.player+ " , " );
                temp = temp.next;
            }
            System.out.println(temp.player );
        }
        if(direction==-1) {
            System.out.print("Traversal in backward direction : Player ");
            Node last = x;
            temp = last;
            while (temp.previous != last) {
                System.out.print( temp.player+ " , " );
                temp = temp.previous;
            }
            System.out.println(temp.player );

        }
    }






    public void add(int i, int x) {


        if (i == 0) {
            Node head = new Node();
            head.player = i+1;
            head.reflex = x;
            head.previous = head;
            head.next = head;
            start = head;
            currentplayer= start;
        } else {
            Node newnode = new Node();
            newnode.player=i+1;
            newnode.reflex=x;
            newnode.next = start;
            newnode.previous = (start).previous;

            (start.previous).next = newnode;
            start.previous = newnode;


        }
    }

    public void addBefore(int time,int n, int x) {

        Node i= getCurrentplayer(time);

        //  start= getCurrentplayer(time);
        Node newnode = new Node();
        newnode.player=n;
        newnode.reflex=x;
        newnode.next=i;
        newnode.previous=i.previous;

        (i.previous).next= newnode;
        i.previous= newnode;
        // int pos= i.previous.player;
        //add(n, x);

        currentplayer= i;
    }

    public void addAfter(int time,int n, int x) {

        Node i= getCurrentplayer(time);

        //  start= getCurrentplayer(time);
        Node newnode = new Node();
        newnode.player=n;
        newnode.reflex=x;
        newnode.previous=i;
        newnode.next=i.next;

        (i.next).previous= newnode;
        i.next= newnode;
        // int pos= i.previous.player;
        //add(n, x);

        currentplayer= i;
    }

    public void Reverse(int t)
    {
        Node cc= new Node();
        cc=getCurrentplayer(t);

        if (direction == 1)
            direction = -1;
        else
            direction = 1;
    }

    public void remove(int t)
    {
        Node c= getCurrentplayer(t);

        (c.previous).next = c.next;
        (c.next).previous = c.previous;
        totalsum =  t;

        if(direction>0) {

            currentplayer=c.next;
        }
        else if(direction<0) {

            currentplayer=c.previous;
        }


    }


    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();

        int win=0, winningplayer=0;

        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int i;
        for (i = 0; i < n; i++) {
            dl.add( i,sc.nextInt());

        }

        Scanner scanner= new Scanner(System.in);

        while (1==1) {

            String str = new String();
            str = scanner.nextLine();
            String[] s = str.split(" ");
            //for (String a : s)
            //  System.out.println(a);
            int index = Integer.parseInt(s[0]);
            int newRT;
            String command = s[1];
            if( (command.equals("I"))&&win!=1) {
                newRT = Integer.parseInt(s[2]);
                if(dl.direction>0) {

                    dl.addBefore(index, ++n, newRT);
                }

                else if(dl.direction<0)
                    dl.addAfter(index, ++n, newRT);

                // dl.showlists(index, dl.direction);

            }

            //  dl.showlists(dl.direction);
            if ((command.equals("R"))&& win!=1) {
                dl.Reverse(index);
                // dl.showlists(index, dl.direction);

            }
            if ((command.equals("F"))&& win!=1) {
                System.out.println("Game Over!! "+"Player " + dl.getCurrentplayer(index).player+" is holding the pillow at "+ index +" seconds" );
                System.out.print("Pillow passing sequence :"  );
                dl.showlists(index, dl.direction);
                break;

            }


            if ((command.equals("P"))&& win!=1) {
                System.out.println("Player " + dl.getCurrentplayer(index).player + " is holding the pillow at t="+ index +" seconds");
                // dl.showlists(index, dl.direction);
            }

            if(((command.equals("M"))&& win!=1))
            {

                System.out.println("Player " + dl.getCurrentplayer(index).player + " has been eliminated at t=" + index+" seconds ");
                dl.remove(index);
                // dl.showlists(index, dl.direction);

                if(dl.getCurrentplayer(index).previous==dl.getCurrentplayer(index))
                {
                    winningplayer= dl.getCurrentplayer(index).player;
                    // System.out.println("Game over : Player "+ dl.getCurrentplayer(index).player+ " wins!!");
                    win=1;
                }
            }

            if ((command.equals("F"))&& win==1) {

                System.out.println("Game over : Player "+ winningplayer + " wins!!");

                break;
            }


            ///dl.showlists(dl.direction);

        }
    }
}