package solved.easy;
class Solution1184{
    
    private int getClockwiseDistance(int[] distance, int start, int end) {
        int distanceTotal = 0;
        for(int i=start;i<end;i++){
            distanceTotal += distance[i];
        }
        return distanceTotal;
    }
    
    private int getAntiClockwiseDistance(int[] distance, int start, int end) {
        int distanceTotal = 0;
        for(int i=0;i<start;i++){
            distanceTotal += distance[i];
        }
        for(int i=end;i<distance.length;i++){
            distanceTotal += distance[i];
        }
        return distanceTotal;
    }
    
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
       int temp;
        if(start<destination){
           temp = destination;
           destination =start;
           start = temp;
       }
        return Math.min(getClockwiseDistance(distance, start, destination),
                        getAntiClockwiseDistance(distance, start, destination));
    }
}

class Solution1184Test{
    public static void main(String[] args){
        Solution1184 solution1184 = new Solution1184();
        System.out.println(solution1184.distanceBetweenBusStops(new int[]{1,2,3,4}, 0,3));
    }
}