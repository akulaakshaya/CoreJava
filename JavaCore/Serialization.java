package JavaCore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class vehicle implements Serializable {
	private int no;
	private String name;

	public vehicle(int n, String na) {
		this.no = n;
		this.name = na;
	}
}

class bike extends vehicle {

	public bike(int n, String na) {
		super(n, na);
		// TODO Auto-generated constructor stub
	}

}

public class Serialization {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		bike v1 = new bike(1234, "Shine");
		ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("vehicle1.txt"));
		ob.writeObject(v1);
		if (ob != null) {
			System.out.println("Serialization has been done");

		}
		ob.flush();
		ob.close();
		System.out.println("Deserialization need to be done");
		ObjectInputStream ob2 = new ObjectInputStream(new FileInputStream("vehicle1.txt"));
		bike v2 = new bike(545, "Glamour");

	}

}
