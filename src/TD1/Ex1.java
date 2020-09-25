package TD1;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;

public class Ex1 {

	public static void main(String[] args) {
		LCD.drawString("Bonjour Madame/Monsieur", 0, 0); 
        Button.waitForAnyPress(); 
	}

}
