package com.bjss.priceBasket

class CheckDiscout(finalList: Map[String, (Int,Double)], totalPrice: Double) {
  def applyDiscount : (String,Double) ={
    //local mutable variables for calculation
    var outString1 = ""
    var totalPrice1 = totalPrice
    //list of discount Items
    val discounts = List("Apples","Bread")
    //looping through the dictionary and
    //finding items with discount offers
    for( i <- discounts){
      if(finalList.contains(i) && i == "Apples"){
        //applying the 10% discount
		var aplCnt = finalList(i)._1
		var appleDiscout = 0.0
		while(aplCnt > 0){
			appleDiscout = appleDiscout + (finalList(i)._2 * 0.1)
			aplCnt = aplCnt - 1
		}
        
        //printing the message discount to output message
        outString1 += f"\nEach Apple Bag 10 percent OFF: $appleDiscout%.2f p"
        //subtracting the discount from total amount
        totalPrice1 = totalPrice1 - appleDiscout
      }
      if(finalList.contains(i) && i == "Bread"){
        if(finalList.contains("Soup") && finalList("Soup")._1 >=2){
          //simple if the number of soup tins is
          //twice the number of bread loafs in the
          //final list
          val check1 = finalList("Soup")._1/finalList("Bread")._1
          if(check1 ==2){
            
            //apply the discount 
            val breadHalf = (finalList("Bread")._2 * finalList("Bread")._1)/2
            
            //print the discount message
            outString1 += f"\n2 tins of soup and get a loaf of bread Half-Price: $breadHalf%.2f p"
            
            //subtracting the discount from total amount
            totalPrice1 = totalPrice1 - breadHalf
          }
          else{
          
            //getting total count of soup tins
            //and bread loaf
            var spTin = finalList("Soup")._1
            var br = finalList("Bread")._1
            var breadDiscount = 0.0
            
            //doing a while loops that keeps
            //on cutting the bread value in
            //half as long as the tin count is
            //greater than 1 and bread count is 
            //greater than or equal to 1
            while(spTin >1 && br >=1){
              
              //cutting bread price in half
              //adding the discounted price in
              //variable
              breadDiscount = breadDiscount + (finalList("Bread")._2/2)
              
              //subtracting the tin count by 2
              //and bread count by 1
              spTin = spTin -2
              br = br -1
            }
            
            //subtracting the discount bread
            //price from the total price
            totalPrice1 = totalPrice1 - breadDiscount
            outString1 += f"\n2 tins of Soup and get a loaf of bread Half-Price: $breadDiscount%.2f p"
          }
        }
      }
    }
    //if no special offer item is 
    //available in the final list
    //or the offer conditions are
    //not met
    if(outString1 == ""){
      return ("\n(no offers available)",totalPrice)
    }
    
    //else add the new total
    //to the output string and
    //return it
    //outString1 += f"\nTotal: £$totalPrice1%.2f"
    return (outString1,totalPrice1)
  }
}