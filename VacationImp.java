/*
   Name: Bhawanjit Singh
   Date: 04/19/2015
   Course/Section: IT 206-207
   Assignment: Programming Assignment 7/8
    This program is designed for grandma Robin to keep track of vacation recommendations. When the program
is run it shows a menu from which user can pick what they want to do. If user picks the first optin which
is to add recommendation they are then prompted whether their recommendation will be travel by air or car.
After they select one option they are then prompted for name, phone number, destination name, activity name
and costs and if they pick that their recommendation is car they are asked for number of miles the destination
is from home and the cars that they are taking. If user picks they are travelling by air they are asked for
the cost of plane ticket. The second option at the main menu is to print all recommendations which prints all
of the recommendations that have been added. Third option is to print budget recommendaiton which prints the 
recommendation that has the lowest total cost. Fourth option on the menu is to print Extravagant Recommendation
which prints the recommenation that has the highest cost. Fifth and last option is to quit which user selects
when they want to exit the program. When progrma is exited it prints the number of air and car recommendations
that have been added and it also prints whether the car recommendaitons included a bmw car.
*/
import javax.swing.JOptionPane;
public class VacationImp{
   public static void main(String[] args) {
      // final variable with maximum number of members is declared
      final int MAX_MEMBERS=13;
      // new array of objects is declared with the size of MAX_MEMBERS
      Vacation [] member= new Vacation[MAX_MEMBERS];
      int menuChoice= getMenuOption();
      while(menuChoice!=5){
        
         switch(menuChoice){
          // Method are called with array of objects as parameter based on user selection on the main menu
            case 1:
               addRecommendation(member, MAX_MEMBERS);
               
               break;
            case 2:
               printRecommendations(member);
               break;
            case 3:
               budgetRecommendation(member);
               break;
            case 4:
               extravagantRecommendation(member);
               break;
            default:
               
               JOptionPane.showMessageDialog(null,"Invalid choice");
         }
         menuChoice=getMenuOption();
         
         
                                           
      }
      String message="";
      // if statement that checks if bmw counter which is in car class has been incremented
      if(car.bmwCount>0){
         message=" There is/are " + car.bmwCount+ " BMWs in all of car recommendations";
      }
      // Else statement which executes if none of the cars added are bmws
      else{
         message=" no BMWs on the list of cars";
      }
      // counters for both air and car are declared
      int carCount=0;
      int airCount=0;
      // for loop starts and loops through the array and incerements the counter of whichever object is found in the array
      for(int i=0; i< Vacation.numMembers; i++){
      if( member[i] instanceof car){
      carCount++;
      }
      else{ airCount++;}
      }
      // Message is pritned when user selects the exit option at the menu
      JOptionPane.showMessageDialog(null, "Number of car Recs: " + carCount + "\n"
                                           +"Number of air Recs: " + airCount+ "\n"
                                           + message);
                                           
   }// main method ends
            
            
   private static int getMenuOption(){
      // choice variable whichs stores the option that user picks at the menu
      int choice=0;
      // boolean variable valid is set to true
      boolean valid=true;
     
      do{
         
         try{
            // User is prompted with a menu
            choice= Integer.parseInt(JOptionPane.showInputDialog("1. Add Recommendations"+ "\n"+
                                                                    "2. Print Recommendations"+"\n"+
                                                                    "3. Print Budget Recommendation" +"\n"+
                                                                    "4. Print Extravagant Recommendation"+ "\n"+ 
                                                                    "5. Quit"));
                                                                  
         }
         catch(NumberFormatException e){
           
            valid=false;
           
            choice=0;
         }
      }while(valid=false);
        // choice is returned to the main menu   
      return choice;
   } // getMenuOptionMethod ends


