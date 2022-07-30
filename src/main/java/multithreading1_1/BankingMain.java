package multithreading;

import java.util.*;
public class BankingMain {
   public static final int a_maxi = 10; // number of accounts
   public static long[] balance = new long[a_maxi];
   public static Random r_number;
   private static final int t_maxi = 5; // number of threads
   private static BankingThread[] t_list = new BankingThread[t_maxi];
   private static long t_step;
   private static Object o_lock;
   private static Object[] a_lock = new Object[a_maxi];
   public static void main(String[] a) {
      o_lock = new Object();
      for (int i=0; i<a_maxi; i++) a_lock[i] = new Object();
      t_step = 1; // using doTransaction1();
      System.out.println("No synchronization:");
      testATM();
      printResult();
      t_step = 2; // using doTransaction2();
      System.out.println("Synchronized method:");
      testATM();
      printResult();
      t_step = 3; // using doTransaction3();
      System.out.println("Synchronized statements:");
      testATM();
      printResult();
      t_step = 4; // using doTransaction4();
      System.out.println("Synchronized statements per account:");
      testATM();
      printResult();
   }
   private static void testATM() {
      for (int i=0; i<a_maxi; i++) balance[i] = 0;
      r_number = new Random();
      ThreadGroup g = new ThreadGroup("ATM");
      for (int i=0; i<t_maxi; i++) {
         BankingThread t = new BankingThread(g,String.valueOf(i));
         t.start();
         t_list[i] = t;
      }
      try {
         Thread.sleep(5*1000); // working period
      } catch (InterruptedException e) {
         System.out.println("Interrupted in the mainthread.");
      }
      g.interrupt();
      while (g.activeCount()>0); // wait for all threads to end
   }
   private static void printResult() {
      System.out.print("Account");
      for (int i=0; i<t_maxi; i++)
         System.out.print(", ATM "+i);
      System.out.print(", Transaction Sum, Balance");
      for (int j=0; j<a_maxi; j++) {
         System.out.print("\n"+j);
         long sum = 0;
         for (int i=0; i<t_maxi; i++) {
            sum += t_list[i].getBalance(j);
            System.out.print(", "
               +getCurrency(t_list[i].getBalance(j)));
         }
         System.out.print(", "+getCurrency(sum)+
            ", "+getCurrency(balance[j]));
      }
      System.out.print("\n# of Transactions");
      for (int i=0; i<t_maxi; i++)
         System.out.print(", "+t_list[i].transactionCount());
      System.out.print("\n");
   }
   private static String getCurrency(long d) {
      long i = d/100;
      long f = Math.abs(d)%100;
      String fs = String.valueOf(f);
      if (f<10) fs = "0"+fs;
      return String.valueOf(i)+"."+fs;
   }
   public static long getStep() {
      return t_step;
   }
   public static int accountCount() {
      return a_maxi;
   }
   public static Random getRandom() {
      return r_number;
   }
   public static long getBalance(int i) {
      return balance[i];
   }
   public static boolean doTransaction1(int i, long a) {
      boolean ok = false;
      long c = balance[i]; // get current balance
      ok = c+a>0;
      if (ok) { // stop accout balance going negative
         try {
            Thread.sleep(1); // slow down the process
         } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // re-set the flag
         }
         balance[i] = c+a; // set current balance
      }
      return ok;
   }
   public synchronized static boolean doTransaction2(int i, long a) {
      boolean ok = false;
      long c = balance[i]; // get current balance
      ok = c+a>0;
      if (ok) { // stop accout balance going negative
         try {
            Thread.sleep(1); // slow down the process
         } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // re-set the flag
         }
         balance[i] = c+a; // set current balance
      }
      return ok;
   }
   public static boolean doTransaction3(int i, long a) {
      boolean ok = false;
      synchronized (o_lock) {
         long c = balance[i]; // get current balance
         ok = c+a>0;
         if (ok) { // stop accout balance going negative
            try {
               Thread.sleep(1); // slow down the process
            } catch (InterruptedException e) {
               Thread.currentThread().interrupt(); // re-set the flag
            }
            balance[i] = c+a; // set current balance
         }
      }
      return ok;
   }
   public static boolean doTransaction4(int i, long a) {
      boolean ok = false;
      synchronized (a_lock[i]) {
         long c = balance[i]; // get current balance
         ok = c+a>0;
         if (ok) { // stop accout balance going negative
            try {
               Thread.sleep(1); // slow down the process
            } catch (InterruptedException e) {
               Thread.currentThread().interrupt(); // re-set the flag
            }
            balance[i] = c+a; // set current balance
         }
      }
      return ok;
   }
}
/*public class InterviewerApplet extends JApplet implements Runnable
{
Declare pannels
...
Declare buttons
...
Declare txetfields
...
Declare textArea
...
Thread datimeThread;

//Declare a date variable

Date date;

//Declare a GregorianCalandar variable
GregorianCalendar calendar;
//Declare String variable to store date,
//time and status bar messages
String strdate, strTime, strStatus;
//init method of applet
public void init()
{
...
createAppletContent();
}
protected void createAppletContent()
{
candidateDetail();
}
public void candidateDetail()
{
...
...
datimeThread = new Thread(this)
// Initialize thread
datimeThread.start();//starting thread
}
public void run()
{
while(datimeThread !=null)
{
display();//This method displays date
try
{
datimeThread.sleep(1000);
}
catch(InterruptedException e)
{
showStatus("Thread interrupted");
}
}//end of while
}//end of run
public void display()
{
date = new Date();
calendar = new GregorianCalendar();
strTime = calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(calendar.SECONDS);
strDate = calendar.get(calendar.MONTH)+"/"+calendar.get(calendar.DATE)+"/"+calendar.get(calendar.YEAR);
strStatus = strTime+" "strDate;
showStatus(strStatus);
}
public void testDetail()
{
....//test details code
}
}//end of program*/