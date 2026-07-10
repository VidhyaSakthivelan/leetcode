class MyStack {
    Stack<Integer> s1=new Stack<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        var it=s1.peek();
        s1.pop();
        return it;
    }
    
    public int top() {
        return s1.peek();
    }
    
    public boolean empty() {
        if(s1.isEmpty() ==true)
        {
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */