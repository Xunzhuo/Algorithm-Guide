class MinStack {
    Stack<Integer> stack;

    Stack<Integer> minstack;

    /** initialize your data structure here. */

    public MinStack() {
        stack = new Stack();

        minstack = new Stack();

    }



    public void push(int x) {
        stack.push(x);

        if(minstack.isEmpty()||x<=minstack.peek()){
            minstack.push(x);

        }else{
            minstack.push(minstack.peek());

        }

    }

    public void pop() {
        stack.pop();

        minstack.pop();

    }



    public int top() {
        return stack.peek();

    }



    public int min() {
        return minstack.peek();

    }

}