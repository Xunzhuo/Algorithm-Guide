class CQueue {
    private Stack<Integer> a;
    private Stack<Integer> b;
    public CQueue() {
        a=new Stack<Integer>();
        b=new Stack<Integer>();
    }

    public void appendTail(int value) {
        a.push(value);
    }

    public int deleteHead() {
        if(!b.empty()){
            return b.pop();
        }
        else if(a.empty()){
            return -1;
        }
        else{
            while(!a.empty())
                b.push(a.pop());
            return b.pop();
        }
    }
}
/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */