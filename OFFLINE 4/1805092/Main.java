import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] a = {7, 2, 4, 3, 6, 5};
        int[] b = {1, 2, 3, 5, 4};
        int[] c = {23, 45, 47, 12, 20, 50, 21, 55};
        BST bts = new BST();

        while (true) {
            try{
            System.out.println();
            System.out.println("Welcome to Binary tree! What do you want to do? ");
            System.out.println("1.Insert Item");
            System.out.println("2.Search Item");
            System.out.println("3.Get In Order Successor");
            System.out.println("4.Get In Order Predecessor");
            System.out.println("5.Delete Item");
            System.out.println("6.Get Item Depth");
            System.out.println("7.Get Max Item");
            System.out.println("8.Get Min Item");
            System.out.println("9.Get Height");
            System.out.println("10.Print InOrder");
            System.out.println("11.Print PreOrder");
            System.out.println("12.Print PostOrder");
            System.out.println("13.Get Size");
            System.out.println("14.Exit");
            System.out.println("Enter your response: ");

            Scanner sc = new Scanner(System.in);
            int response = sc.nextInt();
            if (response == 1) {
                System.out.println("Enter the number that you want to insert: ");
                int num = sc.nextInt();
                bts.InsertItem(num);
                System.out.println(num + " is inserted successfully!");

            } else if (response == 2) {
                System.out.println("Enter the number that you are searching in my tree: ");
                int n = sc.nextInt();
                bts.searchItem(n);
            } else if (response == 3) {
                System.out.println("Enter the value of which you want to get the Inorder successor: ");
                int n = sc.nextInt();
                bts.getInOrderSuccessor(n);
            } else if (response == 4) {
                System.out.println("Enter the value of which you want to get the Inorder predecessor: ");
                int n = sc.nextInt();
                bts.getInOrderPredecessor(n);
            } else if (response == 5) {
                System.out.println("Enter the number that you want to delete from the tree: ");
                int x = sc.nextInt();
                bts.deleteItem(x);

            } else if (response == 6) {
                System.out.println("Enter the value of which you want to get the depth: ");
                int num = sc.nextInt();
                System.out.println("The depth is= " + bts.getItemDepth(num));
            } else if (response == 7) {
                System.out.println("The max item on the tree is =" + bts.getMaxItem(bts.getHead()).value);
            } else if (response == 8) {
                System.out.println("The min item on the tree is =" + bts.getMinItem(bts.getHead()).value);
            } else if (response == 9) {
                System.out.println("The height of current binary tree is " + bts.getHeight(bts.getHead()));
            } else if (response == 10) {
                System.out.println("Printing the tree on InOrder sequence: ");
                bts.printInOrder(bts.getHead());
            } else if (response == 11) {
                System.out.println("Printing the tree on PreOrder sequence: ");
                bts.printPreOrder(bts.getHead());
            } else if (response == 12) {
                System.out.println("Printing the tree on PostOrder sequence: ");
                bts.printPostOrder(bts.getHead());
            } else if (response == 13) {
                System.out.println("Current size of the tree is =" + bts.getsize(bts.getHead()));
            } else if (response == 14)
                break;
        }
            catch(Exception e)
            {
                System.out.println("Please enter a valid input.");

            }
        }

    }
}