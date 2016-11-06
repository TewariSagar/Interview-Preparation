class Linklist
{
	private Node head;

	public Linklist()
	{
		head = null;
	}

	//this method adds elements at the end of the list
	
	void insertAtEnd(int data)
	{
		//this is the temporary node that we have to insert
		Node n = new Node(data);
		if(head == null)
		{
			head = n;
			System.out.println("The head is: "+head.data);
			return;
		}
		Node tempCurr = head;
		while(tempCurr.next != null)
		{
			tempCurr = tempCurr.next;
		}
		tempCurr.next = n;
	} 
	//this method inserts in the front of the list
	Node insertInFront(int data) 
	{
		Node temp = new Node(data);
		if(head == null)
		{
			head = temp;
			return head;
		}
		temp.next = head;
		return temp;
	}
	//this method is used to print the list from the beginning
	void printList()
	{
		Node temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	//this inserts in specific position of link list
	Node insertPosi(int data, int posi)
	{
		Node temp = new Node(data);
		Node curr = head;
		System.out.println("THIS IS THE LIST BEFORE INSERTION AT SPECIFIC POSITION");
		printList();
		int count = 0;
		if(head == null)
		{
			if(posi == 0)
			{
				head = temp;
				return head;	
			}
			
		}
		//this is insertion in the beginning
		if(posi == 0)
		{
			temp.next = head;
			return temp;
		}
		if(posi > 0)
		{
			while(count != posi-1)
			{
				curr = curr.next;
				count++;
			}
			//System.out.println("DEBUG: " + curr.next.next.data);
			Node link = curr.next;
			curr.next = temp;
			temp.next = link;
		}
		return head;
	}

	Node deletePosi(int posi)
	{
		Node curr = head;
		int count = 0;
		if(posi == 0)
		{
			head = head.next;
			return head;
		}
		while(count != posi-1)
		{
			curr = curr.next;
			count++;
		}
		curr.next = curr.next.next;
		return head;

	}

	public static void main(String[] args)
	{
		Linklist l = new Linklist();
		l.insertAtEnd(0);
		l.insertAtEnd(1);
		l.insertAtEnd(2);
		l.insertAtEnd(3);
		//l.printList();
		l.head = l.insertInFront(9);
		l.head = l.insertInFront(8);
		l.head = l.insertPosi(4,4);
		System.out.println("THIS IS THE LIST AFTER INSERTION AT POSITION");
		l.printList();
		l.head = l.deletePosi(0);
		System.out.println("THIS IS THE LIST AFTER DELETION");
		l.printList();

	}
}