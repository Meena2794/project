package Practicedatdriventesting;

public class GenerateAlphaNumericRandomData {
public static void main(String[] args) {
	int n=20;
	String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
	StringBuilder sb=new StringBuilder(n);
	for (int i = 0; i <n; i++) {
		int index=(int)(alphaNumericString.length()*Math.random());
		sb.append(alphaNumericString.charAt(index));
	}
	System.out.println(sb);
}
}
