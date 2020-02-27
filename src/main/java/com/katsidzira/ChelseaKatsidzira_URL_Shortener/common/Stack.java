package com.katsidzira.ChelseaKatsidzira_URL_Shortener.common;

class Item {
    int data;
    Item next;

    public Item(int data) {
        this.data = data;
    }
}


public class Stack {

    private Item top;

    public void push(int data) {
        if (null == top) {
            top = new Item(data);
        } else {
            Item item = new Item(data);
            item.next = top;
            top = item;
        }
    }


    public int pop() {
        int data = top.data;
        top = top.next;
        return data;
    }


    public void printStack() {
        Item tmp = top;

        if (top == null) {
            System.out.print("Stack is empty !!");
        }
        System.out.println();
        while (tmp != null) {
            System.out.print(" > " + tmp.data);
            tmp = tmp.next;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

}
