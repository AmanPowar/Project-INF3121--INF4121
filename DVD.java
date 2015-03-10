public class DVD{

    private String titleDVD; //Title of DVD
    private Person owner; //Name of the person who are owner of this DVD
    private Person borrower; // Name of the person who rented this DVD

    //constructor
    public DVD(String s){
	titleDVD = s;
    }
    
    //change the type of object into String
    public String toString(){
	return titleDVD;
    } 
    
    //another costructor where object person and string are parameters
    public DVD(Person ownerName, String dvd){
	owner = ownerName;
    	titleDVD = dvd;
    }
    
    //set the name of person who borrowed this DVD object
    public void borrower_Of_DVD(Person borrowerName){
    	    borrower = borrowerName; 
    }

    	//set the name of the person who is owner of this specific object
    public Person getOwner(){
       	return owner;
    }
    
    public Person getBorrower(){
       	return borrower;
    }
    
    public void borrower_Returned_DVD(){
    	    borrower = null; 
    }

} 