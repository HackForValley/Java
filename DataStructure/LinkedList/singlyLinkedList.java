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

	void addAt(int idx, int d){
		Node temp = head;
		Node n = new Node(d);
		n.next = null;
		try{
			if(idx > size){
				throw new ArrayIndexOutOfBoundsException();
			}
			else if(idx == 0){
				n.next = temp;
				head = n;
				size++;
			}
			else{
				Node t = head;
				for(int i=0;i<idx;i++){
					if(i == idx - 1){
						t = temp;
					}
					temp = temp.next;
				}
				n.next = temp;
				t.next = n;
				size++;
			}
			
		}
		catch(Exception e){
			System.out.println("Index out of bound, Size of array is: "+size);
		}
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

	void removeAt(int idx){
		if(idx > size){
			System.out.println("Index out of Bound");
		}
		else if(idx == 0){
			Node temp = head;
			head = temp.next;
			size--;
		}
		else{
			Node temp = head;
			Node t = head;
			for(int i=0;i<idx;i++){
				if(i == idx-1){
					t = temp;
				}
				temp = temp.next;		
			}
			t.next = temp.next;
			size--;
		}
	}

	boolean detectLoopList(){
		return detectLoopList(head);
	}

	boolean detectLoopList(Node head){
		LinkedList l = new LinkedList();
		for(int i=0;i<size;i++){
			l.addLast(0);
		}
		Node temp = head;
		Node temp2 = l.head;
		while(temp != null){
			if(temp2.data == 1){
				return true;
			}
			temp2.data = 1;
			temp = temp.next;
			temp2 = temp2.next;
		}
		
		return false;
	}

	int middleElement(){
		Node slow = head;
		Node fast = head;
		if(head == null){
			System.out.println("List is Empty");
			return Integer.MIN_VALUE;
		}
		else{
			while(fast!=null && fast.next!=null){
				fast = fast.next.next;
				slow = slow.next;
			}
			return slow.data;
		}
		
	}

	int nthFromLast(int n){
		if(n > size){
			System.out.println("Value is greater than size");
			return Integer.MIN_VALUE;
		}
		else{
			Node temp = head;
			for(int i=0;i<size-n;i++){
				temp = temp.next;
			}
			return temp.data;
		}
	}

	void reverse(){
		Node current = head;
		Node prev = null;
		Node next;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
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