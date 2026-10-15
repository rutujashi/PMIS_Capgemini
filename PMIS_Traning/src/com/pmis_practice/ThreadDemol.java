package MultiExample.com;

public class ThreadDemol  extends Thread{
	
	public void run()
	{
		System.out.println("Thread is running...........");
	}

	public static void main(String[] args) {
		ThreadDemol obj = new ThreadDemol();
		obj.start();
		
		

	}

}
