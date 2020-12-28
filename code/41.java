class MedianFinder {
    PriorityQueue<Integer> heapS;
    PriorityQueue<Integer> heapL;
    /** initialize your data structure here. */
    public MedianFinder() {
        heapS = new PriorityQueue<>();
        heapL = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        //当heapS为空或者heapS和heapL的size一样时, 优先向heapS中添加元素
        if(heapS.isEmpty() || heapS.size()==heapL.size()){
            if(!heapL.isEmpty() && num < heapL.peek()){
                heapL.add(num);
                num = heapL.poll();
            }
            heapS.add(num);
        }else{
            if(!heapS.isEmpty() && num > heapS.peek()){
                heapS.add(num);
                num = heapS.poll();
            }
            heapL.add(num);
        }
    }

    public double findMedian() {
        return heapS.size()>heapL.size()? heapS.peek() : (heapL.peek() + heapS.peek())/2.0;
    }
}