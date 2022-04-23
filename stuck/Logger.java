package stuck;
import java.util.HashMap;

class Logger {
    HashMap<String, Integer> logs;
    public Logger() {
        logs = new HashMap<>();
    }
    private boolean isPrintable(int timestamp, String message){
        if(!logs.containsKey(message)){
            logs.put(message, timestamp+10);
            return true;
        }
        int allowedTimestamp = logs.get(message);
        if(allowedTimestamp<=timestamp){
            logs.put(message, logs.get(message)+10);
            return true;
        }
        return false;
         
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        return isPrintable(timestamp,message);
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */