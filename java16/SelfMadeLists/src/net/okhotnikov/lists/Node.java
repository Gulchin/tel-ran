package net.okhotnikov.lists;

class Node<T> {
	protected T data;
	protected Node<T> next;
	protected Node<T> previous;
	public Node(T data, Node<T> next, Node<T> previous) {
		super();
		this.data = data;
		this.next = next;
		this.previous = previous;
	}
	public Node(T data) {
		super();
		this.data = data;
	}
	
	void insertBefore(Node<T> node){
		previous=node;
		if (node!=null)
				node.next=this;
	}
	
	void insertAfter(Node<T> node){
		next=node;
		if (node!=null)
			node.previous=this;
	}
	
//	void insertMeBetween(Node<T> previosNode, Node<T> nextNode){
//		previosNode.insertAfter(this);
//		nextNode.insertBefore(this);
//	}
	
	
	
}
