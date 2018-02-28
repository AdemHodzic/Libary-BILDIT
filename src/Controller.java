import java.util.Scanner;

public class Controller {
	private Database database = new Database();
	
	Controller(){}
	
	public void init() throws Exception{
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("Welcome to my App.\nMake your choice please: ");
			System.out.println("1.Create an account"
					+ "\n2.Create a book"
					+ "\n3.Take a book"
					+ "\n4.Return a book"
					+ "\n5.Get info"
					+ "\n6.Exit");
			int choice = input.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter user number: ");
				int accNumber = input.nextInt();
				input.nextLine();
				System.out.println("Enter user name: ");
				String accName = input.nextLine();
				database.createAccount(accNumber, accName);
				break;
			case 2:
				System.out.println("Enter book number: ");
				int bookNumber = input.nextInt();
				input.nextLine();
				System.out.println("Enter book name: ");
				String bookName = input.nextLine();
				database.createBook(bookNumber, bookName);
				break;
			case 3:
				System.out.println("Enter user number: ");
				int takeAccNumber = input.nextInt();
				System.out.println("Enter book number: ");
				int takeBookNumber = input.nextInt();
				database.takeBook(takeAccNumber, takeBookNumber);
				break;
			case 4:
				System.out.println("Enter user number: ");
				int returnAccNumber = input.nextInt();
				System.out.println("Enter book number: ");
				int returnBookNumber = input.nextInt();
				database.returnBook(returnAccNumber, returnBookNumber);
				break;
			case 5:
				System.out.println("Enter user number: ");
				int infoNumber = input.nextInt();
				System.out.println("Details:\n" + database.details(infoNumber));
				break;
			case 6:
				System.out.println("Thank you for using our app!");
				input.close();
				System.exit(0);
			default:
				System.out.println("Unknown input!\nExiting app.");
				input.close();
				System.exit(0);
			}
		}
	}
}
