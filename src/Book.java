
public class Book {
	//Data fields
	private int bookNum;
	private String bookName;
	private boolean taken;
	
	
	//Constructors
	Book(int bookNum, String bookName){
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.taken = false;
	}
	
	Book(int bookNum, String bookName, boolean taken){
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.taken = taken;
	}

	//Methods
	
	@Override
	public String toString() {
		return this.bookNum + " " 
				+this.bookName + " "
				+ this.taken;
	}
	
	//Getters and setters
	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	public int getBookNum() {
		return bookNum;
	}

	public String getBookName() {
		return bookName;
	}
	
	
}
