package eg.edu.alexu.csd.ds.maze.cs20;

import eg.edu.alexu.csd.ds.maze.MyStack;
import eg.edu.alexu.csd.ds.maze.MyLinkedList;
public class MyStackClass implements MyStack  {
	MyLinkedList list;
	
	public MyStackClass(){
		list = new MySLinkedList();
	}
	public void add(int index, Object element) {
		 list.add(index, element);
	}
	public Object pop() {
	Object temp =list.get(list.size()-1);
	list.remove(list.size()-1);
	return temp ;
	}
	public Object peek() {
		return list.get(list.size()-1);
	}
	public void push(Object element) {
		list.add(element);
	}
	public boolean isEmpty() {
		if(list.size()==0){return true;}
		return false;
	}
	public int size() {
		return list.size();
	}

}
