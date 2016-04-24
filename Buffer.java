n/*
 * @author Yitong Dai
 * @date 3/15/2015
 */
package comp3220_hw6;

public class Buffer {
     private int writerCheck;
     private int readerCheck;
     public Buffer(){
    	 this.writerCheck = 1;//the name is writerCheck but it performs like a lock for reader
    	 this.readerCheck = 1;//the name is readerCheck but it performs like a lock for writer
     }
     /*
      * @param numberOftask it's the number of task
      * @function simulate the function of reading data from buffer
      */
	 public void readBuffer(int numberOftask) throws InterruptedException{
		 synchronized(this){
		    while(writerCheck == 0){/*check reader's lock if it's locked then wait. 
		    If there is an active writer reader's door will be locked. This is why variable's name is writerCheck*/
    		  wait();
    	    }
    	    readerCheck--;//when reader is active reader will close the entrance of writer
		 }
    	 System.out.println("start of read " + numberOftask);
         Thread.sleep(4000);//reading data from buffer will last for 4 seconds
    	 System.out.println("end of read " + numberOftask);
    	 synchronized(this){
    	    readerCheck++;//open the entrance of writer
    	    notifyAll();//activate waiting threads in queue
    	 }
     }
	 /*
      * @param numberOftask it's the number of task
      * @function simulate the function of writing data to buffer
      */
     public synchronized void writeBuffer(int numberOftask) throws InterruptedException{
    	 while(readerCheck != 1){//check writer's lock. 
    		wait();
    	 }
    	 writerCheck--;//when writer is active writer will close the entrance of reader
    	 System.out.println("start of write " + numberOftask);
    	 Thread.sleep(4000);//writing data to buffer will last for 4 seconds
    	 System.out.println("end of wirte " + numberOftask);
    	 writerCheck++;//open the entrance of reader
    	 notifyAll();
     }
}
