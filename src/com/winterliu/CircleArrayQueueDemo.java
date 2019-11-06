package com.winterliu;

import java.util.Scanner;

public class CircleArrayQueueDemo {


    public static void main(String[] args){
        CircleArray arrayQueue = new CircleArray(4);// 因为最后留了一个空间，所以这里队列的有效数据最大是3
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s1:show queue");
            System.out.println("e:exit queue");
            System.out.println("a:add queue");
            System.out.println("g:get queue");
            System.out.println("h:head queue");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("input a num");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    int res = arrayQueue.getQueue();
                    System.out.println("取出的队头数据为："+res);
                    break;
                case 'h':
                    int head = arrayQueue.headQueue();
                    System.out.println("队头数据为："+head);
                    break;
            }
        }
    }
}

class CircleArray{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;//指向队列头
        rear = 0;//指向队尾位置后一个位置的数据
    }

    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if (isFull()){
            System.out.println("full");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        //这里需要分析出 front 是指向队列的第一个元素
        //1. 先把 front 对应的值保留到一个临时变量
        //2.将front后移，考虑取模
        //3.返回临时变量
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("is Empty");
            return;
        }
        // 思路：从front 开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++){
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }

    // 求出当前队列的有效数据的个数
    public int size(){
        // rear = 2
        // front = 1
        // maxSize = 3
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("is Empty");
        }
        return arr[front];
    }
}


















