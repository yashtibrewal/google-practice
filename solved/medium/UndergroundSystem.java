package solved.medium;

import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    private class Source{
        private String startStation;
        private int startTime;
        Source(String startStation,int startTime){
            this.startStation = startStation;
            this.startTime = startTime;
        }
        @Override
        public boolean equals(Object object){
            if(object == null) return false;
            if(object.getClass() != getClass()) return false;
            Source source = (Source)object;
            return source.startStation.equals(startStation) && source.startTime == startTime;
        }
    }

    private class Destination{
        private String endStation;
        private int endTime;
        Destination(String endStation,int endTime){
            this.endStation = endStation;
            this.endTime = endTime;
        }
        @Override
        public boolean equals(Object object){
            if(object == null) return false;
            if(object.getClass() != getClass()) return false;
            Destination destination = (Destination)object;
            return destination.endStation.equals(endStation) && destination.endTime == endTime;
        }
    }

    class Intransit{
        String startStation;
        int startTime;
        Intransit(String startStation, int startTime){
            this.startStation = startStation;
            this.startTime = startTime;
        }
    }

    HashMap<Source,Destination> travelHistory;
    HashMap<Integer,Intransit> inTransitRecords;

    public UndergroundSystem() {
        travelHistory = new HashMap<>();
        inTransitRecords = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        inTransitRecords.put(id, new Intransit(stationName,t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Intransit inTransit = inTransitRecords.get(id);
        inTransitRecords.remove(id);
        Source source = new Source(inTransit.startStation, inTransit.startTime);
        Destination destination= new Destination(stationName, t);
        travelHistory.put(source, destination);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        double totalTime = 0;
        int counter = 0;
        for(Map.Entry<Source, Destination> entry:travelHistory.entrySet()){
            
            if(entry.getKey().startStation.equals(startStation) && entry.getValue().endStation.equals(endStation)){
                totalTime += entry.getValue().endTime - entry.getKey().startTime;
                counter++;
            }
        }
        return totalTime/counter;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */