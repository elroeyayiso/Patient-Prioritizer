
//Programming Assignment 2: Prioritizing Patients
import java.util.*;
public class PatientPrioritizer {
   // hospital zipcode
   public static final int HOSPITAL_ZIP=12345;
   public static void main(String[] arg){
   
      Scanner console = new Scanner(System.in);
        int count = 0;
        int highscore=0;
        intro();
      String name = patientname(console);

      while(name.equals("quit")!=true){   
        int score = info(console);
           System.out.println("");
           meassage(name,score);
           count++;
       if(score>highscore){
         highscore=score;
        }
    name = patientname(console);
 }
     System.out.println("Statistics for the day:");
     System.out.println("..."+count+" patients were helped");
     System.out.println("...the highest priority patient we saw had a score of "+highscore);
     System.out.println("Good job today!");
}
   // A method to find out if the zip code has 5 digits 
      public static boolean fiveDigits(int val) {
         val = val / 10000; // get first digit
         if (val == 0) { // has less than 5 digits
            return false;
         } else if (val / 10 == 0) { // has 5 digits
            return true;
         } else { // has more than 5 digits
            return false; 
      }
   }  

   //A method to print the program's introduction message
   public static void intro(){
      System.out.println("Hello! We value you and your time, so we will help");
      System.out.println("you prioritize which patients to see next!");
      System.out.println("Please answer the following questions about the next patient so");
      System.out.println("we can help you do your best work :)");
      System.out.println("");
   }
   //A method to get a patient's name through user input
   public static String patientname(Scanner scanner){
      System.out.println("Please enter the next patient's name or \"quit\" to end the program.");
      System.out.print("Patient's name: ");
      String n = scanner.next();
      return n;
   }
   //A method to collect the required patient information
   //age, zip code, insurance information, pain level, and temperature and compute the priority score
   public static int info(Scanner scanner){
      //patient age 
      System.out.print("Patient age: ");
      int age = scanner.nextInt();
      // patient zipcode 
      System.out.print("Patient zip code: ");
      int zip = scanner.nextInt();
      while(fiveDigits(zip)==false){
      System.out.print("Invalid zip code, enter valid zip code: ");
      zip = scanner.nextInt();
    }
      // insurance confirmation
     System.out.print("Is our hospital \"in network\" for the patient's insurance? ");
     String insurance = scanner.next();
      // patient pain level
     System.out.print("Patient pain level (1-10): ");
     int pain = scanner.nextInt();
     while(pain<1||pain>10){
     System.out.print("Invalid pain level, enter valid pain level (1-10): ");
     pain = scanner.nextInt();
     }
       // patient temperature
     System.out.print("Patient temperature (in degrees Fahrenheit): ");
     double temp = scanner.nextDouble();
     int proriy = score(age,zip,insurance,pain,temp);
     return proriy;
   }
      // method to calculate the priority score of the patient
      // takes 5 parameter
     public static int score(int age, int zip, String insure, int pain,double temp){
      int base = 100;
      if(age<12||age>=75){
      base=base+50;
  }
    if((HOSPITAL_ZIP/10000)==(zip/10000)){
     base=base+25;
    if(((HOSPITAL_ZIP/1000)-(zip/1000))==0){
      base=base+15;
    }
  }

    if(insure.equals("yes")||insure.equals("y")){
     base=base+50;
  }
      base=base+(pain*10);
      if(temp>99.5){
      base=base+8;
  }
  return base;
   }
      // A method to print the patient's priority
   public static void meassage(String name, int score){
      if(score<163){
         System.out.println("We have found patient "+name+" to have a priority score of: "+score);
         System.out.println("We have determined this patient is low priority.");
         System.out.println("Please put them on the waitlist for when a medical provider becomes available.");
      
      }else if(score>=163&&score<328){
         System.out.println("We have found patient "+name+" to have a priority score of: "+score);
         System.out.println("We have determined this patient is medium priority.");
         System.out.println("Please assign an appropriate medical provider to their case");
         System.out.println("and check back in with the patient's condition in a little while.");
      }else if(score>=328){
         System.out.println("We have found patient "+name+" to have a priority score of: "+score);
         System.out.println("We have determined this patient is high priority,");
         System.out.println("and it is advised to call an appropriate medical provider ASAP.");}
         System.out.println("");
         System.out.println("Thank you for using our system!");
         System.out.println("We hope we have helped you do your best!");
         System.out.println("");
}
}


     




