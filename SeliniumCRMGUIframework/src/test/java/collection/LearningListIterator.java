package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class LearningListIterator {

	public static void main(String[] args) {
		ArrayList a=new ArrayList();
		a.add("Qspider");
		a.add("tekpyramid");
		a.add("testYantra");
	   ListIterator itr = a.listIterator();
	   while (itr.hasNext()) {
	System.out.println(itr.next()); 
	   }
		System.out.println("before");
	while (itr.hasPrevious()) {
		System.out.println(itr.previous());
	}
	 System.out.println("after");
	   }
	   }


