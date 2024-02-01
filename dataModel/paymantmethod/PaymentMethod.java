package dataModel.paymantmethod;
public abstract class PaymentMethod {

  String name;

  public abstract double calculateAmount(double amount);
}
