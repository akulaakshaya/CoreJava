package JavaCore;

import java.util.ArrayList;
import java.util.Collections;

class Employee implements Comparable<Employee> {
	private int id;
	private String name;
	private double sal;

	public Employee(int i, String n, double s) {
		id = i;
		name = n;
		sal = s;
	}

	public double getSal() {
		return this.sal;
	}

	public String toString() {
		return this.id + " " + name + " " + sal;
	}

	// public int compareTo(Employee e) {
	// return (int) (this.sal - e.sal);
	// }
	public int compareTo(Employee e) {
		if (this.sal > e.sal)
			return -1;
		else if (this.sal == e.sal)
			return 0;
		else
			return 1;
	}
}

public class empComparable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee ob = new Employee(1, "Akshaya", 20000);
		Employee ob1 = new Employee(1, "B", 10000);
		Employee ob2 = new Employee(1, "AC", 5000);
		Employee ob3 = new Employee(1, "D", 242000);
		ArrayList<Employee> emp = new ArrayList();
		emp.add(ob);
		emp.add(ob1);
		emp.add(ob2);
		emp.add(ob3);
		for (Employee e : emp) {
			System.out.println(e);
		}
		Collections.sort(emp);
		System.out.println(emp);
	}

}
