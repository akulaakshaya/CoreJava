package JavaCore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class empDetails implements Comparable<empDetails> {
	private String id;
	private String name;
	private String sal;

	public empDetails(String i, String n, String s) {
		id = i;
		name = n;
		sal = s;
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getSal() {
		return this.sal;
	}

	public int compareTo(empDetails ed) {
		return (int) (Integer.parseInt(ed.sal) - Integer.parseInt(this.sal));
	}

	public String toString() {
		return this.name + " ," + this.sal;
	}
}

public class empExternalization {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<empDetails> x = new ArrayList<>();
		try {
			BufferedReader obj = new BufferedReader(new FileReader("D:\\example.txt"));
			String nxtline;
			String t[];
			while ((nxtline = obj.readLine()) != null) {
				t = nxtline.split(",");
				x.add(new empDetails(t[0], t[1], t[2]));
			}
		} catch (Exception e) {
			System.out.println("excepted");
		}
		System.out.println("enter ibput");
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		for (empDetails ed : x) {
			if (Double.parseDouble(ed.getSal()) == Double.parseDouble(a)) {
				System.out.println(ed.getName());
			}
		}
		Collections.sort(x, Collections.reverseOrder());
		System.out.println(x);
	}

}
