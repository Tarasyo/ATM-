import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class Assignment {
	
	//TTTTTT GLOBAL  TTTTTTTT

	String [] user = new String[3];
	
	public Assignment () {
		
		welcome();
		login();

	}
	public void welcome() {
	
		System.out.println("Welcome to TB Bank ATM");
		
	}
	/*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
	                   MENU
	 TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/
	
	public void menu() {
		printit("1.Acc Balance");
		
		printit("2.Withdraw Money");
		
		printit("3.Change their current password");
		
		printit("4.Check the latest stock prices for the bank");
		
		printit("5.Logout of the system.");
		
		printit("6.Admin Options.");
	
	}
	/*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
	            VISUAL EFECT 
	 TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/
	
	public void printit(String str) {
		System.out.println("**************************************");
		System.out.println(str);
		
	}
	  
	/*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
	                 LOGIN
	 TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/
	
	public void login() {
		
	/*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
	                      GETING ID
	TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/
		String input = "";
		
			
			boolean valid = false;
			
		
		      System.out.println("Please enter a ID: ");
			  input = bufferR();
			do {
				if(input.matches("[0-9]+")) {
				  	  valid = true;
				} else {
				 	valid = false;}
				}while(valid == false);
			
		
		
		
	/*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
	                       GETING PASSWORD 
	 TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/	

		String input1 = "";
	
			
			boolean valid1 = false;
			
			
		      System.out.println("Please enter a Password: ");
			  input1 = bufferR();
			  do {
				if(input1.matches("[0-9]+")) {
				  	  valid1 = true;
				} else {
				 	valid1 = false;}
				}while(valid1 == false); 
			
		
		
		
		/*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
		                         READING IN
		 TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/
	

		
		try {
		
			BufferedReader br = new BufferedReader(new FileReader("user\\"+ input +".txt"));	
			
			
			user[0] = br.readLine();
			user[1] = br.readLine();
			user[2] = br.readLine();
		
		
	
		if(user[0].equals(input) && user[1].equals(input1)) {
			
		//TTTTTTT WORKS
			
		menu();
		selectMenu();
		} else {
			
		//TTTTTTT DOSNT WORK
			
		System.out.println("Wrong ID or Password, try again");
		login();
		}
		
		
		}catch(Exception e) {System.out.print(e);
			System.out.println(" ");
		login();}
		
		
		}
	

   /*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
                       SELECT MENU		
    TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/
	
	
	public void selectMenu() throws Exception {
		
		String input = "";
			
			boolean valid = false;
			
			  printit("Select option");;
			  input = bufferR();
			do {
				if(input.matches("[1-6]+")) {
				  	  valid = true;
				} else {
				 	valid = false;
				 printit("Please chuse menu option");}
		}while(valid == false);
		
		if(input.equals("1")) {
			checkAccountBalance();
		}
		else if(input.equals("2")) {
			withdrawMoney();
		}
		else if(input.equals("3")) {
			changePassword();
		}
		else if(input.equals("4")) {
			checkStock(null);
		}
		else if(input.equals("5")) {
			logOut();
		}
		else if(input.equals("6")) {
			checkAdmin();
		}
		
	}
	/*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
	                  AFTER OPTION METHOD
	 TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/
	
	public void afterOption() {
	
		
		BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
           try {
			
			boolean valid4 = false;
			
			do {
		      printit("Press 1 for go back to menu or press 2 for logOut ");
			  String input4 = br4.readLine();
			
				if(input4.matches("1")) {
				  	  valid4 = true;
				  	  menu();
				  	  selectMenu();
				} 
				if(input4.matches("2")) {
					valid4 = true;
					System.exit(0);
				}
				else {
				 	valid4 = false;
				 	System.out.println("Please try again");
				}
			
			
			}while(valid4 == false);
			
		}catch(Exception e) { System.out.println("Error reading input");}
		
	}
	/*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
	            CHECK ACCOUNT BALANCE 
	 TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/
    public void checkAccountBalance() {
    	
    	System.out.println("Your Balance is: "+ user[2]);
         afterOption();
	
    }
    
    /*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
                        WITHRAW MONEY 
     TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/
    
    public void withdrawMoney(){
    
    	BufferedReader br5 = new BufferedReader(new InputStreamReader(System.in));
        try {
			
			boolean valid5 = false;
			
			do {
		      printit("Enter amount money that you want to withdraw");
			  String input5 = br5.readLine();
			    
				if((Double.valueOf(input5) <= Double.valueOf(user[2]))) {
					valid5 = true;
					double newMoney = Double.valueOf(user[2])-Double.valueOf(input5);
					user[2] = Double.toString(newMoney);
					printit("Your balance now is: "+user[2]);
				
					//TTTTTTTTTTTTTTTTTTT WRITING TO THE FILE TTTTTTTTTTTTTTTTTTT
					try
			        {
				    BufferedWriter bw = new BufferedWriter( new FileWriter("user\\"+user[0]+".txt"));	
				    
				    for (int i = 0; i < user.length;i++) {
			        bw.write(user[i]);
			        bw.newLine();}
			        bw.close();
			        }
			        catch ( IOException e) {}
				} 
				else {
				 	valid5 = false;
				 	System.out.println("You dont have so much");
				}
			
			
			}while(valid5 == false);
			
		}catch(Exception e) { System.out.println("Error reading input");
		withdrawMoney();}
        afterOption();
        
    	/*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
    	               CHANGING PASSWORD
    	 TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/
    }
    public void changePassword() {
    	//TTTTTTTTTTTTTTTT  READ AND CHECK IF ENTER 2 SAME PASSWORDS 
        try {
        	BufferedReader br6 = new BufferedReader(new InputStreamReader(System.in));
			boolean valid6 = false;
			boolean valid61 = false;
			
			do {
		      printit("Enter your new password");
			  String input6 = br6.readLine();
			  
			  if((input6.matches("[0-9]+")) && (input6.length() == 4)) {
			  	  valid61 = true;
			} else {
			 	valid61 = false;
			 	System.out.println("Please enter just 4 digits");
			 	changePassword();
			} 
		
		
		while(valid61 == false); 
			  
			BufferedReader br61 = new BufferedReader(new InputStreamReader(System.in));
			  printit("Enter it again");
			  String input61 = br61.readLine();
			  
				if(input6.equals(input61)) {
					valid6 = true;
					user[1] = input6;
					
					// TTTTTTTTTTTTTTTTT WRITE TO THE FILE TTTTTTTTTTTTTTTTTT
					
					try
			        {
				    BufferedWriter bw2 = new BufferedWriter( new FileWriter("user\\"+user[0]+".txt"));	
				    
				    for (int i = 0; i < user.length;i++) {
			        bw2.write(user[i]);
			        bw2.newLine();}
			        bw2.close();
			        }
			        catch ( IOException e) {}
				} 
				else {
				 	valid6 = false;
				 	System.out.println("passwords not the same");
				}
			
			
			}while(valid6 == false);
			
		}catch(Exception e) { System.out.println("Error reading input");}
        afterOption();
    	
    }
    /*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
                     STOKS METHOD
     TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/
public void checkStock(String[] args) throws Exception {
    	        FileReader fr = new FileReader("stocks\\stocks.txt");
    	        int i;
    	        while ((i=fr.read()) != -1){
    	            System.out.print((char) i + " ");
    	           
    	        }
    	        System.out.println();
    	        afterOption();
    	    }

/*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
                  LIST OF USERS 
 TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/

public File[] userList() {
	 
	File dirList = new File("user\\");
	File[] userList = dirList.listFiles();
	return userList;
}
/*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
                      MAIN ARRAY
TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/
public String[] mainArray(){
	
	String[] list = new String[3];
	
	try {
		BufferedReader br10 = new BufferedReader(new FileReader("user\\"+user[0]+".txt"));
		int content = 0;
		String line = br10.readLine();
		while(line != null) {
		   
		   list[content] = line;
		   content++;
		   line = br10.readLine();
		}
	}catch(Exception e){}
	return list;
	
}
/*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
                CHECK ADMIN PASSWORD
 TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/

public void checkAdmin() {
	boolean valid10;
	try {

	 System.out.println("THIS IS ADMIN OPTION PLEASE ENTER PASSWORD:");
	 BufferedReader adminPassword = new BufferedReader(new InputStreamReader(System.in));
		String passwordIsHere = "";
		passwordIsHere = adminPassword.readLine(); 
		if (passwordIsHere.equals("admin")) {
			valid10 = true;
			adminOptins();
		}else {
			valid10 = false;
			System.out.println("WRONG PASSWORD");
			afterOption();
		}
		}catch(Exception e) {}
}
/*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
                  ADMIN OPTIONS
 TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/

public void adminOptins() throws Exception {
	
	printit("1.Bank Sumary Balance");
	
	printit("2.Categorys");
	
	printit("3.Create new account");
	
	printit("4.Back to main manu");
		
		BufferedReader br11 = new BufferedReader(new InputStreamReader(System.in));
		String input11 = "";
		try {
			
			boolean valid11 = false;
			
			do {
			 
			  printit("Select option");;
			  input11 = br11.readLine();
			
				if(input11.matches("[1-4]+")) {
				  	  valid11 = true;
				} else {
				 	valid11 = false;
				 printit("Please chuse menu option");
				}
			
			
			}while(valid11 == false);
		}	
		catch(Exception e) { System.out.println("Error reading input");}
		
		if(input11.equals("1")) {
			summary();
		}
		else if(input11.equals("2")) {
			categorys();
		}
		else if(input11.equals("3")) {
			newAccount();
		}
		else if(input11.equals("4")) {
			menu();
			selectMenu();
		}
	
	
}

/*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
              SUMMARY 
 TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/

 public void summary() {
	 String value;
	 String balance;
	 double total_balance = 0;
	 try {
		 File[] listOfFiles = userList();
		 for (File file : listOfFiles) {
			 value = file.getName().split(".txt")[0];
			 user[0] = value;
		   balance = mainArray()[2];
		   total_balance += Double.valueOf(balance);
			   
			System.out.println("User ID:" +value + "   Balance: " + balance);
			
				
			
		   }
		 
	 }catch(Exception e) {}
	 System.out.println("**************************************");
	 System.out.println("TOTAL IN THE BANK: "+total_balance);
	 afterOption();
 }
 /*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
            CATEGORYS METHOD
  TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/
 
 public void categorys() {
	 String value;
	 String balance;
	 int small = 0;
	 int medium = 0;
	 int large = 0;
	 int EXlarge = 0;
	 try {
		 File[] listOfFiles = userList();
		 for (File file : listOfFiles) {
			 value = file.getName().split(".txt")[0];
			 user[0] = value;
		   balance = mainArray()[2];
		   if(Double.valueOf(balance) <= 100) {
			small++;   
		   } else if(((Double.valueOf(balance))>=101) && ((Double.valueOf(balance))<=200)){
			 medium++;  
		   } else if(((Double.valueOf(balance))>=201) && ((Double.valueOf(balance))<=300)) {
			   large++;
		   } else if(Double.valueOf(balance) > 300) {
			   EXlarge++;
		   }
		   }
		 System.out.println("Users with Small amaout of money: "+small);
		 System.out.println("Users with Medium amaout of money: "+medium);
		 System.out.println("Users with Large amaout of money: "+large);
		 System.out.println("Users with Extra Large amaout of money: "+EXlarge);
	 
		 }catch(Exception e) {} 
	 afterOption();
 }
 /*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
                      CREATING NEW ACCOUNT
 TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT */
 
 public void newAccount() {
	 //TTTTTTTTTTTTTTTTTTTTT   ID INPUT       TTTTTTTTTTTTTTTTTTTTTTTT
	 System.out.println("Please Enter New ID:");
	 BufferedReader br12 = new BufferedReader(new InputStreamReader(System.in));
		String input12 = "";
		String value2;
		boolean valid13= false;
	 try {	
	 input12 = br12.readLine();
	 File[] listOfFiles2 = userList();
	 
	 for (File file2 : listOfFiles2) {
		 value2 = file2.getName().split(".txt")[0];
		 
	 if(input12.equals(value2)){
		    valid13 = false;
		    printit("Account with this ID alredy is in the system");
		    newAccount();
	 }
	 
	 }
	 //TTTTTTTTTTTTTTT PASSWORD INPUT      TTTTTTTTTTTTTTT
	
	
		boolean valid14 = false;
		boolean valid141 = false;
		String input14;
		String input141;
		 do {
			 BufferedReader br14 = new BufferedReader(new InputStreamReader(System.in));
	      printit("Enter your new password");
		  input14 = br14.readLine();
		 
		  if((input14.matches("[0-9]+")) && (input14.length() == 4)) {
		  	  valid141 = true;
		} else {
		 	valid141 = false;
		 	System.out.println("Please enter just 4 digits");}
		}while(valid141 == false); 
		  do {
		BufferedReader br141 = new BufferedReader(new InputStreamReader(System.in));
		  printit("Enter it again");
		  input141 = br141.readLine();
		  
			if(input14.equals(input141)) {
				valid14 = true;
			} else {
				valid14 = false;
				System.out.println("Password isnt the same");
			}	
			}while(valid14 == false);
			
		/*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
		             ENTER ACC BALANCE
		 TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/
			
		System.out.println("Enter how much is deposit");	
	BufferedReader br15 = new BufferedReader(new InputStreamReader(System.in));
	String input15 = br15.readLine();
	 boolean valid15 = false;
	  if(input15.matches("[0-9]+")) {
	  	  valid15 = true;
	} else {
	 	valid15 = false;
	 	System.out.println("Please enter numbers");
	} while(valid15 == false); 
	
	/*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
	                 CREATING NEW FILE
	 TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/
				
	 List<String> lines = Arrays.asList(input12,input14,input15);
	 Path file = Paths.get("user\\"+input12+".txt");
		Files.write(file, lines, Charset.forName("UTF-8"));
	 } catch (IOException e) {
		e.printStackTrace();
	}
	 afterOption();
 }

    public void logOut() {
    	System.exit(0);
    
    
    }
    /*TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
                       BUFFERREADER
     TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT*/
    
    public String  bufferR() {
    	String input = "";
    		try {

    	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    		
    	        input = br.readLine();
    		
    		}catch(Exception e) { System.out.println("Error reading input");}
    		return input;
    }

	
	public static void main(String[]args) {
		
		new Assignment();
	}
}
