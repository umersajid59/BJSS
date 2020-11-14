package com.bjss.basketTest

import org.scalatest.flatspec.AnyFlatSpec

class aplicationTest extends AnyFlatSpec {
  it should "return zero for items like Water gum shoes" in  {
    val dummyLst = List("Water","gum","shoes")
    val items = new Basket().checkItem(dummyLst)
    assert(items.size == 0)
  }
  it should "return 4 for items like milk soup bread Apple" in  {
    val dummyLst = List("milk","soup","bread", "Apple")
    val items = new Basket().checkItem(dummyLst)
    assert(items.size == 4)
  }
  it should "return 2 for Milk entered two times" in  {
    val dummyLst = List("milk","Milk","apple")
    val temp = new Basket()
    val items = temp.checkItem(dummyLst)
    val count = temp.countItems(items)
    assert(count("Milk")._1 == 2)
  }
  it should "total should be 4.10 given bucket" in {
    val out = 4.10
    val dummyLst = List("milk","apple","apple","bread")
    val temp = new Basket()
    val items = temp.checkItem(dummyLst)
    val count = temp.countItems(items)
    var res = 0.0
    for(v <- count.values){
      res = res + (v._1 * v._2)
    }
    assert(res == out)
  }
  it should "total should be 3.90 given bucket" in {
    val out = 3.00
    val count = Map("Apple"->(1,1.0),"Bread"->(1,0.80),"Milk"->(1,1.30))
    var total = 0.0
    for(v <- count.values){
      total = total + (v._1 * v._2)
    }
    val (rep,res) = new CheckDiscout(count,total).applyDiscount
   
    assert(res == out)
  }
}