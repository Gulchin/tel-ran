package net.okhotnikov.lists.treeset;

import java.util.Iterator;
import java.util.NoSuchElementException;

import net.okhotnikov.lists.treeset.AvlTreeSet.TreeNode;

public class AvlTreeSetIterator<E> implements Iterator<E> {
	private AvlTreeSet<E> set;
	private AvlTreeSet<E>.TreeNode current;
	

	public AvlTreeSetIterator(AvlTreeSet<E> set) {
		super();
		this.set = set;
		current=set.firstNode();
	}

	@Override
	public boolean hasNext() {
		return !current.isEmpty();
	}

	@Override
	public E next() {
		if (!hasNext()) throw new NoSuchElementException();
		E res=current.data;
		System.out.println("balanse :"+current.balance);
		current=current.next();
		return res;
	}

}
