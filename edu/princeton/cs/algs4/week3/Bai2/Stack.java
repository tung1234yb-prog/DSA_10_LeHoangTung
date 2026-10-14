package princeton.cs.algs4.week3.Bai2;


public class Stack {
    Character[] s;
    int n = 0;

    public Stack(int n){
        this.s = new Character[n];
    }

    public boolean isEmpty(){
        return this.n == 0;
    }

    public void push(Character c){
        s[n++] = c;
    }

    public char pop(){
        char res = s[--n];
        s[n] = null;
        return res;
    }
}
