package JavaCore;

class Accounts {
	private int ano;
	private String atype;
	private double bal;

	Accounts(int a, String at, double b) {
		ano = a;
		atype = at;
		bal = b;
	}

	public double getBal() {
		return this.bal;
	}

	public void setBal(double b) {
		this.bal = b;
	}

	public void deposit(double amnt) {
		bal = bal + amnt;
		System.out.println(bal);
	}

	public void withdraw(double amnt) {
		if ((bal - amnt) > 0) {
			bal = bal - amnt;
			System.out.println("bal" + bal);
		} else
			System.out.println("Insufficeient funds");
	}

	public void transfer(Accounts a, double amnt) throws InsufficientBalanceException {
		Accounts ac;
		ac = a;
		double x = this.getBal();
		double am = a.getBal();
		if ((x - amnt) > 0) {
			am = am + amnt;
			a.setBal(am);
			this.setBal(x - amnt);
		} else {
			InsufficientBalanceException nf = new InsufficientBalanceException();
			throw nf;
		}

	}
}

class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException() {
		System.out.println("EXCEPTIONNNNN");
	}
}

public class inSuffUserExcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Accounts ac = new Accounts(1001, "Savings", 500);
			ac.deposit(100);
			Accounts ac2 = new Accounts(1002, "Savings", 1500);
			System.out.println(ac2.getBal());
			ac.getBal();
			ac.transfer(ac2, 500);
			System.out.println(ac2.getBal());

		}

		catch (InsufficientBalanceException n) {
			System.out.println("huhsuyafd");
		}

	}

}
