
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;;



public class Stest{
   public static void main(String[] args)throws Exception{
	Scanner in = new Scanner(System.in);

		String value;
		Person p;
		boolean answer = false;
		InfoDVD d1 = new InfoDVD();
		
		System.out.println("Getting data from the file: ");
		d1.getData_from_file();
		
		System.out.println("Reading data from the file: ");
		d1.readFile();

		
		
		while(answer != true){
			
			System.out.println("Commands [S)top, A)dd new DVD, B)orrow, N)ew person, O)verveiw, R)eturn, D)isplay]: ");
			String linje = in.nextLine();
			
			switch(linje){
			    case "S":  
			    	    // This option will close the programme:
			    	    System.out.println("Good Buy: ");
			    	    answer = true;
				     break;
				     
			    case "A": 
			    	    // There a person will enter the name of DVD which he or she wants to be the part of the DVD-System: ";
				     System.out.println("For add DVD Mention your name please: ");
				     String nameOfPerson = in.nextLine();
				
				     	//If person is found in the System than the system will allow him or her to add his or her DVDs
					if(d1.findPerson(nameOfPerson)!= null){
						p = d1.findPerson(nameOfPerson);
						System.out.println("Write name of DVD you bought: ");
							String nameOfDVD = in.nextLine();
							if(d1.findDVD(nameOfDVD) == null){
								d1.setDVD(p, nameOfDVD);
							}
							else
								System.out.println("DVD is already available in the system:");
					}
					else{	
						System.out.println("The name you have mentioned is not available: ");
					}
				     break;
				   
			     case "B":  
			    	//Here a person can enter the name of the DVD which he or she wants to Borrow
			    	System.out.println("For borrow a DVD please mention your name: ");
				String rentDVDPerson = in.nextLine();
					    
					if(d1.findPerson(rentDVDPerson) != null){
						Person per = d1.findPerson(rentDVDPerson);
							
							//Whos DVD you want to borrow please mention his or her name:
							System.out.println("Whos DVD would you like to borrow, please mention his or her name: ");
							String name_of_DVD_owner = in.nextLine();
							if(d1.findPerson(name_of_DVD_owner) != null){
								
								Person personFound = d1.findPerson(name_of_DVD_owner);  
								
								System.out.println("Which DVD you want to borrow, Write name of that DVD: ");
								String rentDVD = in.nextLine();
							
								if(d1.findDVD(rentDVD) != null){
								DVD dvd = d1.findDVD(rentDVD);
									
									//now check that person wants to borrow his or her own DVD
									if(per.toString().equals(dvd.getOwner().toString())){
										System.out.println("You are owner of this DVD so you could not borrow it: ");
									}
									else{
										//Here we will check that is that DVD already borrowed
										 if(dvd.getBorrower() != null)
										 	 System.out.println("DVD is allredy borrowed: ");
										 else if(!personFound.toString().equals(dvd.getOwner().toString()))
										 	 System.out.println("The DVD owner name you have mentioned is not correct: ");
										 else
										 	 d1.rentDVD(per , dvd);
									}
									
								}
								else
								System.out.println("DVD which you want to borrow is not available in the system : ");
							}else
							System.out.println("This person is not found in the system: ");
						}
						else
							System.out.println("This person is not found in the system: ");
					     break;
					     
			   case "N":  
			   	   // There you can add a  new person into the system.
				    System.out.println("What is the name of new person: ");
				    String namePerson = in.nextLine();
					d1.addPerson(namePerson);
					//d1.addToFile(namePerson);
				     break;
				     
			    case "O":  
			    	   //Here a person can check the overview that how many persons are in the system and how many DVDs a person have
			    	   //following loop is taking all the persons object 
			    	   for(int i = 0; i < d1.persons.size(); i++){
			    	   	   
			    	   	   Person personInfo = d1.persons.get(i);	   
			    	    	    //following line shows us that how many DVDs this specific person owns and rented out and borrowed from others
			    	    	    System.out.println(personInfo + " is owner of " + personInfo.owner_Of_DVDs.size() + " DVDs gave " + d1.rent_a_DVD(personInfo) + " DVDs to others as rent and borrowed " + personInfo.borrowed_DVDs.size() + " DVDs ");
			   	    	    
			    	    	    System.out.println();
			    	     }
					
				     break;
				     
			    case "R":  
			    		//Here a person can return the DVD which he or she Borrowed
					    System.out.println("For return the DVD please mention your name: ");
					    String personReturnDVD = in.nextLine();
					    
						if(d1.findPerson(personReturnDVD) != null){
							
							Person perR = d1.findPerson(personReturnDVD);
							    
							System.out.println("Which DVD you want to return, Write name of that DVD: ");
							String returnDVD = in.nextLine();
							
								if(d1.findDVD(returnDVD) != null){
								DVD dvdR = d1.findDVD(returnDVD);
									
									//now check the person that he really borrowed this DVD
									for(int i = 0; i < perR.borrowed_DVDs.size(); i++){
										if(!dvdR.toString().equals(perR.borrowed_DVDs.get(i).toString())){
											System.out.println("You did not borrowed this DVD: ");
										}
										else{							
											d1.returnDVD(perR , dvdR);
										}
									}
									
								}
								else
								System.out.println("DVD which you want to reurn is not available in the system: ");
						}
						else
							System.out.println("This person is not found in the system: ");
					     break;
					     
			    case "D":  
			    	    //this part is displaying all the information about a person that how many DVDs he or she ownes and how many he or she gave to others and how many DVDs he or she slef borrowed
				     
				  System.out.println("Please mention the name of Person whos information would you like to be display or for see information of all person write *: ");
				  String input = in.nextLine();

				   
				  if( input.equals("*")){
				    for(int i = 0; i < d1.persons.size(); i++){
					    
					    //here we got a specific person
								    
					      System.out.println(d1.persons.get(i) + " is owner of the following DVDs: ");
					      //following line shows us that how many DVDs this specific person owns
					      System.out.println(d1.persons.get(i).owner_Of_DVDs);	
					      
					      System.out.println(d1.persons.get(i) + " borrowed the following DVDs: ");
					      //following line shows us that how many DVDs this specific person borrowed
					      System.out.println(d1.persons.get(i).borrowed_DVDs);
					      System.out.println();
				      }
				    }else{  
					   for(int i = 0; i < d1.persons.size(); i++){
						
					      if(d1.persons.get(i).toString().equals(input)){
						//here we got a specific person
									
						    System.out.println(d1.persons.get(i) + " is owner of the following DVDs: ");
						    //following line shows us that how many DVDs this specific person owns
						    System.out.println(d1.persons.get(i).owner_Of_DVDs);	
						    
						    System.out.println(d1.persons.get(i) + " borrowed the following DVDs: ");
						    //following line shows us that how many DVDs this specific person borrowed
						    System.out.println(d1.persons.get(i).borrowed_DVDs);
						    System.out.println();
						  }
					    }
				      }

			    	    
			    	    break;
			    default: 
			    	    System.out.println("Invalid input");
				     break;
			
			}
			
    	    }
    
		System.out.println("All the trasactions which are saved into the file: ");
		d1.addToFile(d1.persons);
		d1.readFile();

    
    }
 

}
