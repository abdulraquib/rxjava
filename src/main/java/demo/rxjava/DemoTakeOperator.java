package demo.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DemoTakeOperator {

	public static void main(String[] args) {
		Observable<Integer> observable = Observable.range(10, 9);
		

	
		Observer<Integer> observer = new Observer<Integer>() {
				
				public void onComplete() {
					System.out.println("On Complete called");
				}
				
				public void onError(Throwable t) {
					t.printStackTrace();
				}
				
				public void onNext(Integer value) {
					System.out.println("On Next called " + value +"\n");
				}
				
				public void onSubscribe(Disposable disposable) {
					System.out.println("On onSubscribe called " + disposable.isDisposed());
				}
			};
			
			observable.take(3).count().subscribe(item -> System.out.println("Emitted " + item + " items"));
			observable.take(3).subscribe(observer);
			observable.take(3).subscribe(item -> System.out.println("Emitted " + item + " items"));

			
		}
	
}
