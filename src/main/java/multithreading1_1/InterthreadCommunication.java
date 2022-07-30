package multithreading;

class Customer {
	public double balance = 10000;

	public synchronized void withdraw(double wamount) {
		//wamount=5500;
		if (balance >= wamount) {
			balance -= wamount;
			System.out.println("Sucessfully withdrawn and your current balance is : " + balance);
		} else {
			System.out.println("Insufficient balance! you can only proceed if the balance sufficient : ");
		}
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		balance -= wamount;
		System.out.println("Sucessfully withdrawn and your current balance is : " + balance);
	}



	public synchronized void deposit(double damount) {
		System.out.println("previous you have balance is : " + balance);
		balance += damount;
		System.out.println("current/updated balance : " + balance);
		System.out.println("Deposited sucessfully...");
		notify();
	}
}
	public class InterthreadCommunication {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			final Customer c = new Customer();
			Thread t1 = new Thread() {
				public void run() {
					System.out.println("enter the money you want to add : 10000");
					c.deposit(10000);
				}
			};
			t1.start();
//			Thread t2 = new Thread() {
//				public void run() {
//					c.deposit(10000);
//				}
//			};
//			t2.start();
//			Thread t3 = new Thread() {
//				public void run() {
//					c.deposit(10000);
//				}
//			};
			Thread t3 = new Thread() {
				public void run() {
					System.out.println("enter the money you want to withdraw : 5500");
					c.withdraw(5500);
				}
			};
			t3.start();
			Thread t = new Thread() {
				public void run() {
			c.withdraw(5500);
		}
	};

		}

	}

