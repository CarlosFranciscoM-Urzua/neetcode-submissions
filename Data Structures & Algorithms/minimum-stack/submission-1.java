class MinStack {
    private ArrayList<Integer> stack;
    //private ArrayList<Integer> orderedStack;
    private Integer min;

    public MinStack() {
        stack = new ArrayList<>();
        min = null;
    }
    
    public void push(int val) {
        stack.add(0, val);
        if(min == null || val < min) min = val;
    }
    
    public void pop() {
        int val = (int)stack.get(0);
        stack.remove(0);

        if(val == min){
            if(stack.size() == 0){
                min = null;
            } else {
                min = stack.get(0);
                for(int i = 1; i < stack.size(); i++){
                    if(stack.get(i) < min) min = stack.get(i);
                }
            }            
        }        
    }
    
    public int top() {
        return (int)stack.get(0);
    }
    
    public int getMin() {
        return (int)min;
    }
}
