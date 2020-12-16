package eg.edu.alexu.csd.ds.maze.cs20;

public class SLLNode {
	
	    private Object data;
	    private SLLNode link;
	 
	    /*  Constructor  */
	    public SLLNode()
	    {
	        link = null;
	        data = null;
	    }    
	    /*  Constructor  */
	    public SLLNode(Object d,SLLNode n)
	    {
	        data = d;
	        link = n;
	    }    
	    /*  Function to set link to next Node  */
	    public void setNext(SLLNode n)
	    {
	        link = n;
	    }    
	    /*  Function to set data to current Node  */
	    public void setData(Object d)
	    {
	        data = d;
	    }  
	    
	    /*  Function to get link to next node  */
	    public SLLNode getNext()
	    {
	        return link;
	    }    
	    /*  Function to get data from current Node  */
	    public Object getData()
	    {
	        return data;
	    }
	}


