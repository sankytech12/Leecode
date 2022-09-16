class CustomStack {
    private List<Integer> ll;
    private int sz;
    public CustomStack(int maxSize) {
       sz=maxSize;
        ll=new ArrayList();
        
    }
    
    public void push(int x) {
        if(ll.size()<sz){
            ll.add(x);
        }
    }
    
    public int pop() {
        return ll.size()==0?-1:ll.remove(ll.size()-1);
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<k && i<ll.size();i++){
            ll.set(i,val+ll.get(i));
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */