class MinStack {
    Stack<int[]> s1=new Stack<>();
   // long  minValue=Long.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int value) {//O(1)
       // minValue=Math.min(minValue,value);
        if(s1.isEmpty()==true)
        {
            s1.push(new int[]{value,value});
        }
        else
        {
            s1.push(new int[]{value,Math.min(s1.peek()[1],value)});
        }
    }
    
    public void pop() {//O(1)
        s1.pop();
    }
    
    public int top() {
        var it=s1.peek();
        int value=it[0];
        return value;
    }
    
    public int getMin() {
        var it=s1.peek();
        int minValue=it[1];
        return minValue;
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