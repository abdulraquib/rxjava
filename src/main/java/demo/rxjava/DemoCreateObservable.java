package demo.rxjava;

import java.util.Arrays;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * This is useful for creating custom Obervables
 * @author spaceman
 *
 */
public class DemoCreateObservable {
	
	public static void demoCreate() {
		String[] monthArray = {"Jan","Feb","Mar","Apr","May","June"};
		List<String> months = Arrays.asList(monthArray);
		
		//public static <T> Observable<T> create(ObservableOnSubscribe<T> source)
		Observable observable =  Observable.create(subscriber ->{
			try {
				for(String data:months) {
					subscriber.onNext(data);
				}
				
				subscriber.onComplete();
				
			}catch(Exception ex) {
				subscriber.onError(ex);
			}
			
		});
		
		observable.subscribe(t -> System.out.println("On Next called " + t)
				, t -> System.out.println("On Error called " + t),()-> System.out.println(" Action completed"));


		observable =  Observable.create(subscriber ->{
			try {
				for(int i=0;i<100;i++) {
					subscriber.onNext(i);
				}
				
				subscriber.onComplete();
				
			}catch(Exception ex) {
				subscriber.onError(ex);
			}
			
		});

		observable.subscribe(t -> System.out.println("On Next called " + t)
				, t -> System.out.println("On Error called " + t),()-> System.out.println(" Action completed"));

		
			
	}

	public static void main(String[] args) {
		demoCreate();

	}

}
