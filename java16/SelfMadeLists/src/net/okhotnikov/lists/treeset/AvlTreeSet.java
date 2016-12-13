package net.okhotnikov.lists.treeset;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NavigableSet;
import java.util.SortedSet;

public class AvlTreeSet<E> implements NavigableSet<E> {
	
	private Comparator<? super E> comporator;
	private TreeNode root;
	private int size;
	private int height=0;
	private int nodeHeight=0;
	private LinkedHashMap<Integer,List<TreeNode>> map=new LinkedHashMap();

	
	public AvlTreeSet(Comparator<? super E> comporator) {
		super();
		this.comporator = comporator;
		root=new TreeNode(null);
		size=0;
	}

	@Override
	public Comparator<? super E> comparator() {
		return comporator;
	}

	@Override
	public E first() {
		return root.first().data;
	}

	@Override
	public E last() {
		return root.last().data;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return find((E)o)!=null;
	}	
	
	TreeNode find(E e){
		if (root.isEmpty()) return null;
		int compareRes=root.compareData(e);
		if (compareRes==0) return root;
		Branch branch=new Branch(root,compareRes>0);
		Brancherator it=new Brancherator(branch,e);
		while(it.hasNext()){
			branch=it.next();
			TreeNode res=branch.containNode(e);
			if(res!=null) return res;
			if(branch.isLeave())return null;
		}

		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		if (contains(e)) return false;
		size++;
		nodeHeight=0;
		 root.add(e);
		 return true;
	}

	@Override
	public boolean remove(Object o) {
		TreeNode node=find((E)o);
		if (node==null)return false;
		node.remove();	
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o: c){
			if(!contains(o))return false;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		root=new TreeNode(null);		
	}

