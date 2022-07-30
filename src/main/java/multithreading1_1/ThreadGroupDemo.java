package multithreading;

public class ThreadGroupDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadGroup tg=new ThreadGroup("First Group");
		Thread t1=new Thread(tg,"First");
		Thread t2=new Thread(tg,"Second");
		ThreadGroup tg1=new ThreadGroup(tg,"Secong Group");
		Thread t3=new Thread(tg1,"Three");
		Thread t4=new Thread(tg1,"Four");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			t4.setDaemon(true);
		} catch (Exception e) {
			System.out.println("exception handled");
		}
		
		System.out.println("Active Thread : "+tg.activeCount());
		System.out.println("Parent Group name : "+tg1.getParent());
		System.out.println("t4 Daemon thread or not"+t4.isDaemon());
	}

}
