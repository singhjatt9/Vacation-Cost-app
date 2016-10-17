public class car extends Vacation{
// instance variable that stores number of miles destination is from home
   private int miles;
// Instance array of strings that stores car names
   private String [] cars= new String [13];
// per mile charge of gas
   private final double RATE_PER_MILE=0.575;
// counter for number of cars that have been added
   public int numCars;
// Total cost after adding everything
   private double finalCost;
// Base cost variable without adding the costs of activities and miles
   private double baseCost;
// counter for number of times the toString method has been called
   private int numToString=0;
   private double finalTotal=0;
// counter that counts how many bmw cars have been added
   public static int bmwCount=0;
   private final int MAX_MILE=425;
   private final int MIN_MILE=0;


   public car(){
      this.numCars=0;
      this.baseCost=0;
      this.finalCost=0;
   }

   public car(String name,String phoneNum, String destName, String activity, double cost,int miles, String car){
   // variables that are inherited from super class
      super(name,phoneNum,destName,activity,cost);
      this.miles=miles;
      this.cars[numCars]=car;   
   }

   public boolean setMiles( int miles){
   // instance variable miles is set and validated
      if(miles>MAX_MILE|| miles<MIN_MILE){
         return false;
      }
      else{
         this.miles=miles;
         return true;
      }
   }
// instance array of cars is loaded with values
   public void setCars( String car){
   // if statement that checks if a bmw has been entered and increments the counter
      if(car.equalsIgnoreCase("BMW")){
         bmwCount++;
      }
   // cars array is set
      this.cars[numCars]=car;
      numCars++;
   }
// method that caluclates the total cost
   public double calculateCost(){
   // base cost is calculated by multiplying the miles*RATE_PER_MILE
      baseCost=miles*RATE_PER_MILE;
   // final cost is set
      finalCost=calculateActivityTotal()*13+baseCost;
      return finalCost;
   }
// Accesssor method for total cost which returns the final cost is returned
   public double getTotalCost(){
      return finalCost;
   }
// accessor method that returns the miles
   public int getMiles(){
      return miles;
   }
// method that Stores the names of all of the cars
   public String getCars(){
      String carList="";
   // for loop loops through the car array and stores all cars into carList String
      for( int i=0; i<numCars; i++){
         carList+= cars[i] + "\n";
      }
      return carList;
   }
   // Accessor method that returns the number of cars that were added
   public int getNumCars(){
      return numCars;
   }
   // toString method that returns the cars, miles from home and total cost.
   public String toString(){
   // if statement that checks if the numToString is still 0
      if(numToString==0){
      //calculateCost() method is called
         finalTotal= calculateCost();
      }
      numToString++;
      String print="";
      print+= super.toString() +
                  " Cars: "+ getCars() +
                  "Miles from home: " + getMiles() + "\n"+
                  "Total Cost:" + String.format("%.2f",finalTotal)+"\n";
      return print;
   }// toString method ends
   
}// Vacation method ends