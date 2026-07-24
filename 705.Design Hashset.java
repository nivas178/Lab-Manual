class MyHashSet {
    private static final int BASE = 1009;
    private LinkedList<Integer>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        buckets = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    private int hash(int key) {
        return key % BASE;
    }
    
    public void add(int key) {
        int index = hash(key);
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        buckets[index].remove((Integer) key);
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].contains(key);
    }
}
