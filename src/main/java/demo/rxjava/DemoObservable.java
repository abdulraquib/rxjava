package demo.rxjava;

import io.reactivex.Observable;
//import io.reactivex.functions.Consumer;

/**
 * @author spaceman
 *
 */
public class DemoObservable {

	public static void main(String[] args) {
		Observable<String> observable = Observable.just("Hello to the world of RxJava");
		observable.subscribe(s->System.out.println(s));

	}

}
