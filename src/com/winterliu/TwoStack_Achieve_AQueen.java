package com.winterliu;

import java.util.Stack;

/**
 * Created by liuwentao on 2019-12-06 10:38
 *
 * 用两个栈来实现一个队列
 */
public class TwoStack_Achieve_AQueen {

    Stack<Integer> stackPush = new Stack<>(); // 入队列批次操作的数据容器
    Stack<Integer> stackPop = new Stack<>(); // 出队列批次操作的数据容器

    public static void main(String[] args) {
        /*
        这里有三种方法，第一种就是：一个主栈，当有元素要入队列的时候就把该元素push到这个主栈中，当有元素要出队列的时候，就先把主队列中的所有元素依次pop出来到另外一个副队列，然后再把副队列pop顶层元素
        最后把副队列中剩下的元素pop出、push进主队列，这样就完成了出队列操作。
        方法二：其实就是方法一的稍微改进，当执行连续的出队列时，就不需要每次出一个元素就倒腾一次，而是直接把要出队列的元素一次性pop完，然后再把剩下的push回主栈

        方法三：最优思路，这里队列的本质就是两个操作，出队和入队。那么可以把出队和入队看成是两种批次的操作，这里两个栈就分别设置为：stackPush栈(入队批次操作的数据容器)、stackPop栈(出队批次操作的数据容器)
        当入队时直接往stackPush栈中push，出队时首先判断stackPop栈是否为空，若为空就把stackPush栈中所有的元素push到stackPop栈中，然后pop出stackPop栈顶层元素，不为空直接pop
        */
        TwoStack_Achieve_AQueen twoStack_achieve_aQueen = new TwoStack_Achieve_AQueen();
        twoStack_achieve_aQueen.queueAdd(5);
        twoStack_achieve_aQueen.queueAdd(2);
        twoStack_achieve_aQueen.queueAdd(3);

        twoStack_achieve_aQueen.queuePoll();
    }

    // 用两个栈实现队列增加元素
    public void queueAdd(int ele) {
        stackPush.push(ele);
    }

    // 用两个栈实现出队列操作
    public void queuePoll() {
        if (stackPop.isEmpty()) { // 当出队列批次操作栈为空时，先把stackPush里面的元素全部push到stackPop里面
            while (!stackPush.isEmpty()) {
                Integer temp = stackPush.pop();
                stackPop.push(temp);
            }
        }

        if (!stackPop.isEmpty()) {
            Integer popElem = stackPop.pop();
            System.out.println("出队元素：" + popElem.intValue());
        }else {
            System.out.println("队列是空的");
        }

    }
}
