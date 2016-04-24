/*
 * @author Yitong Dai
 * @date 3/15/2015
 */
package comp3220_hw6;

public class Reader extends Thread{
	private Buffer buffer;
    private int numberOftask;
    public Reader(Buffer buffer, int numberOftask){
  	  this.buffer = buffer;
  	  this.numberOftask = numberOftask;
    }
    public void run(){
  	  try{
  	     buffer.readBuffer(numberOftask);
  	  }
  	  catch(InterruptedException e) {}
    }
}
