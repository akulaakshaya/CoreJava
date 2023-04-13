package JavaCore;

import java.util.List;

class Account1 {
	private int accno;
	private String name;
	private double bal;
	protected List<Transaction> transactions;

	public Account1(int acc, String n, double b) {
		accno = acc;
		name = n;
		bal = b;
	}

	public int getAccno() {
		return accno;
	}

	public String getName() {
		return name;
	}

	public double getBal() {
		return bal;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void deposit(double amnt) {
		this.bal = this.bal + amnt;
	}

	public void withdraw(double amnt) {
		if (this.bal - amnt > 0) {
			this.bal -= amnt;
		} else {
			System.out.println("INsuffiecient Funds");
		}
	}

}

class Transaction {
	private int accno;
	private String trtype;
	private String trdate;
	private double amnt;

	public Transaction(int ac, String ty, String d, double a) {
		accno = ac;
		trtype = ty;
		trdate = d;
		amnt = a;
	}

	public int getAccno() {
		return accno;
	}

	public String getTrtype() {
		return trtype;
	}

	public String getTrdate() {
		return trdate;
	}

	public double getAmnt() {
		return amnt;
	}

}

public class accGenrics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction tr = new Transaction(1, "Savings", "03July", 65443);
		Account1 a = new Account1(1, "akshu", 12435);
		a.transactions.add(tr);
		System.out.println(a.getTransactions());
	}

}
