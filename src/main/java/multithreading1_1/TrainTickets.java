package multithreading;

class BookingTickets {
	public double seats = 100;

	public synchronized void bookSeats(double wamount) {
		
		System.out.println("Currently number of seats available is : " + seats);
		seats -= wamount;
		System.out.println("updated: Number of seats available is " + seats);
		System.out.println("You Booked your tickets sucessfully...");
		notify();
	}

	public synchronized void cancelSeats(double damount){
		
		if (seats >= damount) {
			seats += damount;
			System.out.println("cancelled seats sucessfully : " + seats);
		} else {
			System.out.println("no seats available! if someone cancels their reservation then only we can allocate that seats to you : ");
		}
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		seats += damount;
		System.out.println("Sucessfully booked seats and available seats are : " + seats);
	}
	}


public class TrainTickets {

	public static void main(String[] args) {
		final BookingTickets c = new BookingTickets();
		Thread t1 = new Thread() {
			public void run() {
				
				System.out.println("enter the number of seats you want to book : 10");
				
				
				c.bookSeats(10);
			}
		};
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Thread t2 = new Thread() {
//			public void run() {
//				c.bookSeats(100);
//			}
//		};
//		t2.start();
		Thread t2 = new Thread() {
			public void run() {
				System.out.println("enter the number of seats you want to cancel : 10");
				//System.out.println(Thread.currentThread().getName());
				c.cancelSeats(10);
			}
		};
		t2.start();
//		Thread t = new Thread() {
//			public void run() {
//		c.withdraw(5500);
//	}
//};

	}

}
