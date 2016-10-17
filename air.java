public class air extends Vacation{
// instance variable that stores the cost of airplane ticket
   private double airFare;
// instance variable that stores the total spendings
   private double totalSpending;
// counter for toString method
   private int toStringCount=0;
// instance variable that stores teh total cost of recommendaiton
   private double totalAir;

   private double MIN_FARE=79;
   private double MAX_FARE=419;


   public air(){
   //this.airfare=0;
      this.totalSpending=0;
   }

   public air( String name,String phoneNum, String destName,String activity, double cost, double airFare)
   {
   // instance variables extended from super calss Vacation
      super(name,phoneNum,destName, activity, cost);
      this.airFare=airFare;
   
   }
// setAirCost method which sets the instance variable airFare
   public boolean setAirCost(double airFare){
   // if statement that validates if the ticket cost is valid
      if(airFare>=MIN_FARE && airFare<=MAX_FARE){
      // instance variable airFare is set to airFare
         this.airFare=airFare;
      // true is returned if valid ticket cost
         return true;
      }
      else{
      // false is returned if invalid ticket cost is entered
         return false;
      }// else ends
   }// setAirCost method ends
   
   // accessor method for the cost of the ticket
   public double getAirCost(){
      return airFare;
   }
   // special purpose method that calculates the total cost of an air recommendation
   /*public double calculateTotalCost(){
      double total;
   // total is set to cost of airfare* the number of members and the total activity cost is added
      total=airFare*13+calculateActivityTotal();
      this.totalSpending=total;
      return totalSpending;
   }*/
   public double calculateCost(){
   double total;
   // total is set to cost of airfare* the number of members and the total activity cost is added
      total=airFare*13+calculateActivityTotal();
      this.totalSpending=total;
      return totalSpending;
      }
   
   // accessor method that returns the totalSpending
   public double getTotalSpending(){
      return totalSpending;
   }
      //toString method which returns the print message as string
   public String toString(){
      // if statement which checks if the toString count is 0
      if( toStringCount==0){
      // if toStringCount is 0 then calculateTotalCost method is called and the cost is stored into totalAir method
         totalAir=calculateCost();
      }
      // toString counter is incremented
      toStringCount++;
      // print variable stores super class's toString and the cost of the ticket and the total cost for the recommednation
      String print="";
      print+= super.toString() +
                  " Ticket Cost: "+ getAirCost() + ","+
                  "Total Cost: $" + String.format("%.2f",totalAir) + "\n";
                  
      return print;
   }// toString method ends
   
}// air class ends