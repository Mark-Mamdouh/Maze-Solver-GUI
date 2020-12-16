package eg.edu.alexu.csd.ds.maze.cs20;

import java.util.NoSuchElementException;

public class QueueUsingLinkedLists implements MyQueue {

	private int size=0;
	SingleLinkedList obj= new SingleLinkedList();
	
	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		obj.add(item);
		size++;
	}

	@Override
	public Object dequeue(){
		// TODO Auto-generated method stub
		if (isEmpty()){
			throw new NoSuchElementException("Underflow Exception");
		}
		Object element = obj.get(0);
		obj.remove(0);
		size--;
		return element;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
