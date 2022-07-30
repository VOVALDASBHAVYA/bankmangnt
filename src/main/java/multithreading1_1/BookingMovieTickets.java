package multithreading;

public class BookingMovieTickets {
	public static void main(String[] args) {
	
		final MovieTickets c = new MovieTickets();
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
			e.printStackTrace();
		}
//	
		Thread t2 = new Thread() {
			public void run() {
				System.out.println("enter the number of seats you want to cancel : 10");
				//System.out.println(Thread.currentThread().getName());
				c.cancelSeats(10);
			}
		};
		t2.start();

	}

}

class MovieTickets {
	public double seats = 100;

	public synchronized void bookSeats(double wamount) {
		
		System.out.println("Currently number of seats available is : " + seats);
		seats -= wamount;
	
		System.out.println("Your movie tickets booked sucessfully...");
		System.out.println("----------------------------------------");
		System.out.println("updated: Number of seats available is " + seats);
		notify();
	}

	public synchronized void cancelSeats(double damount){
		
		if (seats >= damount) {
			seats += damount;
			
			System.out.println("cancelled seats sucessfully and number of seats avilable is: " + seats);
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
		System.out.println("Sucessfully movie tickets booked and available seats are : " + seats);
	}
	}



	
