package JavaCore;

import java.util.ArrayList;

class employee {
	private int id;
	private String name;
	private String job;
	private double sal;
	private int deptno;

	public employee(int i, String n, String j, double s, int d) {
		id = i;
		name = n;
		job = j;
		sal = s;
		deptno = d;
	}

	public String toString() {
		return (this.id + "" + this.name + "" + this.job + "" + this.sal + "" + this.deptno);
	}
}

public class empList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		employee e1 = new employee(1, "Akshaya", "Dev", 40000, 1);
		employee e2 = new employee(2, "Lakshmi", "Software", 20000, 1);
		employee e3 = new employee(3, "Adi", "Tester", 10000, 6);
		employee e4 = new employee(4, "Sathvick", "Support", 20000, 1);
		ArrayList<employee> ar = new ArrayList<>();
		ar.add(e1);
		ar.add(e2);
		ar.add(e3);
		ar.add(e4);

		System.out.println(ar);
		for (employee x : ar) {
			System.out.println(x);
		}

	}

}
