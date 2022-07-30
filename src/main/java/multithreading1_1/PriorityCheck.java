package multithreading;

public class PriorityCheck implements Runnable {
	
	public void run(){
		System.out.println(Thread.currentThread().getName()+"\t"+Thread.currentThread().getPriority());
	}

	public static void main(String[] args) {
		PriorityCheck p1 = new PriorityCheck();
		PriorityCheck p2 = new PriorityCheck();
		PriorityCheck p3 = new PriorityCheck();
		Thread t1 = new Thread(p1, "First");
		t1.setPriority(Thread.NORM_PRIORITY);
		Thread t2 = new Thread(p2,"Second");
		t2.setPriority(Thread.MIN_PRIORITY);
		Thread t3 = new Thread(p3,"Third");
		t3.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
		
		

	}

}

//	class PriorityCheck{
//		public static void main(String[] args){
//			Thread t1=new Thread("First");
//			Thread t2=new Thread("Second");
//			Thread t3=new Thread("third");
//			t1.start();
//			t2.start();
//			t3.start();
//		}
//	}
