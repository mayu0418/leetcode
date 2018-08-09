#include <iostream>
using namespace std;

int maxIncreaseKeepingSkyline(int **grad, int gridRowSize, int *gridColSizes) {
    //边际线改变之前的和
    int beforeSum=0;
    for (int i=0; i<gridRowSize; i++) {
        for (int j=0; j<gridColSizes[i]; j++) {
            beforeSum+=grad[i][j];
        }
    }
    //装每行最大值的数组
    int rowBiggest[gridRowSize];
    int biggestColCount = 0;
    for (int i=0; i <sizeof(gridColSizes)/sizeof(int); i++) {
        if (gridColSizes[i]>biggestColCount) {
            biggestColCount=gridColSizes[i];
        }
    }
    //装每列最大值的数组
    int colBiggest[biggestColCount];
    //算出每行最大值，放进rowBiggest中
    for (int i=0; i<gridRowSize; i++) {
        int biggestX=grad[i][0];
        for (int j=0; j<gridColSizes[i]; j++) {
            if (biggestX<grad[i][j]) {
                biggestX=grad[i][j];
            }
        }
        rowBiggest[i]=biggestX;
    }
    
    //算出每列最大值，放进colBiggest中
    for (int i=0; i<biggestColCount; i++) {
        int biggestY=grad[0][i];
        for (int j=0; j<gridRowSize; j++) {
            if (gridColSizes[j]>i) {
                if (biggestY<grad[j][i]) {
                    biggestY=grad[j][i];
                }
            } else {
                biggestY=100;
            }
        }
        colBiggest[i]=biggestY;
    }
    
    //开始建高楼
    for (int i=0; i<gridRowSize; i++) {
        for (int j=0; j<gridColSizes[i]; j++) {
            int shouldHeight=rowBiggest[i]<colBiggest[j]?rowBiggest[i]:colBiggest[j];
            if (grad[i][j]<shouldHeight) {
                grad[i][j]=shouldHeight;
            }
        }
    }
    //建完楼之后的高度
    int afterSum=0;
    for (int i=0; i<gridRowSize; i++) {
        for (int j=0; j<gridColSizes[i]; j++) {
            afterSum+=grad[i][j];
        }
    }
    
    //对两个高度做差
    //cout<< afterSum - beforeSum;
    return afterSum - beforeSum;

}


int main(int argc, const char * argv[]) {
    //一下都是在造mock的输入数据
    int grad[4][4] = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
    int **x;
    int i;
    x=(int **)malloc(sizeof(int*) * 4 );
    for( i=0;i<4;i++ )
        x[i]=(int *)malloc(4*sizeof(int) );
    for (int a = 0; a < 4; a ++) {
        for (int b = 0; b < 4; b ++) {
            x[a][b] = grad[a][b];
        }
    }
    
    int gridColSizes[4] = {4,4,4,4};
    
    //这一行才比较正经
    maxIncreaseKeepingSkyline(x, 4, gridColSizes);
    
    //释放
    for( i=0;i<4;i++ )
        free(x[i]) ;
    free(x);
    
    return 0;
}
