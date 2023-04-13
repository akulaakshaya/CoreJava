package JavaCore;

class a extends Thread {
	public void run() {

		System.out.println("Running me 1");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fun();
	}

	public void fun() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}

	}
}

class b extends Thread {
	public void run() {
		System.out.println("Running me 2");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fun();
	}

	public void fun() {
		for (int i = 10; i < 20; i++) {
			System.out.println(i);
		}

	}
}

public class multiThread {
	public static void main(String args[]) {
		System.out.println("Hi");

		a ob = new a();
		b ob1 = new b();
		ob.start();
		ob1.start();

	}

}
