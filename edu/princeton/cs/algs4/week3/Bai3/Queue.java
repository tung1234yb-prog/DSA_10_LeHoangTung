package princeton.cs.algs4.week3.Bai3;

public class Queue {
    public class Node{
        String data;
        Node next;

        public Node(String data){
            this.data = data;
            next = null;
        }
    }

    public class Stack{
        Node top;

        public Stack(){
            top = null;
        }

        public boolean isEmpty(){
            return top == null;
        }

        public void push(String data){
            Node newNode = new Node(data);

            newNode.next = top;
            top = newNode;
        }

        public String pop(){
            Node node = top;
            String data = node.data;
            top = node.next;
            node = null;
            return data;
        }
    }

    Stack inStack;
    Stack outStack;

    public boolean isEmpty(){
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public void transfer(){
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }

    public void enqueue(String data){
        inStack.push(data);
    }

    public String dequeue(){
        if (outStack.isEmpty()){
            transfer();
        }
        return outStack.pop();
    }
}
