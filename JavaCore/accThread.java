package JavaCore;

class Account {
	private int ano;
	private String atype;
	private double bal;

	Account(int a, String at, double b) {
		ano = a;
		atype = at;
		bal = b;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double b) {
		this.bal = b;
	}

	public synchronized void deposit(double amnt) {

		try {
			bal = bal + amnt;
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("after deposit bal" + this.bal);
	}
}

class Customer extends Thread {
	private Account a;

	public Customer(Account ac) {
		a = ac;
	}

	public void run() {

		a.deposit(1000);
	}
}

public class accThread {

	public static void main(String[] args) {
		try {
			Account a = new Account(1001, "Savings", 500);
			Customer[] c = new Customer[5];
			for (int i = 0; i < 5; i++) {
				c[i] = new Customer(a);
				c[i].start();
			}
			for (int k = 0; k < 5; k++) {
				c[k].join();
			}
			System.out.println("Finally bal" + a.getBal());
		} catch (InterruptedException iex) {
			System.out.println();
		}

		// TODO Auto-generated method stub

	}

}
