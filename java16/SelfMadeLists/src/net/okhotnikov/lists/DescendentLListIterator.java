package net.okhotnikov.lists;

import java.util.Iterator;

public class DescendentLListIterator<E> implements Iterator<E> {
	private Node<E> current;
	private LList list;
	
	
	public DescendentLListIterator(LList list) {
		super();
		this.current = list.tail;
		this.list=list;
	}

	@Override
	public boolean hasNext() {
		return current!=null;
	}

	@Override
	public E next() {
		E e=current.data;
		current=current.previous;
		return e;
	}

	@Override
	public void remove() {
		current.insertAfter(current.next.next);	
		list.decSize();
	}
	
	

}
