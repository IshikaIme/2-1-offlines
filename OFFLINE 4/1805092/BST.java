//TODO
// - GETHEIGHT E SOMOSSA (APATOTO PASSI NA)
// - EKHANE SOMOSSA GULA NOTE KORBO


public class BST {
    private Node head;

    BST() {
        head = null;
    }

    public Node getHead() {
        return head;
    }

    BST(int[] a) {
        int l = a.length;
        for (int i = 0; i < l; i++) {
             InsertItem( a[i]);

        }
    }

    public void InsertItem(int value)
    {
        head=InsertItemRec(head,value);
    }
    public Node InsertItemRec(Node start, int value) {
        if (start == null) {
            start = new Node(value);
            return start;
        }

        if (value < start.value)
            start.left = InsertItemRec(start.left, value);

        else if (value > start.value)
            start.right = InsertItemRec(start.right, value);
        return start;
    }


    public Node searchItemAtNode(Node start, int value) {
        //Node found = new Node();
        if (start == null)
            return null;
        if (value < start.value)
            return searchItemAtNode(start.left, value);
        if (value > start.value)
            return searchItemAtNode(start.right, value);

            return start;
    }


    public Node searchItem(int value){
        Node found= new Node();
        found=searchItemAtNode(head, value);
        if (found != null) {
            System.out.println(value + " has been found!");
        } else
            System.out.println(value + " hasn't been found!");
        return found;
    }


    public void getInOrderSuccessor(int val) {
        Node root= new Node();
        root=head;
        Node temp = new Node();
        Node successor = new Node();
        Node Atrightmost = getMaxItem(getHead());
        temp = searchItemAtNode(head, val);
       // System.out.println(temp.value);

        if (temp == null) {
            System.out.println(val + " isnot found on that tree");
            return;
        }
        if (temp == Atrightmost) {
            System.out.println("No successors found!");
        } else {
            if (temp.right != null)
                successor = getMinItem(temp.right);

            else if (temp.right == null) {
                while (root.value != val) {

                    if (temp.value < root.value) {
                        successor = root;
                        root = root.left;
                    }

                    if (temp.value > root.value) {
                        root = root.right;
                        //  successor = root;
                    }

                    // if(temp.value== root.value)
                    // break;
                }

            }
            if (successor.value != 0)
                System.out.println("The InorderSuccessor is " + successor.value);
        }
    }

    public void getInOrderPredecessor(int val) {
        Node root= new Node();
        root=head;

        Node temp = new Node();
        Node predecessor = new Node();
        Node AtLeftmost = getMinItem(getHead());
        temp = searchItemAtNode(head, val);
        // System.out.println(temp.value);

        if (temp == null) {
            System.out.println(val + " isnot found on that tree");
            return;
        }
        if (temp == AtLeftmost) {
            System.out.println("No predecessors found!");
        } else {
            if (temp.left != null)
                predecessor = getMaxItem(temp.left);

            else if (temp.left == null) {
                while (root.value != val) {

                    if (temp.value > root.value) {
                        predecessor = root;
                        root = root.right;
                    }

                    if (temp.value < root.value) {
                        root = root.left;
                        //  successor = root;
                    }

                }

            }
            if (predecessor.value != 0)
                System.out.println("The InorderPredecessor is " + predecessor.value);
        }
    }

    public void deleteItem(int item) {
        if (searchItemAtNode(head,item) == null)
            System.out.println(item + " doesn't exist on this tree.");
        else {
            head = deleteItemAtNode(head, item);
            System.out.println(item + " has been deleted successfully!");
        }
    }

    public Node deleteItemAtNode(Node parent, int item)
    {
        if(parent==null)
            return parent;

        else if(item< parent.value)
            parent.left=deleteItemAtNode(parent.left,item);
        else if(item> parent.value)
            parent.right=deleteItemAtNode(parent.right,item);


        else {
            if(parent.left==null)
               return parent.right;
            else if(parent.right==null)
                return parent.left;

            parent.value=getMinItemInt(parent.right);
            System.out.println(parent.value);
            parent.right=deleteItemAtNode(parent.right, parent.value);
            System.out.println(parent.right.value);


      }

        return parent;
    }

    public int getItemDepth(int x)
    {
        Node atnode=searchItemAtNode(head,x);
        if(atnode==null)
            return -12345678;
        else
            return getHeight(head) - getHeight(atnode);
    }


    public Node getMaxItem(Node node)
    {
       // Node node= head;
        while(node.right!=null)
            node=node.right;

        return node;
    }
    public int getMinItemInt(Node node)
    {
        //Node node= head;
        while(node.left!=null)
            node=node.left;

        return node.value;
    }

    public Node getMinItem(Node node)
    {
        //Node node= head;
        while(node.left!=null)
            node=node.left;

        return node;
    }

    public int getHeight(Node parent) {
            int h, leftcount, rightcount;
            if(parent==null)
                return 0;
            if ((parent.left == null)&&(parent.right==null))
                return 0;
            leftcount = getHeight(parent.left);
            rightcount = getHeight(parent.right);

     //       System.out.println(leftcount + " " + rightcount);
            h= Math.max(leftcount, rightcount)+1;
            return h;

    }


    public void printPreOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.value + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);

    }

    public void printPostOrder(Node root) {
        if (root == null)
            return;

        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.value + " ");

    }

    public void printInOrder(Node root) {
        if (root == null)
            return;

        printInOrder(root.left);
        System.out.print(root.value + " ");
        printInOrder(root.right);

    }

    public int getsize(Node grandpa)
    {
        int nodenumber=0;
        if(grandpa==null)
            return 0;

        nodenumber=nodenumber+getsize(grandpa.left)+getsize(grandpa.right)+1;
        return nodenumber;

    }


}