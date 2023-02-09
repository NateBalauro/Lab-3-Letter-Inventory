//Programmer: Nate Balauro
//Class: CS&145
//Assinment: Lab 3 - letter Inventory
//Purpose: To create a letter inventory that keeps track of each
//         letter in a word.
//         This specific program allows the user to test the letter inventory system.

import java.util.*;

public class testClass {

	static Scanner scanner = new Scanner(System.in);
	static char a;
	static int amount;
	
	public static void main(String[] args) {
	   testMethod();
   } // end of main
   
   public static void testMethod() {
      System.out.println("Welcome to the Letter Inventory!");
      System.out.println("Please type a word:");
		   String input = scanner.next();
		
		   LetterInventory r = new LetterInventory(input);
		
		   if(LetterInventory.isEmpty(r)) {
			   System.out.println("Please type in a word of at least one character ");
			   input = scanner.next();
			   r = new LetterInventory(input);
		   }
		
		   int I = r.size();
		   System.out.println("Your word has " + I + 
                        " letters, and here they are listed alphabetically " + r.toString());
         System.out.println(". Would you like to add or subtract letters (yes/no)?");
		
         String answer = scanner.next();
		
		   if(answer.equals("yes")) {
			   System.out.println("Which letter would you like to subtract or add? ");
			   a = scanner.next().charAt(0);
			   System.out.println("Would you like to add or subtract? ");
			   String answer2 = scanner.next();
			   answer2.toLowerCase();
			   
			   System.out.println("How many would like to add or subtract?");
			   amount = scanner.nextInt();
			   
			   String newLetterInventoryContent = "";
			
			   for(int i = 0; i < amount; i++) {
				   newLetterInventoryContent += a;
			   }
			   LetterInventory changes = new LetterInventory(newLetterInventoryContent);
			
			
			   if(answer2.equals("add")) {
				   r = r.add(changes);
			   }
			   else {
				   r = r.subtract(changes);
			   }
			
			   System.out.println("Your Letter Inventory is now " + r.toString() + " and contains " + r.size() + " letters");
		   }
			   System.out.println("Thank you for using the Letter Inventory Program!");
   } // end of testMethod
	
} // end of testClass class