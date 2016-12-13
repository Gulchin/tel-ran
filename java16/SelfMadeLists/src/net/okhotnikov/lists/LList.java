package net.okhotnikov.lists;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LList<E> implements List<E>,Deque<E> {
	Node<E> head;
	Node<E> tail;
	int size=0;

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head==null;
	}

	@Override
	public boolean contains(Object o) {
		for (E e: this){
			if (o==null ? e==null : e.equals(o)) return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new LListIterator<>(this);
	}

	@Override
	public Object[] toArray() {
		Object [] res=new Object[size];
		int i=0;
		for (E e: this) res[i++]=e;
		return res;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		if (a==null || a.length==0) throw new IllegalArgumentException();
		if (size==0) return (T[]) Array.newInstance(a[0].getClass(), 0);
		if (a.length>=size){
			return toArr(a);
		}		
		T[] ts = (T[]) Array.newInstance(a[0].getClass(), size);
		return toArr(ts);
	}
	
	private <T> T[] toArr(T[] b) {
		int i=0;
		for (E e: this) b[i++]=(T) e;
		return b;
		
	}

	protected void incSize(){size++;}
	protected void decSize(){size--;}
	
	@Override
	public boolean add(E e) {
		addLast(e);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		ListIterator<E> it=new LListIterator<>(this);
		while(it.hasNext()){
			E e=it.next();
			if (o==null ? e==null : e.equals(o)) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for(Object o: c){
			if(!contains(o)) return false;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		for (E e: c) if (!add(e)) return false;
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		if (c==null||c.isEmpty()) return false;
		LListIterator<E> it;
		try{
			it =new LListIterator<E> (this,index);
		}
		catch(NoSuchElementException e){
			return false;
		}
		if (!it.hasNext()) return addAll(c);
		Node<E> first=it.getCurrent();
		Node<E> last=first.next;
		Node<E> newNode=null;
		for(E e: c){
			newNode=new Node<>(e);
			first.insertAfter(newNode);
			incSize();
		}
		newNode.insertAfter(last);
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		ListIterator<E> it=new LListIterator<>(this);
		boolean somethingWasRemoved=false;
		while(it.hasNext()){
			if (c.contains(it.next())) {
				it.remove();
				somethingWasRemoved=true;
			}
		}
		return somethingWasRemoved;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		ListIterator<E> it=new LListIterator<>(this);
		boolean somethingWasRemoved=false;
		while(it.hasNext()){
			if (!c.contains(it.next())) {
				it.remove();
				somethingWasRemoved=true;
			}
		}
		return somethingWasRemoved;
	}

	@Override
	public void clear() {
		head=null;
		tail=null;
		size=0;
		
	}

	@Override
	public E get(int index) {
		ListIterator<E> it=new LListIterator<>(this);
		int count=0;
		while(it.hasNext()){
			E e=it.next();
			if (count==index) return e;
			count ++;
		}
		return null;
	}

	@Override
	public E set(int index, E element) {
		ListIterator<E> it=listIterator(index);
		E e=it.next();
		it.set(element);
		return e;
	}

	@Override
	public void add(int index, E element) {
		ListIterator<E> it=listIterator(index);
		it.add(element);
		
	}

	@Override
	public E remove(int index) {
		ListIterator<E> it=listIterator(index);
		E e=it.next();
		it.remove();
		return e;
	}

	@Override
	public int indexOf(Object o) {
		int i=0;
		for (E e: this) {
			if (o==null ? e==null :e.equals(o)) return i;
			i++;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		Iterator<E> it=descendingIterator();
		int i=0;
		while(it.hasNext()){
			E e=it.next();
			if (o==null ? e==null :e.equals(o)) return size-1-i;
			i++;
		}
		return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		return new LListIterator<>(this);
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return new LListIterator<>(this,index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		List<E> res=new LList<>();
		ListIterator<E> it=listIterator(fromIndex);
		int index=fromIndex;
		while(it.hasNext() && index<toIndex ){
			index++;
			res.add(it.next());
		}
		return  res;
	}

	@Override
	public void addFirst(E e) {
		offerFirst(e);
	}

	@Override
	public void addLast(E e) {
		offerLast(e);
	}

	@Override
	public boolean offerFirst(E e) {
		Node<E> newNode=new Node<>(e);
		if(head!=null) head.insertBefore(newNode);	
				else tail=newNode;
		head=newNode;
		size++;
		return true;
	}

	@Override
	public boolean offerLast(E e) {
		Node<E> newNode=new Node<>(e);
		if(tail!=null) tail.insertAfter(newNode);	
				else head=newNode;
		tail=newNode;	
		size++;
		return true;
	}

	@Override
	public E removeFirst() {
		if (head==null) return null;
		E e=head.data;
		if (head.next!=null)
			head.next.previous=null;
		head=head.next;
		size--;
		return e;
	}

	@Override
	public E removeLast() {
		if (tail==null) return null;
		E e=tail.data;
		if (tail.previous!=null)
			tail.previous.next=null;
		tail=tail.previous;
		size--;
		return e;
	}

	@Override
	public E pollFirst() {
		return removeFirst();
	}

	@Override
	public E pollLast() {
		return removeLast();
	}

	@Override
	public E getFirst() {
		return head.data;
	}

	@Override
	public E getLast() {
		return tail.data;
	}

	@Override
	public E peekFirst() {
		return head.data;
	}

	@Override
	public E peekLast() {
		return tail.data;
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		ListIterator<E> it=new LListIterator<>(this);
		while (it.hasNext()){
			E e=it.next();
			if (o==null ? e==null : o.equals(e)) {
				it.remove();
				return true;
			}			
		}
		return false;
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		Iterator<E> it=descendingIterator();
		while(it.hasNext()){
			E e=it.next();
			if (o==null ? e==null : o.equals(e)) {
				it.remove();
				return true;
			}			
		}
		return false;
	}

	@Override
	public boolean offer(E e) {
		 addLast(e);
		 return true;
	}

	@Override
	public E remove() {
		return removeFirst();
	}

	@Override
	public E poll() {
		return removeFirst();
	}

	@Override
	public E element() {
		return head.data;
	}

	@Override
	public E peek() {
		return head.data;
	}

	@Override
	public void push(E e) {
		addFirst(e);
		
	}

	@Override
	public E pop() {
		return removeFirst();
	}

	@Override
	public Iterator<E> descendingIterator() {
		return new DescendentLListIterator<E>(this);
	}

}
