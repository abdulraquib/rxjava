package demo.rxjava;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;

public class DemoCallable {

	public static void main(String args[]) {

		Observable.fromCallable(new Callable() {

			@Override
			public Object call() throws Exception {
				System.out.println("Thread is -" + Thread.currentThread().getName());

				Thread.sleep(1000);
				System.out.println("Thread is -" + Thread.currentThread().getName());
				return 5;
			}
		}).filter(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) throws Exception {
				System.out.println("Thread is -" + Thread.currentThread().getName());

				return t > 10;
			}
		}).defaultIfEmpty(1).subscribe(new Observer<Integer>() {

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

	}

}
