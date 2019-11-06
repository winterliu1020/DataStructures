package com.winterliu;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args){
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s:show queue");
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

class ArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头的前一个位置
        rear = -1;//指向队尾的数据
    }

    public boolean isFull(){
        return rear == maxSize - 1;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if (isFull()){
            System.out.println("full");
            return;
        }
        rear++;//让 rear 后移
        arr[rear] = n;
    }

    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("is Empty");
            return;
        }
        for (int i = front+1; i <= rear; i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("is Empty");
        }
        return arr[front + 1];
    }
}
