
public class DiningPhilosophers {
	private Object[] forks;
	private Philosophers[] philosophers;
	private Integer numberOfPhilosophers=5;
	public void startEating(){
		for(int i=0; i<numberOfPhilosophers; i++ ){
			forks[i]=new Object();
			philosophers[i]=new Philosophers(i,i,(i+1)%numberOfPhilosophers);
		}
		}
	}
}
