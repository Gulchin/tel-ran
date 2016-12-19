package net.okhotnikov.lists.treeset;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import java.util.function.Predicate;

public class AvlTreeSet<E> implements NavigableSet<E> {
	
	protected Comparator<? super E> comporator;
	protected TreeNode root;
	protected int size;
	private LinkedHashMap<Integer,List<TreeNode>> map=new LinkedHashMap();
	AvlTreeSet<E> parent;	
	
	public AvlTreeSet(Comparator<? super E> comporator) {
		super();
		this.comporator = comporator;
		root=new TreeNode(null);
		size=0;
	}
	
	private AvlTreeSet(){
		
	}

	boolean isView(){
		return parent!=null;
	}
	
	void shiftSize(int deltaSize){
		size+=deltaSize;
		if(isView()) parent.shiftSize(deltaSize);
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
		Iterator<E> it=iterator();
		return !it.hasNext();
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
		SearchIterator it=new SearchIterator(branch,e);
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

	@Override
	public boolean add(E e) {
		if (contains(e)) return false;
		shiftSize(1);
		 root.add(e);
		 return true;
	}

	@Override
	public boolean remove(Object o) {
		TreeNode node=find((E)o);
		if (node==null)return false;
		node.remove();
		shiftSize(-1);
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
		boolean wasAdded=false;
		for(E e:c){
			if (add(e)) {
				wasAdded=true;
				shiftSize(1);
			}
		}
		return wasAdded;
	}
	//I know this is not optimal performance :(
	@Override
	public boolean retainAll(Collection<?> c) {
		NodeIterator it =new NodeIterator(firstNode());
		HashSet<TreeNode> set=new HashSet();
		while(it.hasNext()){
			TreeNode node=it.next();
			if(c.contains(node.data)){
				set.add(node);			
			}
		}
		return removeAll(set);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean wasRemoved=false;
		for (Object o:c){
			if(remove(o)) wasRemoved=true;
		}
		return wasRemoved;
	}

	void sizeToZero(){
		size=0;
		if(isView()) parent.sizeToZero();
	}
	@Override
	public void clear() {
		root.data=null;
		root.left=new TreeNode(root);
		root.right=new TreeNode(root);
		sizeToZero();		
		root.balance=0;
		if(root.parent!=null){
			root.parent.recountBalance();
			root.parent.fixBalance();
		}
	}

	@Override
	public E lower(E e) {
		Iterator<E> it=iterator();
		if (!it.hasNext()) return null;
		E setElement=it.next();
		int compareRes=compare(e, setElement);
	
		if (compareRes<=0) return null;
		E lastE=setElement;
		while(it.hasNext()){
			setElement=it.next();
			compareRes=compare(e, setElement);

			if (compareRes<=0) return lastE;
			lastE=setElement;
		}		
		return setElement;
	}

	@Override
	public E floor(E e) {
		Iterator<E> it=iterator();
		if (!it.hasNext()) return null;
		E setElement=it.next();
		int compareRes=compare(e, setElement);
		if (compareRes==0)return setElement;
		if (compareRes<0) return null;
		E lastE=setElement;
		while(it.hasNext()){
			setElement=it.next();
			compareRes=compare(e, setElement);
			if (compareRes==0)return setElement;
			if (compareRes<0) return lastE;
			lastE=setElement;
		}		
		return setElement;
	}

	@Override
	public E ceiling(E e) {
		Iterator<E> it=descendingIterator();
		if (!it.hasNext()) return null;
		E setElement=it.next();
		int compareRes=compare(e, setElement);
		if (compareRes==0)return setElement;
		if (compareRes>0) return null;
		E lastE=setElement;
		while(it.hasNext()){
			setElement=it.next();
			compareRes=compare(e, setElement);
			if (compareRes==0)return setElement;
			if (compareRes>0) return lastE;
			lastE=setElement;
		}		
		return setElement;
	}

	@Override
	public E higher(E e) {
		Iterator<E> it=descendingIterator();
		if (!it.hasNext()) return null;
		E setElement=it.next();
		int compareRes=compare(e, setElement);
	
		if (compareRes>=0) return null;
		E lastE=setElement;
		while(it.hasNext()){
			setElement=it.next();
			compareRes=compare(e, setElement);

			if (compareRes>=0) return lastE;
			lastE=setElement;
		}		
		return setElement;
	}

	@Override
	public E pollFirst() {
		TreeNode first=firstNode();
		if (first.isEmpty()) return null;
		E res=first.data;
		first.remove();
		shiftSize(-1);
		return res;
	}

	@Override
	public E pollLast() {
		TreeNode last=lastNode();
		if (last.isEmpty()) return null;
		E res=last.data;
		last.remove();
		shiftSize(-1);
		return res;
	}

	@Override
	public Iterator<E> iterator() {
		return new AvlTreeSetIterator<E>(this);
	}

	@Override
	public NavigableSet<E> descendingSet() {
		AvlTreeSet<E> res=new DescendingTree<>();
		initChild(res);
		return res;
	}
	
	private void initChild(AvlTreeSet<E> set){
		set.root=root;
		set.comporator=comporator;
		set.size=size;
		set.parent=this;
	}

	@Override
	public Iterator<E> descendingIterator() {
		return new AvlTreeSetDescendingIterator<E>(this);
	}

	@Override
	public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
		SubTree tree=new SubTree(comporator, fromElement,fromInclusive, toElement,toInclusive);
		initChild(tree);
		tree.recountSize();
		return tree;
	}

