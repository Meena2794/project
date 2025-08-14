package collection;

import java.util.HashMap;

public class AddElementToMopS {

	public static void main(String[] args) {
		HashMap map =new HashMap();
		map.put(2, "two");
		map.put(3,"three");
		map.put(4, "four");
		System.out.println(map+"__________print in key and value pair");
		System.out.println(map.containsKey(4)+"_______check where keys is present");
		System.out.println(map.containsValue("four"+"_______________check where value is present"));
		System.out.println(map.isEmpty());
		
		HashMap hs =new HashMap();
		hs.put(1, "one");
		hs.putAll(map);
		System.out.println(hs+"_____________add value from map to hs");
		System.out.println(map.remove(4)+"_____________remove key from map");
		System.out.println(map.remove(2,"two")+"_____________remove key and value from map");
		System.out.println(map.replace(2, "too")+"_____________change value of key from map");
		System.out.println(map.replace(2, "too"," two")+"_____________change old value to new value of key from map");
		map.clear();
		System.out.println(map+"__________remove print in key and value pair");
		System.out.println(hs);
	}

}
