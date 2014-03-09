
public class Philosophers extends Thread{
	private Integer chopstickleft;
	private Integer chopstickright;
	private int seatPosition;
	
	public Philosophers(Integer seatPosition, Integer chopstickleft, Integer chopstickright){
		this.seatPosition=seatPosition;
		this.chopstickleft=chopstickleft;
		this.chopstickright=chopstickright;
	}
	
	@Override
	public void run(){
		while(true){//busy waiting on access to both chopsticks
		synchronized(chopstickleft){
			System.out.println("Philospher at seat "+seatPosition+" picked up left chopstick #"+chopstickleft);
			synchronized(chopstickright){
				System.out.println("Philospher at seat "+seatPosition+" picked up left chopstick #"+chopstickright);
			}
		}
		}
	}
}
