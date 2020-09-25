package TD1;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;

public class Muscu {

	public static void main(String[] args) {
		LCD.drawString("Appuyez pour demarrer la muscu", 0, 0);
		Button.waitForAnyPress();
		
		// Speed
		Motor.A.setSpeed(180);
		
		// Dancing
		int pressed = 0;
		boolean forward = true;
		while (pressed == 0) {
			Muscu.doStep(forward);
			forward = !forward;
			pressed = Button.waitForAnyPress(400);
		}
		
		//Stop
		Motor.A.stop(true);
		LCD.drawString("Muscu terminee", 0, 0);
		Button.waitForAnyPress();
	}
	
	private static void doStep(boolean _forward) {
		if (_forward) { // Forward
			Motor.A.forward();
		} else { // Backward
			Motor.A.backward();
		}
	}

}