   private static void addRecommendation( Vacation [] member, int MAX_MEMBERS){
      // decision variable declared which takes user's input for if they are recommending an air rec or car rec
      int decision=0;
      // if statement that checks if the maximum number of members have been added to the program
      if(Vacation.getNumMembers()==MAX_MEMBERS){
         JOptionPane.showMessageDialog(null," You have reached the max limt of children");
      }
      
      else{
         int numMember= Vacation.getNumMembers();
         String name="";
         String phoneNum="";
         String destination="";
         String activity="";
         String carName="";
         double cost=0;
         int choice=0;
         
      do{
         try{
         // User is prompted for an option for air or car and value is stored in decision variable
         decision= Integer.parseInt(JOptionPane.showInputDialog(" Is this recommendation by air or car" + "\n" + "1.Car" + "\n" + "2.Air"));
         }
         catch(Exception e){
         decision=-1;
         }
         if(decision<1||decision>2){
         JOptionPane.showMessageDialog(null," Invalid selection");
         }
         
        } while(decision<1||decision>2);
         // new car object is created if user picks 1 when prompted
         if(decision==1){
            member[numMember]=new car();
         }
         // air object is created if option is 2
         else {
            member[numMember]= new air();
         }
         do{
            // user is prompted for name
            name= JOptionPane.showInputDialog("Enter name of the family member");
            // validation for empty string
            if(name.equals("")){
               JOptionPane.showMessageDialog(null,"Invalid name");
            }
         }while(name.equals(""));
         // name is sent into the setName method and stored at index numMember
         member[numMember].setName(name);    
         do{
            // user is prompted for phone number
            phoneNum= JOptionPane.showInputDialog(null," Enter phone number in format of xxxxxxxxxx:");
          
            if(!member[numMember].setPhoneNum(phoneNum)){
               JOptionPane.showMessageDialog(null," Invalid phone number please try again");
            }
            
         }while(!member[numMember].setPhoneNum(phoneNum));
         do{
            destination=JOptionPane.showInputDialog("Please enter the destination");
            // validation for empty string
            if(destination.equals("")){
               JOptionPane.showMessageDialog(null,"Invalid name");
            }
         }while(destination.equals(""));
         // setDestination method called and destination is sent as paramter
         member[numMember].setDestination(destination);
         
         do{
            // if statement that checks if maximum number of activities have been added and gives an arror message
            if(member[numMember].getNumActivity()==5){
               JOptionPane.showMessageDialog(null," you have reached the max activities");
            }
            else{
            do{
               // user prompted for activities
               activity= JOptionPane.showInputDialog("Please enter the activity name");
               // validates if user enters a null value
               if(activity.equals("")){
               JOptionPane.showMessageDialog(null,"activity name cannot be left blank");
               }
               // do loop ends until string is left blank
               }while(activity.equals(""));
               // activity variable is sent into setAcitivities method
               member[numMember].setActivities(activity);
                  
                  do{
                  do{
                  try{
                  // user is prompted for cost of the activity
                  cost= Double.parseDouble(JOptionPane.showInputDialog("Please enter the cost of " + activity));
                  
                  }
                  // catches if user enters a blank value
                  catch(Exception e){
                  
                  JOptionPane.showMessageDialog(null," cannot be left blank");
                  // cost is set to -1
                  cost=-1;
                  }
                  // do loop ends with condition until cost is -1
                  }while(cost==-1);
                  // error message is shown if invalid value is entered for cost
                 if(cost<0|| cost>25){
                 JOptionPane.showMessageDialog(null," Invalid value cost must be less than more than $0 and less than $25");
                 }
                  // do loop ends and condtion is until the setCost method returns false
               }while(!member[numMember].setCost(cost));
            }
            // after adding each activity if counter for activities is still less than 5 user is prompted if they want to add another
            if(member[numMember].getNumActivity()<5){
               int option= JOptionPane.YES_NO_OPTION;
               // user is prompted if they want to enter another activity
               choice = JOptionPane.showConfirmDialog (null, "Another activity?","",option);
            }
            else{
               // Error messsage printed if max activies have been entered
               JOptionPane.showMessageDialog(null," Maximum number of activities have been added");
            }
            // loop condition set to if user picks yes for adding activity and the counter is still less than 5
         }while(choice==0&& member[numMember].getNumActivity()<5);
         // if statement that checks if they picked the car rec in the beginning
         if(decision==1){
         
            int numMiles=0;
            do{
               try{
                  // user prompted for number of miles
                  numMiles= Integer.parseInt(JOptionPane.showInputDialog(" Please enter number of miles destination is from home"));
               }
               // if numMiles is left blank or a letter value is entered numMiles is set to -1
               catch(Exception e){
                  numMiles=-1;
               }
               // Error message is printed if setMiles method returns false
               if(!((car)member[numMember]).setMiles(numMiles)){
                  JOptionPane.showMessageDialog(null," Invalid number of miles");
               }
               // loop condition is set to until it keeps returning false
            } while(!((car)member[numMember]).setMiles(numMiles));
          
            do{
               // If statement that checks if maximum number of cars have been added
               if(((car)member[numMember]).getNumCars()==13){
                  JOptionPane.showMessageDialog(null," Max cars have been added");
               }
               else{
                   do{
                  // user is prompted for car name if car counter has not reached its limit
                  carName= JOptionPane.showInputDialog("Please enter the name of the car");
                  // if statement that checks if carName is left blank
                  if(carName.equals("")){
                  JOptionPane.showMessageDialog(null," Car name cannot be left blank");
                  }
                  // do loop ends with conditin unti carName is null
                  }while(carName.equals(""));
                  ((car)member[numMember]).setCars(carName);
               }
               // user is prompted whether they want to enter another car
            }while(JOptionPane.showConfirmDialog(null,"Enter another car")==JOptionPane.YES_OPTION&&((car)member[numMember]).getNumCars()<13);
         }
         //else statement which executes only if it is an air object
         else{
            
            double ticketCost=0;
          
            do{
               try{
                  // user prompted for cost of the ticket
                  ticketCost= Double.parseDouble(JOptionPane.showInputDialog(" Please enter the cost of plane ticket:"));
               }
               // validates user input for numeric valud and checks its not null
               catch(Exception e){
                  ticketCost=-1;
               }
               // if statement that checks if setAirCost method returned false
               if(!((air)member[numMember]).setAirCost(ticketCost)){
                  JOptionPane.showMessageDialog(null," Invalid cost of ticket");
               }
            } while(!((air)member[numMember]).setAirCost(ticketCost));
         }// else ends
       } // else ends    
      
   }  // addRecommendation method ends       
            
