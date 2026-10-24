class MedianFinder {
    private ArrayList<Integer> dataStream;

    public MedianFinder() {
        dataStream = new ArrayList<>();
    }
    
    public void addNum(int num) {
        dataStream.add(num);
    }
    
    public double findMedian() {
        if(dataStream.size() > 0){
            Collections.sort(dataStream);

            if(dataStream.size() % 2 == 1){
                return dataStream.get(dataStream.size()/2);
            } else {
                double m = dataStream.get(dataStream.size()/2 - 1);
                m = m + dataStream.get(dataStream.size()/2);
                return m / 2.0;
            }
        }
        
        return 0;
    }
}
