package coursera;

public class ArrayStack {
	
	private int N = 0;
	private String[] s;
	
	public ArrayStack(int capacity){
		s = new String[capacity];
	}
	
	public void push(String s){
		this.s[N++] = s;
	}
	
	public String pop() throws Exception{
		if(isEmpty()){
			throw new Exception("Empty stack");
		}
		return this.s[--N];
		
	}
	
	public boolean isEmpty(){
		return N==0;
	}
}
