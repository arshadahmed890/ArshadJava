package Food;

import java.io.IOException;

public class Swiggy extends Bill_cal {

    public void Order(String hotelName, String expectedItem, int quantity) throws IOException {
    	
    	  Hotel_Details R = new Hotel_Details();
          String HotelStatus = R.readData(hotelName, "Hotels"); // Assuming the sheet name is "Hotels"
          if (!HotelStatus.equals("notExist")) {
        	  
              System.out.println("The " + hotelName+ " Hotel is Available. Please place your order");
              
              String ItemExist = R.readItem(expectedItem, hotelName);
              
              if (!ItemExist.equalsIgnoreCase("notExist")) {
            	  
                  int price = Integer.parseInt(ItemExist);
                  int TotalPrice = price * quantity;

                  System.out.println("You are ordering " + quantity + " " + expectedItem);
                  System.out.println("The given Item Price is: " + price);
                  System.out.println("Total Price: " + TotalPrice);

                  // Calculate the bill
                  Calculations(TotalPrice);  // it calculates total bill amount 
              }
              else {
                  System.out.println("Sorry, the item " + expectedItem + " is not available at " + hotelName);
              }
          }
          
          else {
              System.out.println("The "+ hotelName +" Hotel is not Available at the moment. Please try after some time");
          }
      }
    

    public static void main(String[] args) throws IOException {
        Swiggy s = new Swiggy();
        s.Order("Bismi","shawarma", 3);
        
    }
}
