package eg.edu.alexu.csd.ds.maze.cs20;

public class SNode {
    private Object element; 
    private SNode next;

    public SNode(Object s){
	element=s;
    }
	
    public Object getElement() { 
	return element;
    }

    public SNode getNext() { 
	return next; 
    }

    public void setElement(Object newElem) {
	element = newElem;
    }

    public void setNext(SNode newNext) {
	next = newNext;
    }
}