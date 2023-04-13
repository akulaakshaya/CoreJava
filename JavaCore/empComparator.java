package JavaCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class emp {
	private int id;
	private String name;
	private double sal;

	public emp(int i, String n, double s) {
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
}

class example implements Comparator<emp> {
	public int compare(emp x, emp y) {
		return (int) (x.getSal() - y.getSal());
	}
}

public class empComparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		emp e = new emp(1, "Akshaya", 247);
		emp e1 = new emp(2, "LAskj", 2534);
		emp e2 = new emp(3, "Vugj", 4366);
		emp e3 = new emp(1, " Bhar", 35);
		ArrayList<emp> ob = new ArrayList<>();
		ob.add(e);
		ob.add(e1);
		ob.add(e2);
		ob.add(e3);
		// example ob1 = new example();
		Collections.sort(ob, new example());
		System.out.println(ob);
	}

}
