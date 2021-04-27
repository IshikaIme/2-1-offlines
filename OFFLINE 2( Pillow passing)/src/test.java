import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        String str=new String();
        str=sc.nextLine();
        String[] command = str.split(" ");
        for (String a : command)
            System.out.println(a);
    }
}
