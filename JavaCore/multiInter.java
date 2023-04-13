package JavaCore;

class x {
	int j = 0;

	public synchronized void sum() {
		for (int i = 1; i < 10; i++) {
			j += 1;
			System.out.println(j);
		}

	}
}

class abc implements Runnable {
	x t = null;

	public abc(x ptr) {
		t = ptr;
	}

	public void run() {
		System.out.println("thread1");
		t.sum();
	}
}

class xyz implements Runnable {
	x t = null;

	public xyz(x ptr) {
		t = ptr;
	}

	public void run() {
		System.out.println("thread2");
		t.sum();
	}
}

public class multiInter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Thread t = new Thread();
		x o = new x();

		abc ob = new abc(o);
		xyz ob1 = new xyz(o);
		Thread t = new Thread(ob);
		Thread t1 = new Thread(ob1);

		t.start();
		t1.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End");
	}

}
