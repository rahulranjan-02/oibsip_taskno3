import java.util.*;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.*;
public class ATM
{
    public static void Transaction_reciept(int money,int choice)
    {
        //we will append on the file that is created
        try(FileWriter fw = new FileWriter("filename.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
    {
        //details written on the file as per the choices selected by the user
        if(choice==2)out.println("Withdraw : "+money);
        if(choice==3)out.println("Deposit : "+money);
        if(choice==4)out.println("Transfer : "+money);
        
        
    } catch (IOException e) {
        System.err.println("IOException: " + e.getMessage());
    }
 }  
 public static void Transaction_recieptprint()
    {
        try
        {
           FileReader fr=new FileReader("filename.txt");//file which we want to read
           int i;    
          while((i=fr.read())!=-1)    
          System.out.print((char)i);    
          
          fr.close();   
 }  
 catch(FileNotFoundException e)
 {
  e.printStackTrace();
 }
 catch(IOException e)
 {
    e.printStackTrace();
 }
}

public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
int balance=100000,choice=0,withdraw,deposit,transfer;//preassuming balance
System.out.println("We are assuming userid=01978345 pin=8932");//preassuming user_id and pin of our account
String userid="01978345",pin="8932";
try{
   
    FileWriter fw=new FileWriter("filename.txt");//creating the file of Transaction history
    fw.write("Transaction History \n");
    fw.close();//closing the file writer object
}
catch(Exception e)
{
    e.printStackTrace();//if file is not found it gives us a error
}
System.out.println(".......Welcome to ABC Bank.......");
String userid1,pin1;
System.out.println("Enter your user_id : ");
userid1=sc.next();
System.out.println("Enter your pin : ");
pin1=sc.next();
//we have preassumed user_id and pin we will see what we enter matches with user or not
if(userid.equals(userid1)&&pin.equals(pin1))
{
//if the user_id and pin matches then we proceed to our program
while(choice!=5)
{
    System.out.println("Enter your choice: \n 1.Transaction_history \n 2.withdraw \n 3.Deposit \n 4.Transfer \n 5. Exit");

    choice=sc.nextInt();//choices to our operation
switch(choice)
{
   case 1:
   Transaction_recieptprint();
   break;
    case 2:
    System.out.println("Enter the amount to be withdrwan");
    withdraw=sc.nextInt();//withdrawn amount taken
    if(withdraw>balance)//if the amount to be withdrawn is greater than balance than we exit with a insufficient balance message
    {
    System.out.println("Insufficient Balance");
    System.exit(0);
    }
    balance=balance-withdraw;//Deducting from withdraw
    Transaction_reciept(withdraw,2);
    break;
    case 3:
    System.out.println("Enter the amount to be depositted");
    deposit=sc.nextInt();//taking deposited amount from user
    balance=balance+deposit;//adding the depositted amount;
    Transaction_reciept(deposit,3);
    break;
    case 4:
    System.out.println("Enter the amount to be deposited");
    transfer=sc.nextInt();//giving the value of Transferred amount
    System.out.println("Enter the accountno which you want to deposit in: ");
    userid=sc.next();//user_id of the next account to be deposited
    System.out.println("Enter your user_id: ");
    userid1=sc.next();//enter the account of depositer
    System.out.println("Enter your pin: ");
    pin=sc.next();//enter the pin of the depositer
    Transaction_reciept(transfer,4);
    balance=balance-transfer;//deducting balance from the main balance
   System.out.println("Transaction successful");
    break;
    case 5:
    System.exit(0);

}
}
sc.close();
}
}
}
