import java.util.ArrayList;
import java.util.Collections;

class Solution1710 {
    private class Box implements Comparable<Box>{
        int numberOfBox;
        int numberOfUnitsPerBox;
        Box(int numberOfBox, int numberOfUnitsPerBox){
            this.numberOfBox = numberOfBox;
            this.numberOfUnitsPerBox = numberOfUnitsPerBox;
        }
        @Override
        public int compareTo(Box box){
            if(this.numberOfUnitsPerBox == box.numberOfUnitsPerBox){
                if(this.numberOfBox < box.numberOfBox){
                    return 1;
                }else{
                    return -1;
                }
            }else{
                if(this.numberOfUnitsPerBox < box.numberOfUnitsPerBox){
                    return 1;
                }else{
                    return -1;
                }
            }
        }
        @Override
        public boolean equals(Object object){
            if(object == this) return true;
            if(!(object instanceof Box)) return false;
            Box box = (Box) object;
            return this.numberOfBox == box.numberOfBox && this.numberOfUnitsPerBox == box.numberOfUnitsPerBox;
        }
        @Override
        public String toString(){
            return "["+this.numberOfBox+","+this.numberOfUnitsPerBox+"]";
        }
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        ArrayList<Box> arrayList = new ArrayList<>();
        for(int i=0;i<boxTypes.length;i++){
            arrayList.add(new Box(boxTypes[i][0], boxTypes[i][1]));
        }
        Collections.sort(arrayList);
        int index = 0;
        int result = 0;
        int length = arrayList.size();
        while(truckSize!=0 && index < length){
            if(arrayList.get(index).numberOfBox<truckSize){
                truckSize-=arrayList.get(index).numberOfBox;
                result += arrayList.get(index).numberOfUnitsPerBox * arrayList.get(index).numberOfBox;
            }else{
                result+=arrayList.get(index).numberOfUnitsPerBox * truckSize;
                truckSize = 0;
            }
            index++;
        }
        return result;
    }
}