	@Override
	public NavigableSet<E> headSet(E toElement, boolean inclusive) {
		SubTree tree=new SubTree(comporator, null,false, toElement,inclusive);
		initChild(tree);
		tree.recountSize();
		return tree;
	}

	@Override
	public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
		SubTree tree=new SubTree(comporator, fromElement,inclusive, null,false);
		initChild(tree);
		tree.recountSize();
		return tree;
	}

	@Override
	public SortedSet<E> subSet(E fromElement, E toElement) {
		SubTree tree=new SubTree(comporator, fromElement, toElement);
		initChild(tree);
		tree.recountSize();
		return tree;
	}

	@Override
	public SortedSet<E> headSet(E toElement) {
		SubTree tree=new SubTree(comporator, null, toElement);
		initChild(tree);
		tree.recountSize();
		return tree;
	}

	@Override
	public SortedSet<E> tailSet(E fromElement) {
		SubTree tree=new SubTree(comporator, fromElement, null);
		initChild(tree);
		tree.recountSize();
		return tree;
	}
	
	int compare(E e1, E e2){
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
		boolean isFirst=false;
		boolean isLast=false;
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
			if(isRoot()) return right.first();
			if (!right.isEmpty()) return right.first();
			if(parent.left==this)  return parent;
			if(parent.isRoot()) if( left.isEmpty()) return right;
			else return first();
			if(!parent.parent.isRightChild(parent)) return parent.parent;
			return right;
		}	
		
		TreeNode previous(){				
			if(isRoot()) return left.last();
			if (!left.isEmpty()) return left.last();
			if(parent.right==this)  return parent;
			if(parent.isRoot()) if(right.isEmpty()) return left;
			else return last();
			if(parent.parent.isRightChild(parent)) return parent.parent;
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
			//return parent==null;
			return this==AvlTreeSet.this.root;
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
				left.parent=this;
				myLeft.right=this;
				myLeft.parent=myParent;
				this.recountBalance();
				myLeft.recountBalance();
				if(myParent==null) AvlTreeSet.this.root=myLeft;
				
			} else {
							
				TreeNode myRight=right;
				parent=right;
				right=myRight.left;
				right.parent=this;
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
	 
	 
	 class NodeIterator implements Iterator<TreeNode> {
		 
		TreeNode current;
		 
		public NodeIterator(AvlTreeSet<E>.TreeNode current) {
			super();
			this.current = current;
		}

		@Override
		public boolean hasNext() {
			return !current.isEmpty();
		}

		@Override
		public AvlTreeSet<E>.TreeNode next() {
			if (!hasNext()) throw new NoSuchElementException();
			TreeNode res=current;
			current=current.next();
			return res;
		}
		 
	 }
	 
	 class DescendingNodeIterator implements Iterator<TreeNode> {
		 
		TreeNode current;
		 

		public DescendingNodeIterator(AvlTreeSet<E>.TreeNode current) {
			super();
			this.current = current;
		}

		@Override
		public boolean hasNext() {
			return !current.isEmpty();
		}

		@Override
		public AvlTreeSet<E>.TreeNode next() {
			if (!hasNext()) throw new NoSuchElementException();
			TreeNode res=current;
			current=current.previous();
			return res;
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
	 
	 class SearchIterator implements Iterator<Branch>{
		 Branch current;
		 private E value;
		 

		public SearchIterator(AvlTreeSet<E>.Branch current, E value) {
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
	 
	 class DescendingTree<T> extends AvlTreeSet<T>{
			 
		@Override
		public T first() {
			return super.last();
		}

		@Override
		public T last() {
			return super.first();
		}

		@Override
		public Iterator<T> iterator() {
			return super.descendingIterator();
			
		}

		@Override
		public Iterator<T> descendingIterator() {
			return super.iterator();
		}		 		 
	 }
	 
	 class SubTree extends AvlTreeSet<E>{
		 E fromElement=null;
		 boolean fromInclusive=false;
		 E toElement=null;
		 boolean toInclusive=false;
		 SubTreePredicate predicate=new SubTreePredicate(this);
		 
		public SubTree(Comparator<? super E> comporator, E fromElement, boolean fromInclusive, E toElement,
				boolean toInclusive) {
			super(comporator);
			this.fromElement = fromElement;
			this.fromInclusive = fromInclusive;
			this.toElement = toElement;
			this.toInclusive = toInclusive;
		}

		public SubTree(Comparator<? super E> comporator, E fromElement, E toElement) {
			super(comporator);
			this.fromElement = fromElement;
			this.toElement = toElement;
		}

			void recountSize(){
			Iterator<E> it=iterator();
			size=0;
			while(it.hasNext()){
				it.next();
				size++;
			}
		}
		@Override
		public Iterator<E> iterator() {
			return new FilteredIterator<>(super.iterator(),predicate);
		}

		@Override
		public Iterator<E> descendingIterator() {
			return new FilteredIterator<>(super.descendingIterator(),predicate);
		}

		@Override
		public E first() {
			Iterator<E> it=iterator();
			if(!it.hasNext()) return null;
			return it.next();
		}

		@Override
		public E last() {
			Iterator<E> it=descendingIterator();
			if(!it.hasNext()) return null;
			return it.next();
		}

		@Override
		AvlTreeSet<E>.TreeNode find(E e) {
			TreeNode found=super.find(e);
			return predicate.test(found.data) ? found : null;
		}

		@Override
		AvlTreeSet<E>.TreeNode firstNode() {
			TreeNode res=super.firstNode();
			do{
				if (predicate.test(res.data)) return res;
				res=res.next();
			} while(!res.isEmpty());
			return null;
		}

		@Override
		AvlTreeSet<E>.TreeNode lastNode() {
			TreeNode res=super.lastNode();
			do{
				if (predicate.test(res.data)) return res;
				res=res.previous();
			} while(!res.isEmpty());
			return null;
		}

		@Override
		public void clear() {
			Iterator<TreeNode> it=new FilteredIterator<>(new NodeIterator(firstNode()),
					new SubTreeNodePredicate(predicate));
			while(it.hasNext()){
				TreeNode node=it.next();
				node.remove();
				shiftSize(-1);
			}
		}
										 
		
		 
	 }
	 
	 class SubTreePredicate implements Predicate<E>{
		 SubTree tree;

		public SubTreePredicate(AvlTreeSet<E>.SubTree subTree) {
			super();
			this.tree = subTree;
		}

		@Override
		public boolean test(E t) {
			boolean isUnderTop=false;
			boolean isAboveBottom=false;
			if(tree.toElement!=null)
				isUnderTop=tree.toInclusive ? (tree.compare(t, tree.toElement)<=0) :
				(tree.compare(t, tree.toElement)<0);
			if(tree.fromElement!=null)	
			isAboveBottom=tree.fromInclusive ? (tree.compare(t, tree.fromElement)>=0) :
				(tree.compare(t, tree.fromElement)>0);
			if(tree.fromElement==null) 
				return (tree.toElement==null) ? true : isUnderTop;
			return (tree.toElement==null) ? isAboveBottom : isUnderTop&&isAboveBottom;				
		}
		 
	 }
	 
	 class SubTreeNodePredicate implements Predicate<TreeNode>{
		 SubTreePredicate subTreePredicate;
		 

		public SubTreeNodePredicate(AvlTreeSet<E>.SubTreePredicate subTreePredicate) {
			super();
			this.subTreePredicate = subTreePredicate;
		}


		@Override
		public boolean test(AvlTreeSet<E>.TreeNode t) {
			return subTreePredicate.test(t.data);
		}
		 
	 }
	 	 

}
