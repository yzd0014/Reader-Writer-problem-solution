/*
 * @author Yitong Dai
 * @date 3/15/2015
 */
package comp3220_hw6;

public class Simulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Buffer buffer = new Buffer();
          Writer writer1 = new Writer(buffer, 1);//creat some threads for writer
          Writer writer2 = new Writer(buffer, 2);
          Writer writer3 = new Writer(buffer, 3);
          Writer writer4 = new Writer(buffer, 4);
          
          Reader reader1 = new Reader(buffer, 1);//creat some threads for reader
          Reader reader2 = new Reader(buffer, 2);
          Reader reader3 = new Reader(buffer, 3);
          Reader reader4 = new Reader(buffer, 4);
          
          writer1.start();
          writer2.start();
          writer4.start();  
          reader2.start();
          reader1.start();
          reader3.start();
          writer3.start();
          reader4.start();  
	}

}
