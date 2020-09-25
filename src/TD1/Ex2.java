package TD1;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class Ex2 {

	public static void main(String[] args) {
		LCD.drawString("Appuyez pour démarrer", 0, 0);
		Button.waitForAnyPress();
		
		// Speed
		Motor.B.setSpeed(360);
		Motor.C.setSpeed(360);
		
		// Run
		Motor.B.forward();
		Motor.C.forward();
		
		// Waiting
		Delay.msDelay(5000);
		
		// Stop
		Motor.B.stop(true);
		Motor.C.stop(true);
	}

}
