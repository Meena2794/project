package Practicedatdriventesting;

import java.util.Random;

public class GenerateRandomNumberTest {
	public static void main(String[] args) {
	Random ran=new Random();
	int randomInt=ran.nextInt();
	System.out.println(randomInt);
	}

}