   private static void printRecommendations(Vacation [] member){
        // if statement that checks if no recommendations have been added yet    
      if(Vacation.numMembers==0){
         JOptionPane.showMessageDialog(null," No recommendations have been added.");
      }
      else{
       
         String message="";
         for(int i=0; i< Vacation.getNumMembers(); i++){
           /* if(member[i] instanceof car){
               // car's toString method is called
               message+= ((car)member[i]).toString();
            }
            else{
               // air's toString method is called
               message+= ((air)member[i]).toString();
            }*/
            message+= member[i].toString();
         }
         JOptionPane.showMessageDialog(null, message);
            
      }
   }
   
   private static void budgetRecommendation(Vacation [] member){
      // if statement that checks if no recommendations have been added yet
      if(Vacation.getNumMembers()==0){
         JOptionPane.showMessageDialog(null," No recommendations have been added yet");
      }
      else{
         String message="";
         double lowest=0;
         int temp=0;
         int temp2=0;
         
         lowest=member[0].calculateCost();
         for(int i=0; i < Vacation.getNumMembers();i++){
         if(member[i].calculateCost()<lowest){
         lowest=member[i].calculateCost();
         temp=i;
         }
         }
         for(int i=0; i< Vacation.getNumMembers();i++){
            if(member[i].calculateCost()==member[temp].calculateCost()){
            temp2=i;
            }
            }
           message= member[temp].toString();
           if(temp!=temp2){
           message+= member[temp2].toString();
           }
           
           JOptionPane.showMessageDialog(null, "**Budeget Recommendation**" + "\n" + message);

            
            }
         // if statement that checks if index 0 of member array is an object of car class
         /*if(member[0] instanceof car){
            // lowest variable is set to the index 0's total cost
            lowest=((car)member[0]).getTotalCost();
         }
         // if statement that checks if index 0 of member array is an object of air class
         else if(member[0] instanceof air){
            // lowest is to that value
            lowest= ((air)member[0]).getTotalSpending();
         }
         // for loop starts and loops through the member array the depending on how many recs have been submitted
         for(int i=0; i<Vacation.getNumMembers();i++){
            // if statement that checks if rest of the values of car class indexes in the array are less than the value of lowest
            if(member[i] instanceof car){
               if(((car)member[i]).getTotalCost()<lowest){
                  lowest=((car)member[i]).getTotalCost();
                  // index value of lowest is stored in temp
                  temp=i;
               }
            }
            // if statement that checks if rest of the values of air class indexes in the array are less than the value of lowest 
            else if ( member[i] instanceof air){
               if(((air)member[i]).getTotalSpending()<lowest){
                  lowest=((air)member[i]).getTotalSpending();
                  // index value of lowest is stored in temp
                  temp=i;
               }
            }
         }
            // the position is of car instance then the toString car class is called
         if(member[temp] instanceof car){
            message=((car)member[temp]).toString();
         }
            // the toString of air class is called
         else if (member[temp] instanceof air){
            message= ((air)member[temp]).toString();
         }
         JOptionPane.showMessageDialog(null, "**Budeget Recommendation**" + "\n" + message);
      } */
   } 
            
            
   private static void extravagantRecommendation(Vacation [] member){
         // if statement that checks if no recommendations have been added yet
      if(Vacation.getNumMembers()==0){
         JOptionPane.showMessageDialog(null," No recommendations have been added yet");
      }  
      else{
         String message="";
         double highest=0;
         int temp=0;
         // for loop starts and loops through the member array the depending on how many recs have been submitted
         for(int i=0; i<Vacation.getNumMembers();i++){
         // if statement that checks if the index of member is an instance of car class
            if(member[i] instanceof car){
            // compares that total cost to the highest and if it is more then the highest is set to the cost
               if(((car)member[i]).getTotalCost()>highest){
                  highest=((car)member[i]).getTotalCost();
                  // index is stored into temp variable
                  temp=i;
               }
            }
               // if statement to check if the object in the array is of air class
            else if ( member[i] instanceof air){
               // if statement that checks if the totalSpending is more than highest
               if(((air)member[i]).getTotalSpending()>highest){
                  highest=((air)member[i]).getTotalSpending();
                  // index is stored into tmep
                  temp=i;
               }
            }
         }
            // car's toString method is called if the index temp is of car class
         if(member[temp] instanceof car){
            message=((car)member[temp]).toString();
         }
            // air's toString method is called if the index temp is of air class
         else if (member[temp] instanceof air){
            message= ((air)member[temp]).toString();
         }
         JOptionPane.showMessageDialog(null, "**Extravagant Recommendation**" + "\n" + message);     
      } // else ends       
   } // extravagantRecommednation method ends          
}// VacationImp class ends
            
            
            
            
            
            
            
          
                   
                   
                   
                   
                   
                   
                
