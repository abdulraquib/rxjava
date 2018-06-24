package demo.rxjava;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class DemoRxOperators {
	
	public static void main(String args[]) {

		Observable<Integer> observable = Observable.range(1, 5);
		
		System.out.println("----- Without Operator -----");
		observable.subscribe(item -> System.out.println("Emitted " + item + " items"));
		
		System.out.println("----- With FlatMap Operator -----");
		observable.flatMap(item -> Observable.range(item, 3)).subscribe(item -> System.out.println("Emitted " + item + " items"));
		
		System.out.println("----- With only Map Operator -----");
		Function<Integer,Integer> mapInteger = (a) -> { return a.intValue() + 10;	};
		
		observable.map(mapInteger).subscribe(item -> System.out.println("Emitted " + item + " items"));

		System.out.println("----- With Filter Operator -----");
		Predicate<Integer> condition = (a) -> {return a > 11; };
		observable.map(mapInteger).filter(condition).subscribe(item -> System.out.println("Emitted " + item + " items"));
		
	}
}
