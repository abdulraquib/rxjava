package demo.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.*;

public class DemoRangeObserver {

	public static void main(String[] args) {
		Observable<Long> observable = Observable.rangeLong(11, 31);
		
		Observer<Long> observer = new Observer<Long>() {
			
			public void onComplete() {
				System.out.println("On Complete called");
				
			}
			
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
			public void onNext(Long value) {
				
				System.out.println("On Next called " + value +"\n");
			}
			
			public void onSubscribe(Disposable disposable) {
				
				System.out.println("On onSubscribe called " + disposable.isDisposed());
			}
		};
		
		/*
		observable.subscribe(t -> System.out.println("On Next called " + t), 
				t -> t.printStackTrace(System.out), System.out.println("Done"));
				
		*/		

		Action action = new Action() {
			public void run() {
				System.out.println(" Action completed");
			}
		};

		observable.subscribe(t -> System.out.println("On Next called " + t)
				, t -> t.printStackTrace(System.out),()-> System.out.println(" Action completed"));
		
				
		//observable.subscribe(observer);
	}

}
