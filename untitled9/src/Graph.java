import java.util.*;

public class Graph
{

    private int vno;
    private LinkedList<Integer>[] ad;
    int friendcollection[]= new int[100];

    Graph(int v)
    {
        vno = v;
        ad = new LinkedList[vno];

        int [] piecehidden= new int[vno];

        for(int i = 0; i < v; i++) ad[i] = new LinkedList<>();
    }

    public LinkedList<Integer> getAd(int n) { return ad[n]; }

    void addEdge(int x, int y)
    {
        ad[x].add(y);
        ad[y].add(x);
        //  System.out.println(ad[x].getHead().element + " ");
    }



    public int[] BFS(int node, int player,int [] piecelocations)
    {
        LinkedList<Integer> queue = new LinkedList<>();
        int piecesfound=0;
        boolean[] isVisited = new boolean [vno];
        isVisited[node] = true;
        queue.add(node);
        // System.out.println(queue.peek());
        int x;

        while(!queue.isEmpty())
        {
            //System.out.println("ekhane dhukse");
            x = queue.remove();
            //System.out.println("X: " + x);

            // getAd(node).display();
            for (Integer adjNode : getAd(x))
            {
                if(!isVisited[adjNode])
                {
                 //   System.out.println("Adj: " + adjNode);
                    isVisited[adjNode] = true;
                    queue.add(adjNode);
                    piecesfound+=piecelocations[adjNode];
                    piecelocations[adjNode]=0;
                    //  System.out.println(getAd(node).getHead().element);
                    // getAd(node).RemoveFromTop();
                }
            }

          //  System.out.print("Queue: ");
            //for (Integer q : queue) System.out.print(q + " ");
            //System.out.println();



        }

       // System.out.println("pieces found by player "+ player+ "is : " + piecesfound);
        //playerno++;

        friendcollection[player]=piecesfound;
        return piecelocations;
    }

    int result(int player)
    {
        return friendcollection[player];
    }






        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            String firstline = scanner.nextLine();
            String[] numbers = firstline.split(" ", 4);
            int C= Integer.parseInt(numbers[0]);
            int R = Integer.parseInt(numbers[1]);
            int L = Integer.parseInt(numbers[2]);
            int F = Integer.parseInt(numbers[3]);
            Graph map = new Graph(C);

            int [] piecelocations = new int [C];
            int totalpieces=0;
            for (int i = 0; i < C; i++) {
                piecelocations[i]= 0;
            }

            for (int index = 0; index < R; index++) {
                String secondline = scanner.nextLine();
                String[] cities = secondline.split(" ", 2);
                int C1 = Integer.parseInt(cities[0]);
                int C2 = Integer.parseInt(cities[1]);
                map.addEdge(C1, C2);
            }


            for(int j=0; j<L ; j++)
            {
                //int Cx, Px;
                String thirdline = scanner.nextLine();
                String[] places = thirdline.split(" ", 2);
                int Cx = Integer.parseInt(places[0]);
                int Px = Integer.parseInt(places[1]);
                piecelocations[Cx]= Px;
                totalpieces+=Px;
            }

            for(int k=0; k<F; k++) {
                String lastline = scanner.nextLine();
                String[] friends = lastline.split(" ", 2);
                int Cy = Integer.parseInt(friends[0]);
                int Fy = Integer.parseInt(friends[1]);


                piecelocations = map.BFS(Cy, Fy, piecelocations);
            }

//            piecelocations = map.BFS(4, 0, piecelocations);
//            piecelocations = map.BFS(7, 2, piecelocations);
//            piecelocations = map.BFS(2, 1, piecelocations);



            int totalcollection=0;
            for(int i=0; i<F; i++)
                totalcollection+=map.result(i);


            if(totalcollection==totalpieces)
                System.out.println("Mission Accomplished");
            else
                System.out.println("Mission Impossible");

            System.out.println(totalcollection + " out of " + totalpieces + " pieces are collected");




            for(int i=0; i<F; i++)
            System.out.println(i+ " collected " + map.result(i) + " pieces ");


        }
    }

