import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;


public class Philosophers extends Thread{
	private Integer chopstickleft;
	private Integer chopstickright;
	private int seatPosition;
	Writer writer;
	
	public Philosophers(Integer seatPosition, Integer chopstickright, Integer chopstickleft){
		this.seatPosition=seatPosition;
		this.chopstickleft=chopstickleft;
		this.chopstickright=chopstickright;
		try {
			writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("phillog.txt"),"utf-8"));
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run(){
		while(true){//busy waiting on access to both chopsticks
		synchronized(chopstickright){
			System.out.println("Philospher at seat "+seatPosition+" picked up right chopstick #"+chopstickleft);
			try {
				writer.write("Philospher at seat "+seatPosition+" picked up right chopstick #"+chopstickleft);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(chopstickleft){
				System.out.println("Philospher at seat "+seatPosition+" picked up left chopstick #"+chopstickright);
				try {
					writer.write("Philospher at seat "+seatPosition+" picked up left chopstick #"+chopstickleft);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		}
	}
}
