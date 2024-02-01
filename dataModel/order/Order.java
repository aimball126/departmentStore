package dataModel.order;

import java.util.ArrayList;
import java.util.Date;

import dataModel.paymantmethod.PaymentMethod;
import dataModel.product.Product;

public class Order {

  private int id;
  private Date date;
  private ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();

  public Order(int id, Date date) {
    this.id = id;
    this.date = date;
  }

  public Order(int id, Date date, ArrayList<OrderItem> items) {
    this.id = id;
    this.date = date;
    if (items != null) {
      this.orderItems = items;
    }
  }

 

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Date getDate() {
    return date;
  }

  public void addItem(OrderItem item) {
    if (!orderItems.contains(item)) {
      orderItems.add(item);
    }
  }

  public void addItem(int qty, double price, Product product) {
    OrderItem newOrderUItem = new OrderItem(qty, price, product);
    if (orderItems.contains(newOrderUItem)) {
      OrderItem oldOrderItem = orderItems.get(
        orderItems.indexOf(newOrderUItem)
      );
      oldOrderItem.setPrice(price);
      oldOrderItem.setQty(qty);
    } else {
      addItem(newOrderUItem);
    }
  }

  public void removeItem(OrderItem item) {
    if (orderItems.contains(item)) {
      orderItems.remove(item);
    }
  }

  public void removeItem(Product product) {
    //TODO: Implement this method to Overload the remove one product from product item
    // if the product exists the qualtity of the item is reduced by 1
    // if the result is 0 quantity after reduction the item should be removed

  }

  public String toString() {
    String r =
      "========= Order =============================================================\n";
    r +=
      String.format(
        "Order number: %1$10d     Order Date: %2$te/%2$tm/%2$tY \n",
        id,
        date
      );
    for (OrderItem orderItem : orderItems) {
      r += (orderItem.toString() + " \n");
    }
    r +=
      String.format(
        "============== T O T A L =================: %1$15.3f",
        getOrderTotal()
      );
    return r;
  }

  public Object getOrderTotal() {
    double total = 0;
    for (OrderItem orderItem : orderItems) {
      total += (orderItem.getQty() * orderItem.getPrice());
    }
    return total;
  }
  public ArrayList<OrderItem> getOrderItems() {
    return orderItems;
}
public double getTotalPrice() {
  double total = 0;
  for (OrderItem item : orderItems) {
      total += item.getQty() * item.getPrice();
  }
  return total;
}

  public double getOrderTotal(PaymentMethod pay) {
    double total = this.getOrderTotal(pay);
    return pay.calculateAmount(total);
  }

  
}
