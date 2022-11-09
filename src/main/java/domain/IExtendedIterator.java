package domain;

import java.util.Iterator;

public interface IExtendedIterator<T> extends Iterator<T>{
	public T previous();

	public boolean hasPrevious();

	public void goFirst();

	public void goLast();
	
}
