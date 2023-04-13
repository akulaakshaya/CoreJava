package JavaCore;

class alphabetReader extends Thread {
	charHolder ch;

	public alphabetReader(charHolder chg) {
		ch = chg;
	}

	public void run() {
		for (int i = 97; i < 124; i++) {
			ch.charReader();
		}
	}
}

class alphabetGenerator extends Thread {
	charHolder ch;

	public alphabetGenerator(charHolder chg) {
		ch = chg;
	}

	public void run() {
		for (int i = 97; i < 124; i++) {
			ch.charWriter((char) i);
		}
	}
}

public class charHolder {
	private char c;

	public synchronized void charReader() {
		if (c == '\u0000') {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("character read:" + c);
			c = '\u0000';
			notify();
		}
	}

	public synchronized void charWriter(char c) {
		this.c = c;
		System.out.println("write:" + c);
		notify();
		try {

			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		charHolder ob = new charHolder();
		alphabetGenerator ob1 = new alphabetGenerator(ob);
		alphabetReader ob2 = new alphabetReader(ob);

		ob2.start();
		ob1.start();
	}
}
