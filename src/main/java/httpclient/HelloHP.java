package httpclient;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class HelloHP {

	public static void main(String args[]) throws InterruptedException, BrokenBarrierException {

		CyclicBarrier barrier = new CyclicBarrier(4);
		Party first = new Party(1000, barrier, "PARTY-1");
		Party second = new Party(2000, barrier, "PARTY-2");
		Party third = new Party(3000, barrier, "PARTY-3");
		Party fourth = new Party(8000, barrier, "PARTY-4");

		first.start();
		second.start();
		third.start();
		fourth.start();
		
		Thread.sleep(6000);
		//first.interrupt();
		

		System.out.println(Thread.currentThread().getName() + " has finished");

	}

}

class Party extends Thread {
	private int duration;
	private CyclicBarrier barrier;

	public Party(int duration, CyclicBarrier barrier, String name) {
		super(name);
		this.duration = duration;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			//1
			Thread.sleep(duration);
			System.out.println(Thread.currentThread().getName() + " is calling await()");
			barrier.await();
			System.out.println(Thread.currentThread().getName() + " has started running again");
			
			//2
			Thread.sleep(duration);
			System.out.println(Thread.currentThread().getName() + " is calling await()");
			barrier.await();
			System.out.println(Thread.currentThread().getName() + " has started running again");
			
			
			
		} catch (InterruptedException | BrokenBarrierException e) {
			System.out.println(this.getName());
			e.printStackTrace();
		}
	}
}