package demo.rxjava;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DemoForEachLamda {

	public static void main(String[] args) {
		/*
        List<Student> list = new ArrayList();
        list.add(new DemoForEachLamda.Student("Ram",20));
        list.add(new DemoForEachLamda.Student("Shyam",22));
        list.add(new DemoForEachLamda.Student("Kabir",18));
        //Creating instance of Consumer functional interface
        Consumer<Student> style = (Student s) -> System.out.println("Name:"+s.name +" and Age:"+s.age);
        //first way using Consumer
        list.forEach(style);
        //second way using method reference 
        list.forEach(Student::printData);
        //third way using lambda expression
        list.forEach(s -> s.printData());
        */
   }

	class Student {
	    public String name;
	    public int age;
	    public Student(String name,int age){
	        this.name = name;
	        this.age = age;
	    }
	    public void printData(){
	        System.out.println("Name:"+name + " age:"+age);
	    }
	} 
}


