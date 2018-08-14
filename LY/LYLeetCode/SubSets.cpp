#include <iostream>
using namespace std;


int** subsets(int* nums, int numsSize, int** columnSizes, int* returnSize){
    int mask=0;
    int start=0;
    int end=(1<<numsSize)-1;
    int **x =(int **)malloc(sizeof(int*) * (*returnSize));
    int count=0;
    //掩码0~7
    for(mask=start;mask<=end;mask++){
        x[count]=(int *)malloc(sizeof(int) * columnSizes[count][0]);
        int everyCount=0;
        //算出每个数组
        for(int i=0;i<numsSize;i++)
            if((1<<i)&mask){
                x[count][everyCount] = nums[i];
                everyCount++;
            }
        //空数组
        if(!everyCount)
            x[count]={};
        count++;
    }
    return x;
}

int main(int argc, const char * argv[]) {
    int a[]={1,2,3};
    int **columnSizes =(int **)malloc(sizeof(int*) * 8);
    for(int i=0;i<8;i++ )
        columnSizes[i]=(int *)malloc(sizeof(int));
    columnSizes[0][0]=0;//000
    columnSizes[1][0]=1;//001
    columnSizes[2][0]=1;//010
    columnSizes[3][0]=2;//011
    columnSizes[4][0]=1;//100
    columnSizes[5][0]=2;//101
    columnSizes[6][0]=2;//110
    columnSizes[7][0]=3;//111
    int returnSize=8;
    int ** x=subsets(a, 3, columnSizes, &returnSize);
    for (int i = 0; i < 8; i ++) {
        int count = columnSizes[i][0];
        for (int j = 0; j < count; j ++) {
            cout <<x[i][j];
        }
        cout<<endl;
    }
    free(columnSizes);
    free(x);
    return 0;
}
