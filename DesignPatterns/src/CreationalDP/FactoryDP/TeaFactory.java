package CreationalDP.FactoryDP;

import java.util.Scanner;

public class TeaFactory {
	private static Bevarage bevarage;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			factory().order();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
	}
	public static Bevarage factory() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Select tea to order");
		System.out.println("1.Normal Tea\n2.Black Tea\n3.Green Tea\n4.Ice Tea");
		int choice=scanner.nextInt();
		scanner.close();
		switch(choice) {
		case 1:
			bevarage=new NormalTea();
			break;
		case 2:
			bevarage=new BlackTea();
			break;
		case 3:
			bevarage=new GreenTea();
			break;
		case 4: 
			bevarage=new IceTEa();
			break;
		default:
			System.out.println("Invalid choice");
			System.out.println("No Tea Ordered");
		}
		return bevarage;
	}
}