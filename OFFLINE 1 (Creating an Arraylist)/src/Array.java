import java.util.Arrays;

public class Array {
    private String array[];
    private int index;
    private int size=20;
    Array()
    {
        array=new String[size];
        index=0;
    }
    Array(int n)
    {
        size=n;
        array=new String [size];
        index=0;
    }
    Array(String A[])
    {
        index=0;
        size=A.length;
        array=new String[size];
        for(int i=0;i<array.length;i++)
        {
            array[i]=A[i];
            index++;
        }
    }
    String[] getArray()
    {
        return array;
    }
    String getAnElement(int i)
    {
        return array[i];
    }
    String [] resize()
    {
        size=array.length+1;
        String[] temparr=new String[size];
        for(int i=0;i<array.length;i++)
        {
            temparr[i]=array[i];
        }
        return temparr;
    }
    void add(String element)
    {
        array=resize();
        array[index]=element;
    }
    void add(int i,String element) throws ArrayIndexOutOfBoundsException
    {
        if(i==array.length)
            add(element);
        else {
            array=resize();

            for (int j = array.length-1; j > i; j--) {

              array[j ] = array[j-1];


            }
            array[i] = element;
        }
    }
    void remove(String element)
    {
        for(int i=0;i<array.length;i++)
        {
            if(array[i]==element)
            {
                for(int j=i;j<array.length;j++)
                {
                    array[i]=array[i+1];
                }
                array[array.length-1]="";
            }
        }
    }
    public void findIndex(String element)
    {

        int i, j=0,k=0;
        for(i=0;i<array.length;i++)
        {
            if(array[i].equals(element))
            {
                k++;

            }
        }
        int []index=new int[k];

        for(i=0;i<this.index;i++)
        {
            if(array[i].equals(element))
            {
                index[j]=i;
                j++;

            }
        }

        for(int l=0; l< k; l++)
            System.out.println(index[l]);
    }



    String[] subArray(int start,int end)
    {
        String sub[]=new String[end-start+1];
        for(int i=start,j=0;i<=end;i++)
        {
            sub[j]=array[i];
            j++;
        }
        return sub;
    }
    void merge(String A1[],String A2[])
    {
        int a1=A1.length;
        int a2=A2.length;
        String[] temp=new String[a1+a2];
        for(int i=0;i<a1;i++)
        {
            temp[i]=A1[i];
        }
        for(int i=0;i<a2;i++)
        {
            temp[a1+i]=A2[i];
        }
        array=new String[temp.length];
        for(int i=0;i<temp.length;i++)
        {
            array[i]=temp[i];
        }
    }
    int length()
    {
        return array.length;
    }
    boolean isEmpty()
    {
        int res=0;
        for(int i=0;i<array.length;i++)
        {
            if(array[i]!="")
            {
                res=1;
                break;
            }
        }
        if(res==1)
            return false;
        else
            return true;
    }

    @Override
    public String toString() {
        return "Array size="+size+": Array={"+Arrays.toString(array) +'}';
    }

    public static void main(String[] args) {
        Array a1=new Array();
        Array a2=new Array(10);
        String []arr={"A","B","C","D","E"};
        Array a3=new Array(arr);
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a3.toString());
        a3.getAnElement(2);
        a3.add("F");
        System.out.println(a3.toString());
        a3.add(3,"G");
        System.out.println(a3.toString());
       a3.remove("D");
        System.out.println(a3.toString());
        a3.findIndex("D");


        /*System.out.println(Arrays.toString(a3.subArray(2,4)));
        String []arr1=new String[]{"I","J","K","L","M"};
        Array obj=new Array();
        obj.merge(arr,arr1);
        System.out.println(obj.toString());
        System.out.println(a3.length());
        System.out.println(a3.isEmpty());*/
    }
}