class MaxQueue {
    LinkedList<Integer> list1;
    LinkedList<Integer> list2;

    public MaxQueue() {
        list1 = new LinkedList<>();
        list2 = new LinkedList<>();
    }

    public int max_value() {
        if(!list2.isEmpty()){
            return list2.peekFirst();
        }
        return -1;
    }

    public void push_back(int value) {
        list1.add(value);
        while(!list2.isEmpty() && value > list2.peekLast()){
            list2.removeLast();
        }
        list2.addLast(value);
    }

    public int pop_front() {
        if(!list1.isEmpty()){
            int value = list1.poll();
            if(value == list2.peekFirst()) list2.removeFirst();
            return value;
        }
        return -1;
    }
}