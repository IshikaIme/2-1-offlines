using std::vector;

class Heap{


private:
    int numbers=0;
//    vector<int>vec;

    int *arr;
    int start;

     int findparentIndex(int childIndex)
     {
         return (childIndex-1)/2; //child/2
     }
     int findleftchildIndex(int parentIndex)
     {
         return (parentIndex*2)+1; //parent*2+1
     }

    int findrightchildIndex(int parentIndex)
    {
        return (parentIndex*2)+2;//parent*2+2
    }
public:
    int size()
    {
        return start;
    }

    Heap()
{
    numbers=0;
    start=0;
}
    Heap(int n)
    {
        numbers=n;
        arr =new int[numbers];
        start=0;
    }

    ~Heap()
    {
        delete[] arr;
    }


     bool isEmpty()
     {
         return start==0;
     }

 int getMax()
     {
        if(this->isEmpty()==false)
            return arr[0];
        else
    {       std::cout<<"Heap is empty "<<std::endl;
            return -1 ;

     }

     }

     void insert(int val)
     {
        arr[start]=val;
      //  std::cout<<arr[start];
        start++;
//std::cout<< arr[start];
        moveup(start-1);

   /*for(int i=0; i<start; i++)
            std::cout<<arr[i]<<" ";
        std::cout<<std::endl;*/
     }

     void swapp(int index1, int index2)
     {
         int temp= arr[index1];
         arr[index1]=arr[index2];
         arr[index2]=temp;

     }

     void moveup(int x)
     {
         if(x>start)
            return;
         else if(x==0)
            return;
         if(arr[x]>arr[findparentIndex(x)])
            swapp(x,findparentIndex(x));
        else
            return;

        moveup(findparentIndex(x));


     }




        int deleteKey()
     {
        int Max= arr[0];
        swapp(0,--start);
        //arr[0]=arr[--start];
        //arr[numbers--]='\n';
        //std::cout<<"delete";
        movedown(0);

//    for(int i=0; i<start; i++)
//            std::cout<<arr[i]<<" ";
//        std::cout<<std::endl;
       // std::cout<<"Max is: "<<Max <<" ";

        return Max;
     }

//     void movedown(int y)
//
//     {
//         int index=0;
//          if(y>=start)
//            return;
//
//        while(index<=start)
//        {
//
//
//
//         /*if(findleftchildIndex(y)<numbers && arr[y]<arr[findleftchildIndex(y)])
//            index=findleftchildIndex(y);
//
//          else if(findrightchildIndex(y)<numbers && arr[y]<arr[findrightchildIndex(y)])
//            index=findrightchildIndex(y);*/
//
//
//        if(arr[findleftchildIndex(y)]>=start||findrightchildIndex(y)>=start)
//            return;
//
//
//
//        int large= arr[findleftchildIndex(y)]>arr[findrightchildIndex(y)]?findleftchildIndex(y):findrightchildIndex(y);
//
//
//        if(arr[large]>arr[y])
//            index= large;
//        else
//            index =y;
//
//
//        if(index!=y)
//        {
//            swapp(y, index);
//            //movedown(index);
//        }
//        return;
//
//    }



    void movedown(int index)
    {
        while(index<=(start-2)/2)
        {


            if(findleftchildIndex(index)>start||findrightchildIndex(index)>start)
                return;

            int larger=-1;

            if(findrightchildIndex(index)>=start)
                larger=findleftchildIndex(index);




            else
                larger= arr[findleftchildIndex(index)]>arr[findrightchildIndex(index)]?findleftchildIndex(index): findrightchildIndex(index);


            if(arr[larger]>arr[index])
            {
              //  std::cout<<" swapping " << arr[index] << " with " << arr[larger]<<std::endl;
                swapp(index,larger);
                index= larger;
            }
            else
                return;

        }
    }

    void print()
    {
        for(int i=0; i<start; i++)
            std::cout<<arr[i]<<" ";
       std::cout<<std::endl;
    }



};

    void heapsort(vector<int>&v)
        {
            vector<int>swapvec;
            Heap temp(v.size());
            int i;
            for(i=0; i<v.size(); i++)
                temp.insert(v[i]);
            for(i=0; i<v.size(); i++)
            {
                int x= temp.getMax();
                 temp.deleteKey();
                swapvec.push_back(x);
            }

            v=swapvec;

        }
