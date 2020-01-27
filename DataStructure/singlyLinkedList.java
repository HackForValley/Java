class singlyLinkedList{
	int size;
	Node head;
	class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
		}
	}

	void addFirst(int d){
		Node n = new Node(d);
		if(head == null){
			head = n;
		}
		else{
			n.next = head;
			head = n;
		}
		size++;
	}
	
	void addLast(int d){
		Node n = new Node(d);
		if(head == null){
			head = n;
		}
		else{
			Node temp = head;
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = n;
		}
		size++;
	}

	void removeFirst(){
		if(head == null){
			System.out.println("List is Empty");
		}
		else if(size == 1){
			head = null;
			size--;
		}
		else{
			Node temp = head.next;
			head = temp;
			size--;
		}
	}

	void removeLast(){
		if(head == null){
			System.out.println("List is Empty");
		}
		else if(size == 1){
			head = null;
			size--;
		}
		else{
			Node temp = head;
			for(int i=0;i<size-2;i++){
				temp = temp.next;
			}
			temp.next = null;
			size--;
		}
	}

	void display(){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args){
		singlyLinkedList lst = new singlyLinkedList();
		lst.addFirst(10);
		lst.addFirst(20);
		lst.display();
		lst.addLast(30);
		lst.addLast(40);
		lst.display();
		lst.addFirst(0);
		lst.addLast(0);
		lst.display();
		lst.removeFirst();
		lst.removeLast();
		lst.display();
	}
	
}