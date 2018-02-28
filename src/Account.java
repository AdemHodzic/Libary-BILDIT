
public class Account {
	//Data fields
	private int accountNumber;
	private String accountName;
	private int bookNum;
	
	//Constructors
	Account(int accountNumber, String accountName){
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.bookNum = 0;
	}
	
	Account(int accountNumber, String accountName, int bookNum){
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.bookNum = bookNum;
	}

	//Methods
	public void takeBook(Book book) {
		if(validate(book)) {
			this.setBookNum(this.getBookNum()+1);
			book.setTaken(true);
			System.out.println("Book taken succefully!");
		}else {
			System.out.println("We cannot perform that action!\n"
					+ "Sorry for inconvience.");
		}
	}
	
	public void returnBook(Book book) {
		if(book.isTaken()==true && this.getBookNum()>0) {
			book.setTaken(false);
			this.setBookNum(this.getBookNum()-1);
			System.out.println("Book returned succefully!");
		}else {
			System.out.println("We cannot perform that action!\n"
					+ "Sorry for inconvience.");
		}
	}
	
	private boolean validate(Book book) {
		if(this.getBookNum()>2) return false;
		else if(book.isTaken()==true) return false;
		else return true;
	}
	
	@Override
	public String toString() {
		return this.accountNumber + " " 
				+ this.accountName + " "
				+ this.bookNum;
	}
	
	//Getters and setters
	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}
	
	
}
