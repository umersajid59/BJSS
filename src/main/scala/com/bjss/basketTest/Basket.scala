package com.bjss.basketTest

class Basket {
  
  //read the user entered list and
  //adds them to a basket if they match 
  //inventory items regardless of there
  //letter case
  def checkItem(lst:List[String]) : List[String] = {
    var basket : List[String] = List()
    for (item <- lst){
      if (item.equalsIgnoreCase("soup")) basket = basket :+ ("Soup")
      else if (item.equalsIgnoreCase("milk")) basket = basket :+ ("Milk")
      else if (item.equalsIgnoreCase("apple")) basket = basket :+ ("Apple")
      else if (item.equalsIgnoreCase("bread")) basket = basket :+ ("Bread")
    }
    //if no item are add to the basket
    //displays the message and exists the
    //application
    return basket
  }
  
  //count all items in the basket and add price to them
  def countItems(lst:List[String]) :  Map[String, (Int,Double)] ={
    //creating mutable Map collection to store final basket data
    var countProduct = Map[String, (Int,Double)]()
    //map items and their prices
    val products: Map[String,Double] = Map("Soup" ->0.62, "Apple"->1, "Milk"->1.30, "Bread"->0.80)
    //mapping a 1 for each item in list
    val items = lst.map(x => (x,1))
    //groupby each item and counting them
    val countItems = items.groupBy(_._1).mapValues(_.length)
    var totalPrice = 0.0
    
    //matching given item list with the list of
    //item available in the products dictionary
    //and calculating the total price
    for ((k,v) <- countItems){
      if(products.contains(k)){
        //totalPrice  = totalPrice + (v * products(k))
        countProduct+=(k->(v,products(k)))
      }
    }
    return countProduct 
  }
}