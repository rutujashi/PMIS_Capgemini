package MultiExample.com;

public class ThreadDemo3 extends Thread{

	public static void main(String[] args) {
		Thread t = new Thread("My First thread");
		t.start();
		
		String str = t.getName();
		System.out.println(str);

	}

}
