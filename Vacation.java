public abstract class Vacation{
// instance variable that stores the name of the family member
   private String name;
// instane variable that stores the phone number of a family member
   private String phoneNum;
// instance variable for name of destination
   private String destName;
// array of instance which stores the activities
   private String [] activity= new String [5];
// array of instance which stores the costs of all activities
   private double [] cost= new double [5];
// counter for activities entered
   public int numActivity;
// static variable for how many recommendations have been entered
   public static int numMembers=0;
// instance variable that stores the total cost of activities
   private double activityTotal;

// default constructor
   public Vacation(){
      this("","","","",0.0);
      this.numActivity=0;
   }
// specific constructor with paramters
   public Vacation(String name,String phoneNum, String destName, String activity, double cost){
      this.name=name;
      this.phoneNum=phoneNum;
      this.destName=destName;
      this.activity[numActivity]=activity;
      this.cost[numActivity]=cost;
      numMembers++;
   
   }// constructor ends
   // setName method which sets the name of a family member
   public void setName(String name){
      this.name=name;
   } // setName method ends
   
   // accessor method for the name of a family member returns the intsance variable name
   public String getName(){
      return name;
   }// getName method ends
   
// setPhoneNum method which sets the phone number of a family member
   public boolean setPhoneNum( String phoneNum){
   // if statement that validates if phone number is at least 10 characters long
      if(phoneNum.length()!=10){
      
         return false;
      }
      else {
         this.phoneNum=phoneNum;
      }
      return true;
   }// setPhoneNum method ends

// accessor method which returns the intance variable phoneNum
   public String getPhoneNum(){
      return phoneNum;
   }// getPhonNum method ends

// this method sets the destination name for each recommendation
   public void setDestination( String destName){
      this.destName=destName;
   }// setDestination method ends
   
   // accessor method which returns the destName instance variable
   public String getDestination(){
      return destName;
   }// getDestination method ends
   
// setActivities method which stores all the activities into the activity instance array   
   public void setActivities( String activity){
      this.activity[numActivity]=activity; 
   }// setActivities method ends
  
  // accessor method for activity array
   public String getActivities(){
      String activities="";
   // for loop loops through the activity array and stores all values into one String variable and returns it
      for(int i=0; i< numActivity; i++){
         activities+= activity[i]+"\n";
      }
      return activities;
   }// getActivities method ends
  
  // setCost method sets the cost of each activity
   public boolean setCost( double cost){
   // if statement which validats if cost is valid
      if(cost>25||cost<0){
         return false;
      }
      else{ 
      // if valid cost then cost instance array is loaded with the cost variable at the index position numActivity
         this.cost[numActivity]=cost;
      // numActivity variabel is incremented
         numActivity++;
         return true;
      }
   }// setCost method ends
// calculateActivityTotal method which calculates the total cost of all activities by adding them all up
   public double calculateActivityTotal(){
   // for loop loops through the cost array and adds it to activity total
      for(int i=0; i<numActivity;i++){
      
         activityTotal+= cost[i];
      }
      return activityTotal;
   }// calculateActivityTotal method ends

// accessor method for acitivity total
   public double getActivityTotal(){
      return activityTotal;
   }// getActivityTotal method ends

// accessor method which returns the cost of all activities
   public String getCost(){
      String costList="";
   // for loop which loop through cost array and stores each index position's cost into the costList variable
      for( int i=0; i<numActivity; i++){
         costList+= cost[i]+"\n";
      }
      return costList;
   }
// accessor method for getNumMembers
   public static int getNumMembers(){
      return numMembers;
   }// getNumMembers method ends

// accessor method for counter of the activities
   public int getNumActivity(){
      return numActivity;
   }
   // toString method
   
   
   public abstract double calculateCost();
   public String toString(){
      // print vairable is set
      String print="";
      // print variable stores the name of the family member, phone number, name of destination, activities,
      
      print+=" Name: "+ getName() + "\n"+
                  "Phone no.: " + getPhoneNum() + "\n"+
                  "Destination:" +getDestination()+"\n"+
                  "Activities: " + getActivities()+
                  "Cost of Activities: " +getCost();
      return print;
   }// toString method ends

}// vacation method ends



   
