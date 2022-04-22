package solved.easy;
import java.util.ArrayList;
import java.util.Collections;

class Solution937 {
    private class LetterLog implements Comparable<LetterLog> {
        String identifier;
        StringBuilder logs;

        LetterLog(String data) {
            String[] words = data.split(" ");
            identifier = words[0];
            logs = new StringBuilder();
            for(int i=1;i<words.length;i++){
                logs.append(" "+words[i]);
            }
        }

        @Override
        public int compareTo(LetterLog letterLog) {
            int result = this.logs.compareTo(letterLog.logs);
            if(result == 0){
                return this.identifier.compareTo(letterLog.identifier);
            }else{
                return result;
            }
        }
        @Override
        public String toString(){
            return identifier + logs.toString();
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        // seperate letter to digital logs
        ArrayList<LetterLog> letterLogs = new ArrayList<>();
        ArrayList<String> digitalLogs = new ArrayList<>();
        String[] words;
        for (String entry : logs) {
            words = entry.split(" ");
            if (words[1].charAt(0) >= '0' && words[1].charAt(0) <= '9') {
                digitalLogs.add(entry);
            } else {
                letterLogs.add(new LetterLog(entry));
            }
        }
        // for letterlogs split them with first word and other words
        // sort with priority of other words and then the first word, called identifier
        // here
        Collections.sort(letterLogs);
        String[] result = new String[logs.length];
        int index = 0;
        for (LetterLog entry : letterLogs) {
            result[index] = entry.toString();
            index++;
        }
        for (String entry : digitalLogs) {
            result[index] = entry;
            index++;
        }
        return result;
    }

}