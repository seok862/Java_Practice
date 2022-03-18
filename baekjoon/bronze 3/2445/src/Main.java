import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 1; i<=n; i++) {
			for (int j=1; j<=i; j++) {
				System.out.print("*");
			}
			for (int k=1; k<=2*(n-i); k++) {
				System.out.print(" ");
			}
			for (int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = n-1; i>0; i--) {
			for (int j=1; j<=i; j++) {
				System.out.print("*");
			}
			for (int k=1; k<=2*(n-i); k++) {
				System.out.print(" ");
			}
			for (int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
