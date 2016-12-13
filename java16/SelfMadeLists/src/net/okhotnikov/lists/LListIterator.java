package net.okhotnikov.lists;


import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LListIterator<E> implements ListIterator<E> {
	private Node<E> current;
	private int currentIndex;
	private LList list;
	private Node<E> last=null;
	private int lastMove=0;
	
	public LListIterator(LList list) {
		super();
		current=list.head;
		this.list=list;
		currentIndex=0;
	}
	

	public LListIterator(LList list, int currentIndex) {
		super();
		this.current = list.head;
		this.list=list;
		this.currentIndex = 0;
		while(this.currentIndex<currentIndex){
			if(hasNext()) next();
				else throw new NoSuchElementException(); 
		}
		
	}


	Node<E> getCurrent() {
		return current;
	}


	@Override
	public boolean hasNext() {
		if (lastMove>=0)
			return current!=null;
		else
			return last!=null;
	}

	@Override
	public E next() {
	
		if (lastMove>=0 || current!=null )
		{
			lastMove=1;
			last=current;
			current=current.next;
			currentIndex++;
			return last.data;
		} else {			
			lastMove=1;
			current=last;
			return null;
		}
	}

	@Override
	public boolean hasPrevious() {
		if (lastMove<=0)
			return current!=null;
		else
			return last!=null;
	}

	@Override
	public E previous() {
		if (lastMove<=0 || current!=null )
		{
			lastMove=-1;
			last=current;
			current=current.previous;
			currentIndex--;
			return last.data;
		} else {
			lastMove=-1;
			current=last;
			return null;
		}
	}

	@Override
	public int nextIndex() {
		return currentIndex+1;
	}

	@Override
	public int previousIndex() {
		return currentIndex-1;
	}

	@Override
	public void remove() {
		if (lastMove==0||last==null) return;
		list.decSize();

		if (lastMove>=0){
				if (last==list.head){
					list.head=current;
					if (current!=null) current.previous=null;
				} else if(last==list.tail){
					list.tail=last.previous;
					if (last.previous!=null) last.previous.next=null;
				} else {
					if (last.previous!=null) 
							last.previous.insertAfter(current);
				} 												
			} else{			
				if (last==list.head){
					list.head=last;		
					if (last!=null) last.previous=null;
				} else if(last==list.tail){
					list.tail=current;
					if(current!=null)
						current.next=null;
				} else {
					if (last.next!=null) 
							last.next.insertBefore(current);
				} 
			}	
		last=null;
	}

	@Override
	public void set(E e) {
		last.data=e;
		
	}

	@Override
	public void add(E e) {
		Node<E> newNode=new Node<>(e);
		if (hasNext()) current.next.insertBefore(newNode);
		current.insertAfter(newNode);
		current=newNode;
		currentIndex++;
		list.incSize();
	}

}
