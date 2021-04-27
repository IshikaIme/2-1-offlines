using std::vector;
class Heap{


private:
    int numbers;
    vector<int>vec;

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
        return vec.size();
    }

     Heap()
     {
         vec.push_back(0);
     }

     Heap(int s)
     {
         vec.;
     }
     bool isEmpty()
     {
         return numbers==0;
     }
     int getMax()
     {
         return vec[0];
     }
     void insert(int val)
     {
         if(numbers>=vec.size())
             vec.push_back(0);
         vec[numbers++]=val;
        moveup(numbers);

     }

     void swapp(int index1, int index2)
     {
         int temp= vec[index1];
         vec[index1]=vec[index2];
         vec[index2]=temp;

     }

     void moveup(int x)
     {
         if(x>numbers)
            return;
         if(x==1)
            return;
         if(vec[x]>vec[findparentIndex(x)])
            swapp(x,findparentIndex(x));
        moveup(findparentIndex(x));
     }

        int deletekey()
     {
        int Max= vec[0];
        swapp(vec[0],numbers--);
        movedown(1);
        return Max;
     }

     void movedown(int y)
     {
          if(y>numbers)
            return;

         int index=y;
         if(findleftchildIndex(y)<=numbers && vec[y]<vec[findleftchildIndex(y)])
            index=findleftchildIndex(y);

          if(findrightchildIndex(y)<=numbers && vec[y]<vec[findrightchildIndex(y)])
            index=findrightchildIndex(y);


            if(index!=y)
            {
                swapp(y, index);
                movedown(index);
            }

         }

         int peak()
         {
             return vec[0];
         }

         heapsort(int numbers)
         {

             while(vec[numbers]!='\0')
                {
                cout<<vec[numbers];
                numbers--;
         }
         }

};