	@Override
	public E lower(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E floor(E e) {
		if (root.isEmpty()) return null;

		TreeNode current=root;
		
		return null;
	}

	@Override
	public E ceiling(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E higher(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pollFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pollLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		return new AvlTreeSetIterator<E>(this);
	}

	@Override
	public NavigableSet<E> descendingSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> descendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<E> headSet(E toElement, boolean inclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<E> subSet(E fromElement, E toElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<E> headSet(E toElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<E> tailSet(E fromElement) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private int compare(E e1, E e2){
		if (comporator!=null) return comporator.compare(e1, e2);
		Comparable<E> c1=(Comparable<E>)e1;
		return c1.compareTo(e2);
	}
	
	/**
	 * For learning and development purposes only
	 * @return
	 */
	
	public void print(){
		print(root);
	}
	
	public void print(TreeNode node){
		map.clear();
		if (node==null) {
			System.out.println("Tree is empty");
			return;
		}
		node.insertWithChildren(0);
		for(List<TreeNode> list: map.values()){
			for (TreeNode n: list){
				System.out.print(n.data+" ");
			}
			System.out.println();
		}
	}
	
	
	TreeNode firstNode(){
		return root.first();
	}
	
	TreeNode lastNode(){
		return root.last();
	}
	
	 class TreeNode{
		
		E data;
		TreeNode parent,left,right;
		byte balance;
		public TreeNode(TreeNode parent) {
			this.parent=parent;
			balance=-1;
		}
		
		public void add(E e){
			if (isEmpty()) {
				data=e;
				left=new TreeNode(this);
				right=new TreeNode(this);
				balance=0;
				fixBalance();
			} else {

			if (AvlTreeSet.this.compare(e,data)>0) {
				balance++;
				right.add(e);
			}
			else {
				balance--;
				left.add(e);
			}
			
			}			
		}
		
		public void add(TreeNode node){
			if(isEmpty()){
				parent.changeChild(this, node);
			//	parent.recountBalance();
			}
			else {
				if (AvlTreeSet.this.compare(node.data,data)>0) {
					balance+=node.balance;
					right.add(node);
				}
				else {
					balance-=node.balance;
					left.add(node);
				}
				
			}
		}
		
		void fixBalance() {
			if (Math.abs(balance)>=2){
				if(balance>=2){					
					if(right.balance<0) right.rotate(true);				
					rotate(false);
				} else{				
					if(left.balance>0)left.rotate(false);
					rotate(true);
				}				
			}			
			if(parent!=null) parent.fixBalance();
		}
		
		void remove(){
			if (isLeave()){
				if(isRoot())  AvlTreeSet.this.root=null;
				else parent.dropChild(this);
			} else{
				if (left.isEmpty()){
					if(isRoot())
						AvlTreeSet.this.root=right;
					else{
						parent.changeChild(this, right);
						parent.fixBalance();
					}			
				} else if(right.isEmpty()){
					if(isRoot())
						AvlTreeSet.this.root=left;
					else{
						parent.changeChild(this, left);
						parent.fixBalance();
					}					
				} else {
					if(!isRoot())
						if(parent.isRightChild(this)){
							parent.changeChild(this, right);
							right.add(left);
							right.fixBalance();
						} else{
							parent.changeChild(this, left);
							left.add(right);
							left.fixBalance();
						}
					else
						if(balance<=0){
							left.makeRoot();;
							left.add(right);
							left.fixBalance();
						} else{
							right.makeRoot();
							right.add(left);
							right.fixBalance();
						}
				}												
			}
		//	fixBalance();
		}
		
		void makeRoot(){
			AvlTreeSet.this.root=this;
			parent=null;
		}
		
		boolean isRightChild(TreeNode node){
			return right==node;
		}

		void dropChild(TreeNode node){
			if(isRightChild(node)) right=new TreeNode(this);
			else left=new TreeNode(this);
		}
		
		void changeChild(TreeNode oldChild,TreeNode newChild){
			if(isRightChild(oldChild)) right=newChild;
			else left=newChild;
			newChild.parent=this;
		}
		
		TreeNode first(){
			if(left.isEmpty()) return this;
			return left.first();
		}
		
		TreeNode last(){
			if(right.isEmpty())return this;
			return right.last();
		}
		
		TreeNode next(){
			if(parent==null) return right.first();
			if (!right.isEmpty()) return right.first();
			if(parent.left==this)  return parent;
			return right;
		}	
		
		TreeNode previous(){
			if(parent==null) return left.last();
			if (!left.isEmpty()) return left.last();
			if(parent.right==this)  return parent;
			return left;
		}
		
		void insertWithChildren( int level){
			List<TreeNode> list=map.get(level);
			if (list==null) {
				list=new ArrayList<>();
				map.put(level, list);
			}
			list.add(this);
			if(!left.isEmpty()) left.insertWithChildren(level+1);
			if(!right.isEmpty()) right.insertWithChildren(level+1);
		}
		
		int compareData(E e){
			return AvlTreeSet.this.compare(e,data);
		}
		
		boolean isEmpty(){
			return data==null;
		}
		
		boolean isRoot(){
			return parent==null;
		}
		
		boolean isLeave(){
			return left.isEmpty()&&right.isEmpty();
		}
		
		void recountBalance(){
			balance=(byte)(right.balance-left.balance);
		}
		
		void rotate(boolean toRight){
			TreeNode myParent=parent;
			if (toRight){
				TreeNode myLeft=left;
				parent=left;
				left=myLeft.right;
				myLeft.right=this;
				myLeft.parent=myParent;
				this.recountBalance();
				myLeft.recountBalance();
				if(myParent==null) AvlTreeSet.this.root=myLeft;
				
			} else {
							
				TreeNode myRight=right;
				parent=right;
				right=myRight.left;
				myRight.left=this;
				myRight.parent=myParent;
				this.recountBalance();
				myRight.recountBalance();
				if(myParent==null) AvlTreeSet.this.root=myRight;
			}
			if (myParent!=null)
				myParent.recountBalance();			
			
		}
		
	}
	 
	 class Branch{
		 TreeNode root;
		 boolean isRight;
		 TreeNode end;
		 
		 public Branch(AvlTreeSet<E>.TreeNode root, boolean isRight) {
			this.root = root;
			this.isRight = isRight;
			end=end();
		}

		TreeNode end(){
			 return isRight ? root.right: root.left;
		 }
		
		 
		 TreeNode containNode(E e){
			 
			return AvlTreeSet.this.compare(e,root.data)==0 ? root:(end.isEmpty() ? null:
				(AvlTreeSet.this.compare(e,end.data)==0 ? end : null));
		 }
		 
		 Branch next(E e){
			 return new Branch(end,AvlTreeSet.this.compare(e,end.data)>0);	 
		 }
		 
		 TreeNode closestNode(E e){
			 return AvlTreeSet.this.compare(e,root.data)<=AvlTreeSet.this.compare(e,end.data) ?
					 root :end;
		 }
		 
		 int minDistance(E e){
			 int toRoot=AvlTreeSet.this.compare(e,root.data);
			 int toEnd=AvlTreeSet.this.compare(e,end.data);
			 return toRoot<=toEnd ? toRoot : toEnd; 
		 }
		 
		 boolean isLeave(){
			 return end.isEmpty();
		 }
		 
	 }
	 
	 class Brancherator implements Iterator<Branch>{
		 Branch current;
		 private E value;
		 

		public Brancherator(AvlTreeSet<E>.Branch current, E value) {
			super();
			this.current = current;
			this.value = value;
		}

		@Override
		public boolean hasNext() {
			return !current.isLeave();
		}

		@Override
		public AvlTreeSet<E>.Branch next() {
			Branch old=current;
			current=current.next(value);
			return old;
		}
		 
	 }
	 
	 class ToRootIterator implements Iterator<TreeNode>{
		 TreeNode current;

		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public AvlTreeSet<E>.TreeNode next() {
			TreeNode last=current;
			current=current.parent;
			return last;
		}
		 
	 }

}
