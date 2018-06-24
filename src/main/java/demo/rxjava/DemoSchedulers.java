package demo.rxjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class DemoSchedulers {
	
	public static void main(String args[]) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		Observable.interval(100, TimeUnit.MICROSECONDS, Schedulers.from(executor))
		.take(10)
		.forEach(item -> System.out.println(Thread.currentThread().getName() + " Emitted " + item));
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException ex) {
		  ex.printStackTrace();
		}
	}

}
