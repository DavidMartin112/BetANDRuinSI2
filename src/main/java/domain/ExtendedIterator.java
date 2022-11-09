package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExtendedIterator<E> implements IExtendedIterator<E>{
	private ArrayList<E> array= new ArrayList<E>();
	private int index=0;
	public boolean hasNext() {
		return index<array.size()-1;
	}
	public ExtendedIterator (List<Event> ev){
		array.addAll((Collection<? extends E>) ev);
		
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

