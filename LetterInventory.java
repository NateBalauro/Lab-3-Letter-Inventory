//Programmer: Nate Balauro
//Class: CS&145
//Assinment: Lab 3 - letter Inventory
//Purpose: To create a letter inventory that keeps track of each
//         letter in a word.


import java.util.*;

public class LetterInventory {
	
   private static char[] letters; //org stores the letters in alphabetial order
	private static char[] alphabet = new char[] {'a','b','c','d','e','f','g','h',
            'i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
   //counter array keeps count of each letter in the alphabet
   private int[] counter = new int[26];
   
   public LetterInventory(String inventory) {
		
      letters = new char[inventory.length()];
	   for(int i = 0; i < inventory.length(); i++) {
			if(Character.isLetter(inventory.charAt(i))) {
				letters[i] = Character.toLowerCase(inventory.charAt(i));;
			}
		}
		Arrays.sort(letters);
		for(int i = 0; i < 26; i++) {
			for(Character j : letters) {
				if(j == alphabet[i]) {
					counter[i]++;
				}
			}
		}
		
	} // end of letter inventory method
	
	//The method below returns the count of the given letter, throws exception if given char isnt a letter
	public int get(char letter) {
		if(Character.isLetter(letter) == false) {
			throw new IllegalArgumentException();
		}
		
		Character.toLowerCase(letter);
		for(int j = 0; j < 26; j++) {
			if(alphabet[j] == letter) {
				return counter[j];
			}
		}
		return 0;
	}// end of get method

	//Changes the count of a letter in the counter array
	public void set(Character old, int value) {
		if((Character.isLetter(old) == false) || (value < 0)) {
			throw new IllegalArgumentException();
		}
		
		Character.toLowerCase(old);
		
		for(int j = 0; j < 26; j++) {
			if(alphabet[j] == old) {
				counter[j] = value;
			}
		}	
	}// end of set method
	
	//returns length of array which is equal to the words length
	public int size() {
		return letters.length;
	}
	
	//The method below checks if the LetterInventory is empty
	public static boolean isEmpty(LetterInventory A) {
		if(letters.length == 0) {
			return true;
		}
		return false;
	}

	//This method converts the LetterInventory into a string
	public String toString() {
		String bracket = "[";
		for(Character l : letters) {
			bracket += l;
		}
		return bracket + ']';
	}
	
	//This method subtracts the LetterInventory from another LetterInventory 
   //for a change in the word
	public LetterInventory subtract(LetterInventory old) {
		String holder = "";
		for(int i = 0; i < old.counter.length; i++) {
			int y = counter[i] - old.counter[i];
			if(y < 0) {
				return null;
			}
			else {
				for(int k = 0; k < y; k++) {
					holder += alphabet[i];
				}
			}
		}
		LetterInventory newInventory = new LetterInventory(holder);
		return newInventory;
	} // end of subtract method
	
	//This method adds the current LetterInventory to another LetterInventory
   // for a change in the word
	public LetterInventory add(LetterInventory old) {
		String holder = "";
		for(int i = 0; i < old.counter.length; i++) {
			int y = counter[i] + old.counter[i];
			for(int k = 0; k < y; k++) {
				holder += alphabet[i];
			}
		}
		LetterInventory newInventory = new LetterInventory(holder);
		return newInventory;
	} // end of add method
	
} // end of LetterInventory class