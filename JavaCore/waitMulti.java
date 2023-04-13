package JavaCore;

class ak {
	public synchronized void fun() {
		for (int i = 1; i < 10; i++) {
			if (i == 5) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(i);
		}
	}

	public synchronized void fun2() {
		for (int i = 10; i < 20; i++) {
			if (i == 15) {

				notify();

			}
			System.out.println(i);
		}
	}

}

class t extends Thread {
	ak ptr;

	t(ak ptr) {
		this.ptr = ptr;
	}

	public void run() {
		ptr.fun();
		ptr.fun2();
	}
}

public class waitMulti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ak o = new ak();

		t ob = new t(o);
		// t ob1 = new t(o);

		ob.start();
		// ob1.start();
	}

}
