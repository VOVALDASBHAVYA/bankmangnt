package multithreading;
class Demo implements Runnable{

	public static void main(String[] args) {
		Demo run=new Demo();
		Thread t = new Thread(run);
		//X run = new X(); Thread t = new Thread(run); t.start();
		t.start();
	}
	public void run(){
		//only thread will declared within the run method
		//new Thread(new Runnable()).start();
	}
}
