//Line list class
public class LineList
{
	//The private instances of the linelist class
	private Node head;
	private int count;

	//Constructor for the line list
	//Sets count to 0 and head to null.
	public LineList()
	{
		count = 0;
		head = null;
	}

	//Method to add a new line to the linelist
	//Is given a string value to add to the front of the list.
	public void addNewLine(String data)
	{
		//If the list is empty, make the data the head of the list
		Node curr;
		if(head == null)
		{
			curr = new Node(data);
			head = curr;
		}
		//Otherwise add the string as a node to the front of the list.
		else
		{
			curr = new Node(data, head);
			head = curr;
		}
	}


	//The quick sort method for the line list.
	public void qSort()
	{
		//If the base case of the quick sort has been reached, return
		//ie if the list contains 0 or 1 node.
		if(head == null || head.getNext() == null) 
		{
			return;
		}

		//Creates a small and big list
		//As well as other variables needed.		
		LineList sml = new LineList();
		LineList big = new LineList();
		int diff;
		String cmp;		
		String pvt;

		//Take the head of the list as a pivot point.
		Node pivot = head;
		pvt = head.getData();
		head = head.getNext();
		pivot.setNull();

		//While the list still contains items
		while(head != null)
		{
			//Find the difference between the current node and the pivot
			cmp = head.getData();
			diff = cmp.compareTo(pvt);
			count++;
			
			if(diff < 0)
			{
				//add to sml list
				sml.addNewLine(cmp);
			}
			else
			{
				//add to big list
				big.addNewLine(cmp);
			}
			//get the next item from the list.
			head = head.getNext();
		}
		
		//Quick sort small and big list.
		sml.qSort();
		big.qSort();
		
		//Maintain the count
		count = count + sml.count + big.count;
		//Set the pivot to point to the head of the big list
		pivot.setNext(big.head);
		
		//Get the last item of the small list to point to the pivot.
		Node curr = sml.head;
		if(sml.head != null)
		{
			while(curr.getNext() != null)
			{
				curr = curr.getNext();
			}
			curr.setNext(pivot);
			head = sml.head;
		}
		else
		{
			head = pivot;
		}
	}


	//Method of a line list to remove any null or empty lines from the list.
	public void removeNullLines()
	{
		//Check to see if any items next item is an empty string
		//If it is, make the item point over the empty item.
		Node c = head;
		while(c.getNext() != null)
		{
			if(c.getNext().getData().equals(""))
			{
				c.setNext(c.getNext().getNext());
			}
			c = c.getNext();
		}
		//If the head is empty string, make the head the next item.
		if(head.getData().equals(""))
		{
			head = head.getNext();
		}
	}

	//The insertion sort method for the line list.
	//Sort the list using the insertion sort method.
	public void iSort()
	{
		//Make a new list to sort into
		LineList temp = new LineList();
		
		//Add the first item to this new list
		temp.addNewLine(head.getData());
		head = head.getNext();

		Node curr;
		//While there are still items in the old list
		//Insert these items using the insert method into the new list.
		while(head != null)
		{
			curr = head;
			head = head.getNext();
			curr.setNull();
			temp.insert(curr);
		}
		//Make the list save the temporary lists contents/
		count = temp.count;
		head = temp.head;

	}

	//Inserts a single node into the list using the insertion sort method.
	//Is given a node to inserts and returns void.
	public void insert(Node n)
	{
		Node Pos, curr;
		curr = n;

		//if current node is less than the head
		//put infront of the list
		count++;
		if(curr.getData().compareTo(head.getData()) < 0)
		{
			curr.setNext(head);
			head = curr;
		}
		//else if the list is only one item
		//put after head
		else if(head.getNext() == null)
		{
			head.setNext(curr);
		}
		//else while the list still has items
		else
		{
			Pos = head;
			while(Pos != null)
			{	
				//If the next item is null, add the node to the end and break the while loop
				if(Pos.getNext() == null)
				{
					Pos.setNext(n);
					break;
				}
				//Otherwise check to see if the node is less than the next item.
				else if(curr.getData().compareTo(Pos.getNext().getData()) < 0)
				{
					//If it is, insert it into the list here.
					//Then break the while loop to stop further comparisons.
					curr.setNext(Pos.getNext());
					Pos.setNext(curr);
					count++;
					break;
				}
				//Add one to count and get the next item in the list before repeating.
				count++;
				Pos = Pos.getNext();
			}
		}
	}

	//Method to print the contents of the list in the order it appears in the list.
	public void printList()
	{
		//Repeats for each item in the list and prints it on a new line.
		Node curr = head;
		while(curr != null)
		{
			System.out.println(curr.getData());
			curr = curr.getNext();
		}
		
		
	}


	//The node class, used to store strings for the line list.
	private class Node
	{
		//Class variables
		private String data;
		private Node next;

		//Constructor for null next
		public Node(String s)
		{
			data = s;
			next = null;
		}
		//Constructor
		public Node(String s, Node n)
		{
			data = s;
			next = n;
		}
		
		

		//Getters and setters
		public String getData(){ return data; }
		
		public Node getNext(){ return next; }
		
		public void setNext(Node n){ next = n; }

		//Sets the nodes next to null
		public void setNull() {next = null;}
		
		
	}
	//Getter for the count of the list.
	public int getCount() { return count; }
}
