
/**
 * Write a description of class Registry here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Arrays;
public class Registry {
//PREPARE
	// Declare all necessary variables including array
	private String[] list;
	private int index;
//INPUT	
	public Registry() { // blank class declaration
		list = null;
		index = 0;
	}
	
	public Registry(int n) { // informative class declaration 
		list = new String[n]; // creates a specific number index to store strings 
		index = 0;
	}
//PROCESS	
	public boolean registryFull() { // computes if the registry is full 
		for (int i = 0; i< list.length; i++) { // for the length of list 
			if (list[i] == null) { // if an index contains null
				index = i; // save for use in addToRegisty 
				return false;
			} 
		}// else return true
		return true;
	}
	
	public void addToRegistry(String n) { // stores new information 
		if(this.registryFull() == false) { // Additional promotions incase of computation error - same idea used in main and set index to correct integer
			list[index] = (n); // saves the string account into the array
		} else if (this.registryFull() == true) {
			System.out.println("The Registry is Full");
		}
	}
	
	public void removeFromRegistry(int n) { // removes the string information from the array at n
		list[n] = null;
	}
	
	public int getNumber (String p) { // returns the number that the information is stored at 
		for (int i = 0; i< list.length; i++) { // for the length of the list array
			if (p == list[i]) {
				index = i+1; // +1 because it appears in a list when printed ex: 1) 2) 3) not 0) 1) 2)
			}
		}
		return index; 
	}
	
	public String retriveRegistryInfo(int n) { // returns the string stored at index n
		return list[n];
	}
//OUTPUT	
	public String toString() { // converts all stored information (not null) to a printable list 
		String ret;
		ret = "In Registry: \r\n";
		for (int i = 0; i< list.length; i++) { // for the length of the list array
			if (list[i]!=null) { // if the stored information is not null
				ret = ret+ getNumber(list[i])+") "+list[i]+" \r\n"; // invoke getNumber for to print '1)' or '2)' etc. followed by the stored string and new line
			}
		}
		ret = ret + "\r\n \r\n"; // create space after the registry prints 
		return ret;
	}
}
