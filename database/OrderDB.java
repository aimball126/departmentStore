package database;

import dataModel.order.Order;

public interface OrderDB {
  public Order getOrder(int id);

  public void updateOrder(Order order);

  public void deleteOrder(int id);
}
