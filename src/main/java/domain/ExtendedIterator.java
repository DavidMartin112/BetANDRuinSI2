package domain;

import java.util.ArrayList;

public class ExtendedIterator<E>{
	private ArrayList<E> array= new ArrayList<E>();
	private int index=0;
	public boolean hasNext() {
		return index<array.size()-1;
	}
	public ExtendedIterator (ArrayList<E> arr){
		array=arr;
		
	}
	public E next() {
		return array.get(++index);
	}

	public E previous() {
		return array.get(--index);
	}

	public boolean hasPrevious() {
		return index>0;
	}

	public void goFirst() {
		index=0;
		
	}

	public void goLast() {
		index=array.size()-1;
		
	}

}

