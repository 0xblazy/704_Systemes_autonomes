package TD3;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class BumperCar {

	public static void main(String[] args) {
		EV3TouchSensor touchSensor = new EV3TouchSensor(SensorPort.S1);
		float[] sample = new float[] {0};
		
		Behavior driveForward = new DriveForward(); // Avancer
		Behavior hitWall = new HitWall(touchSensor, sample); // Contourner
		Behavior arreter = new Arreter(touchSensor); // Arreter
		Behavior batterie = new CompBatt(20, touchSensor); // Batterie
		
		Behavior[] behaviors = {
				driveForward,
				hitWall,
				arreter,
				batterie
			};
		
		Arbitrator arby = new Arbitrator(behaviors);
		((Arreter) arreter).setArby(arby);
		((CompBatt) batterie).setArby(arby);
		arby.go();
	}

}
