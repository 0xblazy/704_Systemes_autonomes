package TD1;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;

public class Ex6 {

	public static void main(String[] args) {
		EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S3);
		
		LCD.drawString("Appuyez à droite pour activer le capteur couleur", 0, 0);
		LCD.refresh();
		Button.RIGHT.waitForPressAndRelease();
		LCD.clear();
		
		int i;
		for (i = 0 ; i < 10 ; i++) {
			String color = Ex6.getColor(colorSensor.getColorID());
			
			LCD.drawString("Color : " + color, 0, 2);
			LCD.scroll();
			LCD.refresh();
			
			Button.RIGHT.waitForPressAndRelease();
		}
		
		LCD.drawString("Fin du programme", 0, 6);
		LCD.refresh();
		
		Button.ESCAPE.waitForPressAndRelease();
		colorSensor.close();
		LCD.clear();
	}
	
	public static String getColor(int _colorID) {
		switch (_colorID) {
			case Color.BLACK:
				return "Black";
			case Color.BLUE:
				return "Blue";
			case Color.BROWN:
				return "Brown";
			case Color.CYAN:
				return "Cyan";
			case Color.DARK_GRAY:
				return "Dark gray";
			case Color.GRAY:
				return "Gray";
			case Color.GREEN:
				return "Green";
			case Color.LIGHT_GRAY:
				return "Light gray";
			case Color.MAGENTA:
				return "Magenta";
			case Color.NONE:
				return "N/A";
			case Color.ORANGE:
				return "Orange";
			case Color.PINK:
				return "Pink";
			case Color.RED:
				return "Red";
			case Color.WHITE:
				return "White";
			case Color.YELLOW:
				return "Yellow";
			default:
				return "N/A";
		}
	}
	
}
