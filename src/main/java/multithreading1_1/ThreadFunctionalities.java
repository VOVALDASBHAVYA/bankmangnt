package multithreading;

public class ThreadFunctionalities extends Thread{

	 public void run()  
	    {    
	        System.out.println("running thread name is:"+Thread.currentThread().getName()); 
	        for(int i=1;i<5;i++)  
	        {    
	            try  
	            {  
	                Thread.sleep(500);  
	            }catch(InterruptedException e){System.out.println(e);}    
	            System.out.println(i);    
	        }  
	    }    
	      
	         
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
		Thread.currentThread().setName("Java");
		System.out.println(Thread.currentThread().getName());
		PriorityCheck p1 = new PriorityCheck();
		PriorityCheck p2 = new PriorityCheck();
		PriorityCheck p3 = new PriorityCheck();
		Thread t1 = new Thread(p1, "First");
		t1.setPriority(Thread.NORM_PRIORITY);
		Thread t2 = new Thread(p2,"Second");
		t2.setPriority(Thread.MIN_PRIORITY);
		Thread t3 = new Thread(p3,"Third");
		t3.setPriority(Thread.MAX_PRIORITY);
		
		
		ThreadFunctionalities tf=new ThreadFunctionalities();
//		Thread t=new Thread();
		tf.start();
		try {
			tf.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tf.setName("java");
		for(int i=1;i<=5;++i){
			System.out.println("Inside main thread : "+i);
			// Control passes to child thread  
			t1.yield();  
            System.out.println(Thread.currentThread().getName() + " in control"); 
		}
		// creating two threads  
//        JavaGetPriorityExp t1 = new JavaGetPriorityExp();    
//        JavaGetPriorityExp t2 = new JavaGetPriorityExp();    
        // print the default priority value of thread  
        System.out.println("t1 get thread priority : " + t1.getPriority());   
        System.out.println("t2 get thread priority : " + t2.getPriority());  
        // this will call the run() method  
//        for (int i=0; i<3; i++)  
//        {  
            // Control passes to child thread  
//            t1.yield();  
//            System.out.println(Thread.currentThread().getName() + " in control");  
//        }  
        t1.start();    
        t2.start(); 
        t3.start();
		
	}

	}


