package TD1;

import java.util.Random;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;

public class Ex4 {

	public static void main(String[] args) {
		Random rd = new Random();
		LCD.drawString("Appuyez pour demarrer la danse", 0, 0);
		Button.waitForAnyPress();
		
		// Speed
		Motor.B.setSpeed(900);
		Motor.C.setSpeed(900);
		
		// Dancing
		int pressed = 0;
		boolean motorB = true;
		while (pressed == 0) {
			Ex4.doStep(motorB, rd.nextBoolean());
			motorB = !motorB;
			pressed = Button.waitForAnyPress(150);
		}
		
		//Stop
		Motor.B.stop(true);
		Motor.C.stop(true);
		LCD.drawString("Danse terminée", 0, 0);
		Button.waitForAnyPress();
	}
	
	private static void doStep(boolean _motorB, boolean _forward) {
		if (_motorB) { // Motor B
			if (_forward) { // Forward
				Motor.B.forward();
			} else { // Backward
				Motor.B.backward();
			}
		} else { // Motor C
			if (_forward) { // Forward
				Motor.C.forward();
			} else { // Backward
				Motor.C.backward();
			}
		}
	}

}
