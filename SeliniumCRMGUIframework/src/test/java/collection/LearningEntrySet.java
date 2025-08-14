package collection;

import java.util.HashMap;
import java.util.Map.Entry;

public class LearningEntrySet {

	public static void main(String[] args) {
		HashMap<String, Integer> map =new HashMap<String, Integer>();
		map.put("two",2);
		map.put("three",3);
		map.put("four",4);
		System.out.println(map+"__________print in key and value pair");
		for (Entry<String, Integer> hs : map.entrySet()) {
			System.out.println(hs.getKey()+"  "+hs.getValue());
		}
	}

}
