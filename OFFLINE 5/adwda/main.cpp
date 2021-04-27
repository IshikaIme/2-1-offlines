#include<iostream>
#include<vector>
#include<iostream>
#include<fstream>
#include<cstdio>
#include<queue>
#include<ctime>


using namespace std;
class Heap{
private:
    int size=0;
    int *array;
    int index;
    static int find_parent_Index(int childIndex)
    {
        return (childIndex-1)/2;
    }
    static int find_leftchild_Index(int parentIndex)
    {
        return (parentIndex*2)+1;
    }
    static int find_rightchild_Index(int parentIndex)
    {
        return (parentIndex*2)+2;
    }
        void HeapUp(int child)
    {
        if(child>0)
        {
            int parent=find_parent_Index(child);
            if(array[child]>array[parent])
            {
                int temp=array[child];
                array[child]=array[parent];
                array[parent]=temp;
                HeapUp(parent);
            }
        }
    }
    void HeapDown(int root)
    {
        int last=index-1;
        int leftChild=find_leftchild_Index(root);
        int rightChild=find_rightchild_Index(root);
        int bigBrother;
        if(leftChild<=last)
        {
            if(leftChild==last)
            {
                bigBrother=leftChild;
            }
            else
            {
                if(array[leftChild]>array[rightChild])
                    bigBrother=leftChild;
                else
                    bigBrother=rightChild;
            }
            if(array[bigBrother]>array[root])
            {
                int temp=array[root];
                array[root]=array[bigBrother];
                array[bigBrother]=temp;
                HeapDown(bigBrother);
            }
        }
    }
public:
    Heap()
    {
        size=0;
        index=0;
    }
    Heap(int n)
    {
        size=n;
        array=new int[size];
        index=0;
    }
    int getSize()
    {
        return size;
    }
    int *getArray()
    {
        return array;
    }
    bool isEmpty()
    {
        if(index==0)
            return true;
        else
            return false;
    }
    void insert(int data)
    {
        if(index==size)
            cout<<"Heap is full"<<endl;
        else{
            array[index]=data;
            if(index>1)
            {
               HeapUp(index);
               index++;
            }
        }
    }
    int getMax()
    {
        if(this->isEmpty())
        {
            cout<<"Empty Heap"<<endl;
            return -1;
        }
        else
        {
            return array[0];
        }
    }
    int deleteKey()
    {
        if(this->isEmpty())
        {
            cout<<"Heap is Empty"<<endl;
            return -1;
        }
        else
        {
            int top=array[0];
            array[0]=array[size-1];
            size--;
            HeapDown(0);
            return top;
        }
    }
    static void heapify(int arr[], int n,int root)
    {
        int largest=root;
        int leftChild=find_leftchild_Index(root);
        int rightChild=find_rightchild_Index(root);
        if(leftChild<n && arr[leftChild]>arr[root])
        {
            largest=leftChild;
        }
        if(rightChild<n && arr[rightChild]>arr[root])
        {
            largest=rightChild;
        }
        if(largest!=root)
        {
            swap(arr[root],arr[largest]);
            heapify(arr,n,largest);
        }
    }
    void print()
    {
        for(int i=0;i<size;i++)
        {
            cout<<array[i]<<" ";
        }
        cout<<endl;
    }
};

void heapsort1(Heap temp,int arr[],int n)
    {
        for(int i=n/2-1;i>=0;i--)
        {
            temp.heapify(arr,n,i);
        }
        for(int j=n-1;j>=0;j--)
        {
            swap(arr[0],arr[j]);
            temp.heapify(arr,j,0);
        }
    }
void heapsort(vector <int>&numbers)
{
    Heap temp(numbers.size());
    for(int i=0;i<numbers.size();i++)
    {
        temp.insert(numbers.at(i));
    }
    int n=sizeof(temp.getArray())/sizeof(int);
    heapsort1(temp,temp.getArray(),n);
}

int main()
{
    priority_queue<int>pq;
    vector<int>numbers;

    //reading from file begins. Loading all the numbers in the vector
    string myText;
    ifstream MyReadFile("numbers.txt");
    while (getline (MyReadFile, myText))
      numbers.push_back(atoi(myText.c_str()));
    MyReadFile.close();
    //reading from file ends

    clock_t time_of_insertion_in_pq = clock();

    for(int i = 0; i < numbers.size(); i++)
        pq.push(numbers[i]);

    cout << "Inserting " << pq.size() << " numbers in priority queue takes "<< float(clock() - time_of_insertion_in_pq) / CLOCKS_PER_SEC << " seconds\n";

    Heap h(numbers.size());// Passing the maximum size of the heap as parameter to constructor. You need to implement this.

    clock_t time_of_insertion_in_my_heap = clock();

    for(int i = 0; i < numbers.size(); i++)
        h.insert(numbers[i]); // inserting numbers in the heap. You need to implement this.

    cout << "Inserting " << h.size() << " numbers in my heap takes "<< float(clock() - time_of_insertion_in_my_heap) / CLOCKS_PER_SEC << " seconds\n"; // You need to implement size() function

    cout<<pq.top()<<endl;
    cout<<h.getMax()<<endl; // returning the maximum number of the heap. You need to implement this.

    clock_t time_of_deletion_in_pq = clock();

    int number_of_numbers = pq.size();

    for(int i = 0; i < number_of_numbers; i++)
        pq.pop();

    cout << "Deleting " << numbers.size() << " numbers from priority queue takes "<< float(clock() - time_of_deletion_in_pq) / CLOCKS_PER_SEC << " seconds\n";

    clock_t time_of_deletion_in_my_heap = clock();

    for(int i = 0; i < number_of_numbers; i++)
        h.deleteKey(); // deleting the root of the heap. You need to implement this.

    cout << "Deleting " << numbers.size() << " numbers from my heap takes "<< float(clock() - time_of_deletion_in_my_heap) / CLOCKS_PER_SEC << " seconds\n";

    heapsort(numbers); // You need to implement this function in heap.h. You should use the heap class implemented by you to do this. Hint: the function declaration should be void heapsort(vector<int>&v);
    // Now, "numbers" vector contains the numbers in descending order
    return 0;
}
