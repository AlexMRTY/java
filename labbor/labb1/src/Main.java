
public class Main {
	
	public static void main(String[] args) {
		
		ElevatorLogic e = new ElevatorLogic(5);
		System.out.println(e.toString());

		e.callForUp(4);
		e.moveToNextFloor();
//		System.out.println(e);
		e.selectFloor(1);
		e.moveToNextFloor();
//		e.callForDown(1);
//		e.callForDown(4);
		System.out.println(e);

		while(e.moveToNextFloor()) {
			System.out.println(e);
		}



	}
}
