import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import dataModel.order.Order;
import dataModel.order.OrderItem;
import dataModel.paymantmethod.Cash;
import dataModel.paymantmethod.CreditCard;
import dataModel.paymantmethod.PaymentMethod;
import dataModel.product.Category;
import dataModel.product.Product;

public class DepartmentStore {

  public static final String csvFile = "./MOCK_DATA.csv";
  public static final String delimiter = ",";

  public static void main(String[] args) {
    // Read input file and store products in the array list of products
    ArrayList<Product> products = new ArrayList<Product>();
    ArrayList<Order> orders = new ArrayList<Order>();
    try {
      File file = new File(csvFile);
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line = "";
      String[] tempArr;
      while ((line = br.readLine()) != null) {
        tempArr = line.split(delimiter);
        int id = Integer.parseInt(tempArr[0]);
        String name = tempArr[1];
        Category category = Category.valueOf(tempArr[2]);
        double cost = Double.parseDouble(tempArr[3]);
        double price = cost * 1.45;
        Product p = new Product(id, name, category, cost, price);
        //System.out.println(p.toString());
        products.add(p);
      }
      br.close();
    } catch (Exception e) {
      System.out.println("Error reading the file:\n" + e.toString());
    }
    // Create a random number of orders
    Random r = new Random(10);
    int numberOrders = (int) (10 * r.nextDouble());
    for (int i = 1; i <= numberOrders; ++i) {
      Order o = new Order(i + 100, new Date());
      int numberItems = (int) (10 * r.nextDouble());
      for (int j = 1; j <= numberItems; ++j) {
        int productIndex = (int) (1000 * r.nextDouble());
        Product p = products.get(productIndex);
        int qty = (int) (10 * r.nextDouble());
        OrderItem item = new OrderItem(qty, p.getUnitprice(), p);
        o.addItem(item);
      }
      orders.add(o);
      System.out.println(o.toString());
    }
    System.out.println("------------------Test--------------------------");
    Order o = orders.get(0);
    System.out.println(o.toString());
    o.addItem(12, 14.34, products.get(59));
    System.out.println(o.toString());
    o.removeItem(products.get(59));
    System.out.println(o.toString());
    PaymentMethod pay = new Cash(0.05);
    System.out.println(o.getOrderTotal(pay));
    pay = new CreditCard(0.05);
    System.out.println(o.getOrderTotal(pay));
  }
}
