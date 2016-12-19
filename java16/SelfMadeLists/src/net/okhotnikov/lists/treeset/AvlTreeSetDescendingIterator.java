package net.okhotnikov.lists.treeset;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AvlTreeSetDescendingIterator<E> implements Iterator<E> {
	AvlTreeSet<E> set;
	AvlTreeSet<E>.TreeNode current;
	
	

	public AvlTreeSetDescendingIterator(AvlTreeSet<E> set) {
		super();
		this.set = set;
		current=set.lastNode();
	}

	@Override
	public boolean hasNext() {
		return !current.isEmpty();
	}

	@Override
	public E next() {
		if (!hasNext()) throw new NoSuchElementException();
		E res=current.data;
		current=current.previous();
		return res;
	}

}
