public class circularLinkedList{
	
	class Node{
		int data;
		Node next;
		public Node(int data){
			this.data = data;
		}
	}

	public Node head = null;
	public Node tail = null;
	public int size = 0;
	
	void addFirst(int item) {
		Node nn = new Node(item);
		if(size == 0) {
			head = nn;
			tail = nn;
			tail.next = head;
		}
		else {
			tail.next = nn;
			nn.next = head;
		}
		head = nn;
		size++;
	}
	
	void addLast(int item) {
		Node nn = new Node(item);
		if(size == 0 ) {
			head = nn;
			tail = nn;
			tail.next = head;
		}
		else {
		tail.next = nn;
		tail = nn;
		tail.next = head;
		}
		size++;
	}
	
	void addAt(int item, int idx) throws Exception{
		if(idx < 0 || idx > size) {
			throw new Exception("Invalid Index");
		}
		if(idx == 0) {
			addFirst(item);
		}
		if(idx == size) {
			addLast(item);
		}
		else {
		Node nn = new Node(item);
		Node temp = head;
		int i = 0;
		while(i != idx-1) {
			temp = temp.next;
			i++;
		}
		Node t = temp.next;
		temp.next = nn;
		nn.next = t;
		size++;
		}
	}
	
	void removeFirst() throws Exception {
		if(size == 0) {
			throw new Exception("Empty Linked List");
		}
		if(size == 1) {
			head = null;
			tail = null;
		}
		else {
			head = head.next;
			tail.next = head;
		}
		size--;
	}
	
	void removeLast() throws Exception {
		if(size == 0) {
			throw new Exception("Empty Linked List");
		}
		if(size == 1) {
			head = null;
			tail = null;
		}
		else {
			Node temp = head;
			int i = 0;
			while(i != size - 2) {
				i++;
				temp = temp.next;
			}
			tail = temp;
			tail.next = head;
		}
		size--;
	}
	
	void removeAt(int idx) throws Exception {
		if(size == 0) {
			throw new Exception ("Empty Linked List");
		}
		
		if(idx < 0 || idx > size) {
			throw new Exception("Invaid Index");
		}
		else if(idx == 0) {
			removeFirst();
		}
		else if(idx == size-1) {
			removeLast();
		}
		
		else {
		Node temp = head;
		int i = 0;
		while(i != idx - 1) {
			i++;
			temp = temp.next;
		}
		Node t = temp.next;
		temp.next = t.next;
		}
		size--;
	}
	
	void display() {
		
		Node temp = head;
		boolean flag = true;
		while(flag)
			 {
				System.out.println(temp.data);
				temp = temp.next;
				if(temp == head) {
					flag = false;
				}
			}
		
		}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		circularLinkedList cll = new circularLinkedList();
		cll.addFirst(10);
		cll.addFirst(20);
		cll.addFirst(30);
		cll.addFirst(40);
		cll.addFirst(50);
		cll.addFirst(60);
		cll.addLast(70);
		cll.removeFirst();
		cll.removeLast();
		cll.removeAt(2);
		cll.addAt(40, 3);
		cll.display();

	}

}
