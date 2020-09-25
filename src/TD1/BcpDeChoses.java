package TD1;
import lejos.hardware.motor.*;
import lejos.hardware.Button; 
public class BcpDeChoses { 
    public static void main(String[] args) { 
        // TODO Auto-generated method stub 
        Button.waitForAnyPress();
        System.out.println("Das mes ras"); 
        Motor.A.setSpeed(60);
        int i = 0;
        int j = 0;
        while (j < 3) {
        if (i==0) {
        	Motor.A.forward();
        	try {
        	Thread.sleep(1000);
        	i = 1;
  		    Motor.A.stop();
        	} catch (InterruptedException e) {
    		e.printStackTrace();
        	} 
        } else { 
        	Motor.A.backward();
        	try {
            	Thread.sleep(1000);
            	i = 0;
      		    Motor.A.stop();
            	} catch (InterruptedException e) {
        		e.printStackTrace();
            	}
        }
        j++;
        }
        }
    }
   

//        for (int i = 0; i < 360; i+=50) {
//        	Motor.B.forward();
//        	Motor.C.forward();
//        	try {
//		Thread.sleep(5000);
//		Motor.B.stop();
//        	Motor.C.stop();
//        	Motor.B.rotateTo(i);
//	} catch (InterruptedException e) {
//		e.printStackTrace();
//	} 
//      
//        Motor.B.setAcceleration(10);
//        Motor.C.setAcceleration(10);
//        Motor.B.setSpeed(360);
//        Motor.C.setSpeed(360);
//        Motor.B.forward();
// 	    Motor.C.forward();
//        try {
//        	Thread.sleep(10000);
//    		Motor.B.stop();
