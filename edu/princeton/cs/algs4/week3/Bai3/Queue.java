package princeton.cs.algs4.week3;

public class Queue {
    String[] s;
    int tail;
    int head;

    public Queue(){
        s = new String[10];
        tail = 0;
        head = 0;
    }

    public void resize(int cap){
        String[] copy = new String[cap];

        int n = tail - head;
        for (int i = 0; i < n; i++){
            copy[i] = s[head + i];
        }
        s = copy;
        head = 0;
        tail = n;
    }

    public boolean isEmpty(){
        return tail == head;
    }

    public void enqueue(String data){
        if (tail == s.length){
            if (head > 0){
                resize(s.length);
            }
            else{
                resize(s.length * 2);
            }
        }
        else{
            s[tail++] = data;
        }
    }

    public String dequeue(){
        String res = s[head];
        s[head++] = null;
        return res;
    }
}
