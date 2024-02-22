
 import java.util.Stack;

class MaxStack {

    Stack<Integer> maxStk;
    Stack<Integer> minStk;

    public MaxStack() {
        maxStk = new Stack<>();
        minStk = new Stack<>();
    }

    public void push(int val) {
        maxStk.push(val);
        val = Math.max(val, minStk.isEmpty() ? val : minStk.peek());
        minStk.push(val);    
    }

    public void pop() {
        maxStk.pop();
        minStk.pop();
    }

    public int top() {
        return maxStk.peek();
    }

    public int getMax() {
        return minStk.peek(); 
    }
}

