package eg.edu.alexu.csd.ds.maze.cs20;


public class SingleLinkedList implements MyLinkedList {

    private final SNode head;
	private int size ;
	 
	public SingleLinkedList(){
            head=new SNode(null);
            size=0;
	}
	
	@Override
	public void add(int index, Object element) {
		if(index>size || index<0){
			throw new RuntimeException("error!Index isnot valid");
		}
		SNode N = new SNode(element);
		SNode Head = head;
		for(int i = 1; i <= index && Head.getNext() != null; i++)
		{
			Head = Head.getNext();
		}
		N.setNext(Head.getNext());
		Head.setNext(N);
		size++;
    }

	
	@Override
	public void add(Object element) {
	    SNode N = new SNode(element);
	    SNode Head = head;
	    while (Head.getNext() != null) {
	      	Head = Head.getNext();
        }
	    Head.setNext(N);
	    size++;
	}

	
	@Override
	public Object get(int index) {
        if(index>size || index<0){
        	throw new RuntimeException("error!Index isnot valid");
        }
        SNode N = head.getNext();
        for (int i = 0; i < index; i++) {
            if (N.getNext() == null)
                return null;
                N = N.getNext();
        }
        return N.getElement();
	}

	
	@Override
	public void set(int index, Object element) {
        if(index>size || index<0){
        	throw new RuntimeException("error!Index isnot valid");
        }
        SNode Head=head;
        int i=0 ;
        while(i<index){
        	Head=Head.getNext();
        	i++;
        }
        Head.getNext().setElement(element);	
	}
	

	@Override
	public void clear() {
        SNode Head=head; 
        while(Head.getNext()!=null){
        	SNode n=head; 
        	Head=Head.getNext();
        	n.setNext(null);
        }
        size=0;
	}
	

	@Override
	public boolean isEmpty() {
        return head.getNext()== null;
	}

	
	@Override
	public void remove(int index){
        if(index>size || index<0){
        	throw new RuntimeException("error!Index isnot valid");
        }
        SNode Head=head;
        int i=0;
        while(i<index){
        	Head=Head.getNext();
        	i++;
        }
        Head.setNext(Head.getNext().getNext());
        size--;
	}
	
	

	@Override
	public int size() {
        return size;
	}

	
	@Override
	public MyLinkedList sublist(int fromIndex, int toIndex) {
        if(fromIndex<0 || toIndex<0 || toIndex>=size || fromIndex>size || fromIndex>toIndex){
        	throw new RuntimeException("Invalid! Index isnot valid");
        }
        MyLinkedList A=new SingleLinkedList();
        SNode N = head.getNext();
        int i;
        for( i=0;i<fromIndex;i++){
        	N=N.getNext();
        }
        int k=0;
        for(int j=i;j<=toIndex;j++){
        	Object B=N.getElement();
        	A.add(k,B);
        	N=N.getNext();
        	k++;
        }
        return A;
	}

	
	@Override
	public boolean contains(Object o) {
        SNode Head=head;
        while(Head.getNext()!=null){
        	int x=((Number) Head.getNext().getElement()).intValue();
        	int y=((Number) o).intValue();
        	if(x==y){
        		return true ;
        	}
        	Head=Head.getNext();
        }
        return false;
	}
	
}

