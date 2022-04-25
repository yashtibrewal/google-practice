package solved.medium;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
	ArrayList<Integer> list;
    int pointer;
    public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        list = new ArrayList<Integer>();
        while(iterator.hasNext()){
            list.add(iterator.next());
        }
        pointer = 0;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return list.get(pointer);
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if(pointer == list.size()){
            throw new NoSuchElementException();
        }
	    int result = list.get(pointer);
        pointer++;
        return result;
	}
	
	@Override
	public boolean hasNext() {
        return pointer < list.size();
	}
}