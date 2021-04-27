#include<iostream>
#include<fstream>
#include<cstdio>
#include<queue>
#include<stdlib.h>
#include<ctime>
#include "heap.h" //You need to implement this.

using namespace std;

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

    //cout<<h.getMax()<<endl;
    cout << "Deleting " << numbers.size() << " numbers from my heap takes "<< float(clock() - time_of_deletion_in_my_heap) / CLOCKS_PER_SEC << " seconds\n";

    heapsort(numbers); // You need to implement this function in heap.h. You should use the heap class implemented by you to do this. Hint: the function declaration should be void heapsort(vector<int>&v);
    // Now, "numbers" vector contains the numbers in descending order
    return 0;
}











/*

int main()
{
    int a[] = {7,4,5,23,9,10,2};

    int size = sizeof(a)/sizeof(a[0]);

    Heap h(size);
    for(int i = 0; i<size; i++){
        h.insert(a[i]);
        h.print();
    }
    cout<<"Deleting\n"<<endl;
    while(!h.isEmpty()){
        cout <<"deleting "<< h.deleteKey() << endl;
       h.print();
    }
    cout<<h.getMax()<<endl;
    vector<int> v(a,a+size);
    heapsort(v);
    cout<<"Heapsort :";
    for(int i = 0; i<size;i++)
       cout<<v[i]<<" ";
    cout<<endl;
    return 0;
}
*/
