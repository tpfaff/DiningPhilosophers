
public class DiningPhilosophers {
	private Object[] chopsticks;
	private Philosophers[] philosophers;
	private int numberOfPhilosophers;
	
	public DiningPhilosophers(int numberOfPhilosophers){
		this.numberOfPhilosophers=numberOfPhilosophers;
		chopsticks=new Object[numberOfPhilosophers]; //there are as many forks as philosophers
		philosophers=new Philosophers[numberOfPhilosophers];
		for(int i=0; i<philosophers.length; ++i){
			chopsticks[i]=new Object();
			if(i==numberOfPhilosophers-1){ //if it's the last philosopher, have him pick up the right fork first!
				Integer right=new Integer(0);
				Integer left=new Integer(4);
				  philosophers[i]=new Philosophers(i,right,left); //mod by number of diners to wrap around the table! 5%5=0, right stick of last diner will be 0

			}else{
				Integer right=new Integer(((i+1)%numberOfPhilosophers));
				Integer left=new Integer((i));
				 philosophers[i]=new Philosophers(i,right,left);
			}
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

