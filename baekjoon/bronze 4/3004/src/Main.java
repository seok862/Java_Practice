import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if (N%2 == 0) {
			System.out.println((N/2+1)*(N/2+1));
		}
		if (N%2 !=0) {
			System.out.println((N/2+2)*((N/2+2)-1));
		}
	}
}