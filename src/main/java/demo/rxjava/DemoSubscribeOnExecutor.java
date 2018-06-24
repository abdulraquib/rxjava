package demo.rxjava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class DemoSubscribeOnExecutor {
	public static void main(String args[]) {
		
		
		 ExecutorService exec = Executors.newSingleThreadScheduledExecutor();
		// ExecutorService exec = Executors.newFixedThreadPool(10);
		 Scheduler scheduler = Schedulers.from(exec);

		Observable.fromCallable(new Callable() {

			@Override
			public Object call() throws Exception {
				System.out.println("Thread is -" + Thread.currentThread().getName());

				//Thread.sleep(1000);
				Thread.sleep(100);
				System.out.println("Thread is -" + Thread.currentThread().getName());
				return 5;
			}
		}).filter(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) throws Exception {
				System.out.println("Thread is -" + Thread.currentThread().getName());

				return t > 10;
			}
		}).subscribeOn(scheduler).defaultIfEmpty(1).subscribe(new Observer<Integer>() {

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNext(Integer t) {
				// TODO Auto-generated method stub
				System.out.println("Emitted item " + t);
			}

			@Override
			public void onError(Throwable e) {
				System.out.println(e.getMessage());
				
			}

			@Override
			public void onComplete() {
				System.out.println("Sequence completed successfully");
				
			}
			
			
		});

		
		
		
		try {
			//Ensure to shutdown the executor
			exec.shutdown();
			Thread.sleep(5000);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
