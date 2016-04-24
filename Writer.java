/*
 * @author Yitong Dai
 * @date 3/15/2015
 */
package comp3220_hw6;

public class Writer extends Thread{
      private Buffer buffer;
      private int numberOftask;
      public Writer(Buffer buffer, int numberOftask){
    	  this.buffer = buffer;
    	  this.numberOftask = numberOftask;
      }
      public void run(){
    	  try{
    	     buffer.writeBuffer(numberOftask);
    	  }
    	  catch(InterruptedException e) {}
      }
}
