class MedianFinder {
    private ArrayList<Integer> dataStream;
    //private Integer median;

    public MedianFinder() {
        dataStream = new ArrayList<>();
        //median = null;
    }
    
    public void addNum(int num) {
        dataStream.add(num);
        //if (dataStream.size() == 1) median = num;
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
