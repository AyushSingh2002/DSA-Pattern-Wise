import java.util.Stack;

class MinStack {

    // Using a java record for storing pairs
    private record Pair<F, S>(F first, S second){}
    public Stack<Pair<Integer, Integer>> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int value) {
        if(stack.isEmpty()) stack.push(new Pair<>(value, value));
        else stack.push(new Pair<>(value, Math.min(stack.peek().second(), value)));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().first();
    }
    
    public int getMin() {
        return stack.peek().second();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */