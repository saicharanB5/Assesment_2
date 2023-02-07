package dxc;

class User {
  private int id;
  private String username;
  private String email;
  private double walletBalance;

  public User(int id, String username, String email, double walletBalance) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.walletBalance = walletBalance;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public double getWalletBalance() {
    return walletBalance;
  }

  public void setWalletBalance(double walletBalance) {
    this.walletBalance = walletBalance;
  }

  public boolean makePayment(double billAmount) {
    if (walletBalance >= billAmount) {
      walletBalance -= billAmount;
      return true;
    }
    return false;
  }
}

class KYCUser extends User {
  private int rewardPoints;

  public KYCUser(int id, String username, String email, double walletBalance) {
    super(id, username, email, walletBalance);
  }

  public int getRewardPoints() {
    return rewardPoints;
  }

  public void setRewardPoints(int rewardPoints) {
    this.rewardPoints = rewardPoints;
  }

  @Override
  public boolean makePayment(double billAmount) {
    boolean paymentSuccess = super.makePayment(billAmount);
    if (paymentSuccess) {
      rewardPoints += billAmount * 0.1;
    }
    return paymentSuccess;
  }
}

class EPayWallet {
  public static void processPaymentByUser(User user, double billAmount) {
    if (user.makePayment(billAmount)) {
      System.out.println("Payment of " + billAmount + " made successfully");
      System.out.println("Your wallet balance is now: " + user.getWalletBalance());
      if (user instanceof KYCUser) {
        System.out.println("Your reward points are now: " + ((KYCUser) user).getRewardPoints());
      }
    } else {
      System.out.println("Insufficient wallet balance to make payment of " + billAmount);
      System.out.println("Your wallet balance is: " + user.getWalletBalance());
    }
  }
}

public class KYC_user {
  public static void main(String[] args) {
    User user = new User(101, "Jack", "jack@dxc.com", 1000);
    KYCUser kycUser = new KYCUser(201, "Jill", "jill@dxc.com", 3000);

    EPayWallet.processPaymentByUser(user, 700);
    EPayWallet.processPaymentByUser(kycUser, 2000);
  }
}