package eg.edu.alexu.csd.ds.maze.cs20;

import eg.edu.alexu.csd.ds.maze.MyLinkedList;

public class MySLinkedList implements MyLinkedList  {
	public SLLNode start;
    public SLLNode end ;
    public int size ;
 
    /*  Constructor  */
    public MySLinkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        return size==0;
    } 
    public void add(Object element)
    {
    	SLLNode node = new SLLNode(element,null);    
        size++ ;    
        if(start == null) 
        {
            start = node;
            end = start;
        }
        else 
        {
            end.setNext(node);
            end = node;
        }
    }
    /*  Function to insert an element at position  */
    public void add  (int index, Object element)
    {	if(size<index||index<0){throw new RuntimeException("index error!") ;}
    	if(size==index){add(element); return;}
    	SLLNode node = new SLLNode(element,null);                
    	SLLNode node2 = start;
      
        if (index==0){
        	size++;
    		node.setNext(node2);
    		start=node;
    		return;
    	}
        index--;
        for (int i =0 ; i < size; i++) 
        {
            if (i == index) 
            {
            	SLLNode tmp = node2.getNext() ;
                node2.setNext(node);
                node.setNext(tmp);
                break;
            }
            node2 = node2.getNext();
        }
        size++ ;
    }
    /*  Function to delete an element at position  */
    public void remove(int index)
    {    if(size<=index||index<0){throw new RuntimeException("index error!");} 
    	SLLNode node ;
    	SLLNode tmp ;

        if (index == 0) 
        {
            start = start.getNext();
            size--; 
            return ;
        }
        if (index == size-1) 
        {
        	node = start;
        	tmp = start;
            while (node != end)
            {
                tmp = node;
                node = node.getNext();
            }
            end = tmp;
            end.setNext(null);
            size --;
            return;
        }
         node = start;
        index -- ;
        for (int i = 0; i < size ; i++) 
        {
            if (i == index) 
            {
            	tmp = node.getNext();
                tmp = tmp.getNext();
                node.setNext(tmp);
                break;
            }
            node = node.getNext();
        }
        size-- ;
       
    }    
    public void clear(){
    	start=null;
    	end=start;
    	size=0;
    	
    }
    public boolean contains(Object o){
    	SLLNode node = start;
    	if(size==0&&o==null){return true ; }
    	if(size==0&&o!=null){return false ; }
    	while (node.getNext()!=null){
    		if (o==node.getData()){return true;}
    		node=node.getNext();
    	}
    	if(o==node.getData()){return true;}
    	return false;
    }
    public void set(int index,Object element){
    	SLLNode node = start ;
    	int i =0;
    	if(size<=index||index<0){throw new RuntimeException("index error!");}
    	while(node.getNext()!=null){
    		if (i==index){
    			node.setData(element);
    			break;
    		}
    		node=node.getNext();
    		i++;
    	}
    	if (size ==1){node.setData(element);}
    	
    }
    public int size() {
		// TODO Auto-generated method stub
		return size ;
	}
    public MySLinkedList sublist(int fromIndex, int toIndex){
    	int i =0;
    	MyLinkedList list = new MySLinkedList();
    	SLLNode node = start;
    	//SLLNode node2 = list.start;
    	if(fromIndex>toIndex||fromIndex>size||toIndex>size||fromIndex<0||toIndex<0)
    	{throw new RuntimeException("index error!");}
    	while(i<fromIndex){
    		node=node.getNext();
    		i++;
    	}
    	while(i<toIndex){
    		list.add(node.getData());
    		node=node.getNext();
    		i++;
    	}
    	list.add(node.getData());
    	return (MySLinkedList) list;
    }
    public Object get(int index) {
    	if (index >=size||index<0){throw new RuntimeException("index error!");}
		SLLNode node = start ;
		int i =0;
		while (node.getNext()!= null){
			if (i==index){return node.getData();}
			node=node.getNext();
			i++;
		}
		if (size-index==1){return end.getData();}
		return null;
	}
		

	
    }

	

