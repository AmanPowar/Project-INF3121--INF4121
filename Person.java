import java.util.ArrayList;

public class Person{

    private String name;
    ArrayList<DVD> owner_Of_DVDs = new ArrayList<DVD>();
    ArrayList<DVD> borrowed_DVDs = new ArrayList<DVD>();
    
    public Person(String s){
    	name = s;
    }

    // to cehck the name of person
    public String toString(){
    	return name;
    }
    /*
     * to add a new DVD into the system
     * updating the array owner_Of_DVDs
     */
    public void getDVD(DVD myDVD){
	owner_Of_DVDs.add(myDVD);
  }
 
    /*
     * updating the array borrowed_DVDs
     */
    public void borrowedDVD(DVD bDVD){
    	borrowed_DVDs.add(bDVD);	    
   }
   
    /*
     * 
     */
    public void returnedDVD(DVD rDVD){
    	for(int i = 0; i < borrowed_DVDs.size(); i++){
    		if(borrowed_DVDs.get(i).toString().equals(rDVD.toString()))
    		borrowed_DVDs.remove(i);	    
    	}
    }
   
}