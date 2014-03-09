
public class DiningPhilosophers {
	private Object[] chopsticks;
	private Philosophers[] philosophers;
	private Integer numberOfPhilosophers;
	
	public DiningPhilosophers(int numberOfPhilosophers){
		this.numberOfPhilosophers=numberOfPhilosophers;
		chopsticks=new Object[numberOfPhilosophers]; //there are as many forks as philosophers
		philosophers=new Philosophers[numberOfPhilosophers];
		for(int i=0; i<numberOfPhilosophers; i++ ){
			chopsticks[i]=new Object();
			philosophers[i]=new Philosophers(i,i,(i+1)%numberOfPhilosophers); //mod by number of diners to wrap around the table! 5%5=0, right stick of last diner will be 0
		}
	}
	
	public void startEating(){
		for(int i=0; i<philosophers.length; i++){
			philosophers[i].start();
		}
		
		try {
			philosophers[0].join(); //wait for this thread philosopher to finish eating
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //wait for
		}
	}

