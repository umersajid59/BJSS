package com.bjss.priceBasket



object itemCalculator {
  
  def main(args: Array[String]){

    //val arg = scala.io.StdIn.readLine()
    val basketItems = args.toList
    val basket = new Basket()
    val basketCheck =  basket.checkItem(basketItems)
    if(basketCheck.size ==0){
      println("no items added to basket that are available in inventory")
      System.exit(0)
    }
    val finalList =  basket.countItems(basketCheck)
    var totalPrice = 0.0
    for(v <- finalList.values){
      totalPrice = totalPrice + (v._1 * v._2)
    }

    //printing total without applying any offers
    var outString = f"Subtotal: £$totalPrice%.2f"
    val (rep,price) = new CheckDiscout(finalList,totalPrice).applyDiscount
    
    //if no discounts are applied
    //added the desired message 
    //and final Total of the basket
      outString += rep
      outString += f"\nTotal: £$price%.2f"
    
    //printing the final message
    println(outString)
  }
  
}