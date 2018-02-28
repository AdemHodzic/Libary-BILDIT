import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Database {
	//Data fields
	private ArrayList<Account> accountDatabase = new ArrayList<>();
	private ArrayList<Book> bookDatabase = new ArrayList<>();
	private Path userPath = Paths.get("files/users.txt");
	private Path bookPath = Paths.get("files/books.txt");
	
	//Constructors
	Database(){}

	//Methods
	
	public void readUser() throws Exception{
		accountDatabase.clear();
		BufferedReader reader = Files.newBufferedReader(userPath);
		String temp;
		while((temp=reader.readLine())!=null) {
			String arr[] = temp.split(" ");
			Account account = new Account(Integer.parseInt(arr[0]), arr[1], Integer.parseInt(arr[2]));
			accountDatabase.add(account);
		}
		reader.close();
	}
	
	public void readBook() throws Exception{
		bookDatabase.clear();
		BufferedReader reader = Files.newBufferedReader(bookPath);
		String temp;
		while((temp=reader.readLine())!=null) {
			String arr[] = temp.split(" ");
			Book book = new Book(Integer.parseInt(arr[0]), arr[1], Boolean.parseBoolean(arr[2]));
			bookDatabase.add(book);
		}
		reader.close();
	}
	
	private void writeUser() throws Exception{
		BufferedWriter writer = Files.newBufferedWriter(userPath);
		for(Account account : accountDatabase) {
			writer.write(account.toString());
			writer.newLine();
		}
		writer.close();
	}
	
	private void writeBook() throws Exception{
		BufferedWriter writer = Files.newBufferedWriter(bookPath);
		for(Book book : bookDatabase) {
			writer.write(book.toString());
			writer.newLine();
		}
		writer.close();
	}
	
	public void createAccount(int accNum, String accName) throws Exception{
		readUser();
		if(validateUser(accNum)) {
			Account account = new Account(accNum, accName);
			accountDatabase.add(account);
			System.out.println("User added successfully");
			writeUser();
		}else {
			System.out.println("Couldn't add user!\n"
					+ "Sorry for inconvenience.");
		}
	}
	
	public void createBook(int bookNum, String bookName) throws Exception{
		readBook();
		if(validateBook(bookNum)) {
			Book book = new Book(bookNum, bookName);
			bookDatabase.add(book);
			System.out.println("Book added successfully");
			writeBook();
		}else {
			System.out.println("Couldn't add book!\n"
					+ "Sorry for inconvenience.");
		}
	}
	
	public void takeBook(int accNum, int bookNum) throws Exception{
		readBook();
		readUser();
		if(containUser(accNum) && containBook(bookNum)) {
			accountDatabase
			.get(getUserIndex(accNum))
			.takeBook(bookDatabase
					.get(getBookIndex(bookNum)));
		}else if(!containUser(accNum)) {
			System.out.println("That account doesn't exist!");
			return;
		}else if(!containBook(bookNum)) {
			System.out.println("That book doesn't exist!");
			return;
		}
		writeUser();
		writeBook();
	}
	
	public void returnBook(int accNum, int bookNum) throws Exception{
		if(containUser(accNum) && containBook(bookNum)) {
			accountDatabase.get(getUserIndex(accNum))
			.returnBook(bookDatabase.get(getBookIndex(bookNum)));
		}else if(!containUser(accNum)) {
			System.out.println("That account doesn't exist!");
			return;
		}else if(!containBook(bookNum)) {
			System.out.println("That book doesn't exist!");
			return;
		}
		writeUser();
		writeBook();
	
	}
	
	public String details(int accNum) throws Exception{
		readUser();
		for(Account acc: accountDatabase) {
			if(acc.getAccountNumber()==accNum) return acc.toString();
		}
		return null;
	}
	
	private boolean validateUser(int number) {
		if(number<0) return false;
		for(Account acc:accountDatabase) {
			if(acc.getAccountNumber()==number) return false;
		}
		return true;
	}
	
	private boolean validateBook(int number) {
		if(number<0) return false;
		for(Book book:bookDatabase) {
			if(book.getBookNum()==number) return false;
		}
		return true;
	}
	
	private boolean containBook(int number) {
		for(Book book:bookDatabase) {
			if(book.getBookNum()==number) return true;
		}
		return false;
	}
	
	private boolean containUser(int number) {
		for(Account acc:accountDatabase) {
			if(acc.getAccountNumber()==number) return true;
		}
		return false;
	}
	
	private int getUserIndex(int number) {
		for(int i = 0;i<accountDatabase.size();i++) {
			if(accountDatabase.get(i).getAccountNumber()==number) return i;
		}
		return -1;
	}
	
	private int getBookIndex(int number) {
		for(int i = 0;i<bookDatabase.size();i++) {
			if(bookDatabase.get(i).getBookNum()==number) return i;
		}
		return -1;
	}
	//Getters
	public ArrayList<Account> getAccountDatabase() {
		return accountDatabase;
	}
	public ArrayList<Book> getBookDatabase() {
		return bookDatabase;
	}
	
	
}
