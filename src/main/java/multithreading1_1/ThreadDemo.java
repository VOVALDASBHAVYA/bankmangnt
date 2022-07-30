package multithreading;

public class ThreadDemo extends Thread {

	public void run() {
		for (int i = 6; i <= 10; ++i) {
			System.out.println("Inside run method : " + i + " " + Thread.currentThread().getName());

		}
	}

	public static void main(String[] args) {
		ThreadDemo td=new ThreadDemo();
//		Thread t=new Thread();
		td.start();
		try {
			td.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		td.setName("java");
		for(int i=1;i<=5;++i){
			System.out.println("Inside main thread : "+i);
		}
		
	}

	
}
