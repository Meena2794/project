package Practicedatdriventesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {
public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	//step1:parse json physical object using JsonParse class
	JSONParser parser= new JSONParser();
	Object obj = parser.parse(new FileReader("C:\\Users\\admin\\eclipse-workspace\\SeliniumCRMGUIframework\\src\\test\\resources\\AppcommonData.Json"));
	//step2:convertJson object using downcasting
     JSONObject map =(JSONObject)obj;
     //step3: get the value from json file
     System.out.println(map.get("Browser"));
     System.out.println(map.get("Url"));
     System.out.println(map.get("Username"));
     System.out.println(map.get("Password"));
}
}
