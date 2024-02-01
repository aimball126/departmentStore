package dataModel.paymantmethod;

public class CreditCard extends PaymentMethod {

  private double overhead;

  public CreditCard(double overhead) {
    this.overhead = overhead;
  }

  @Override
  public double calculateAmount(double amount) {
    return amount - (amount * overhead);
  }
}
