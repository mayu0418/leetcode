/*
 921. 使括号有效的最少添加
 
 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
 
 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 
 它是一个空字符串，或者
 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 它可以被写作 (A)，其中 A 是有效字符串。
 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 
 输入："())"
 输出：1
 
 输入："((("
 输出：3
 
 输入："()"
 输出：0
 
 输入："()))(("
 输出：4
 
 */

#include <iostream>

//栈
struct Stack {
    int index;
    int array[100];
};

//入栈
void push(struct Stack *stack,int val) {
    stack->array[stack->index]=val;
    stack->index++;
}

//出栈
int pop(struct Stack *stack) {
    stack->index--;
    return stack->array[stack->index];
}

int minAddToMakeValid(char* S) {
    size_t SLength = strlen(S);
    struct Stack *stack=(struct Stack *)malloc(sizeof(struct Stack));
    stack->index=0;
    for (size_t i=0; i<SLength; i++) {
        if (stack->array[stack->index-1]=='('&&S[i]==')') {
            pop(stack);
        } else {
            push(stack, S[i]);
        }
    }
    return stack->index;
}

int main(int argc, const char * argv[]) {
    
}
