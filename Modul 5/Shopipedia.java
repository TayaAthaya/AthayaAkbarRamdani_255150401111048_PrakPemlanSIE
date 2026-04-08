public class Shopipedia {
    public static void main(String[] args) {
        
        ShopiPay shopiCard = new ShopiPay();
        
        Customer miki = new Customer(shopiCard);
        miki.deposit(10000);
        miki.pay(2000);
        miki.pay(3000);
        miki.deposit(1000);
        miki.pay(7000);
        
        System.out.println("------------------");
        
        Opo opoCard = new Opo();
        
        Customer dono = new Customer(opoCard);
        dono.deposit(10000);
        dono.pay(2000);
        dono.pay(3000);
        dono.deposit(1000);
        dono.pay(7000);
    
        Kris krisCard = new Kris();
        Customer rudi = new Customer(krisCard);
        rudi.deposit(10000);
        rudi.pay(2000);
        rudi.pay(3000);
        rudi.deposit(1000);
        rudi.pay(7000);


        Emoney kris = new Emoney() {
            {
                this.name = "Kris";
            }

            @Override
            public void topUp(double amount) {
                System.out.println("Top up: " + amount);
                this.balance += (amount + (0.05 * amount));
                this.balance();
            }

            @Override
            public void pay(double amount) {
                double amountToPay = amount - (0.03 * amount);
                if (this.balance > amountToPay) {
                    this.balance -= amountToPay;
                    System.out.printf("Pay " + amount);
                    System.out.println(" using " + this.name);
                } else System.out.println("Not enough balance.");
                this.balance();
            }
        };

        Customer kris2 = new Customer(kris);
        kris2.deposit(10000);
        kris2.pay(2000);

    }
}