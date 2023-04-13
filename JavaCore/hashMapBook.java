package JavaCore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Book {
	private String isbn;
	private String title;
	private double price;
	private int noofPages;

	public Book(String i, String t, double p, int nop) {
		isbn = i;
		title = t;
		price = p;
		noofPages = nop;
	}

	public String toString() {
		return this.isbn + " " + this.title + " " + this.price + " " + this.noofPages;
	}

}

public class hashMapBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Map<String, List<Book>>> hm = new HashMap<>();
		Book b1 = new Book("001", "HalfGF", 1000, 300);
		Book b2 = new Book("002", "RoomNo123", 100, 305);
		Book b3 = new Book("003", "Girl IN the Room 101", 100054, 400);
		Book b4 = new Book("004", "after ", 3453, 547);
		String auth1 = "Akshaya";
		String auth2 = "Lux";
		String auth3 = "Adesh";
		String pub1 = "Aksh1";
		String pub2 = "Aksh2";
		String pub3 = "Aksh3";
		Map<String, List<Book>> auth = new HashMap<>();
		auth.put(auth1, new ArrayList<>());
		auth.get(auth1).add(b1);
		auth.get(auth1).add(b4);
		auth.put(auth2, new ArrayList<>());
		auth.get(auth2).add(b2);
		Map<String, List<Book>> authors = new HashMap<>();
		authors.put(auth3, new ArrayList<>());
		authors.get(auth3).add(b3);
		hm.put(pub1, auth);
		hm.put(pub2, authors);
		System.out.println(hm);
		for (String x : hm.keySet()) {
			System.out.println("Publisher:" + x);
			Map<String, List<Book>> xyz = hm.get(x);
			for (String y : xyz.keySet()) {
				System.out.println("	Author:" + y);
				List<Book> llb = xyz.get(y);
				System.out.println("		Books:" + llb);
			}
		}
	}

}
