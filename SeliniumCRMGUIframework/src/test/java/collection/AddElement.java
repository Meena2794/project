package collection;

import java.util.ArrayList;

public class AddElement {
public static void main(String[] args) {
	ArrayList al =new ArrayList();
	al.add("Madhu");
	al.add(123456);
	al.add(2.0);
	al.add(true);
	al.add(null);
	System.out.println(al+"_____add element to al");
	
	ArrayList a=new ArrayList();
	a.add("Jahnvi");
	a.addAll(al);
	System.out.println(a+"_____addall element of al to a");
	
	
	ArrayList alist=new ArrayList();
	alist.add(10);
	alist.add(20);
	alist.add(30);
	alist.add("testyantra");
	System.out.println(alist+"____________add element to remove");
	alist.remove(0);
	alist.remove(Integer.valueOf(30));
	alist.remove("testyantra");
	System.out.println(alist+"___________remove the element alist");
	alist.removeAll(alist);
	System.out.println(alist+"_____________removeall from alist collection");
	for (int i = 0; i <al.size(); i++) {
		System.out.println(al.get(i)+"___________access the element from al");
	}
	for (Object o : a) {
	System.out.println(o);	
	}
	
	System.out.println(a.get(3)+"_____accessing 4th element of a");
	System.out.println(al.get(5)+"_____accessing 6th element of al");
	System.out.println(a.get(4)+"_____accessing 5th element of a");
	System.out.println(alist.get(1)+"_____accessing 2nd element of alist");
	
	
	
	
}

}
