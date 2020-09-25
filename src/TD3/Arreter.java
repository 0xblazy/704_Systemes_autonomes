package TD3;

import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Arreter implements Behavior {
	
	private EV3TouchSensor touch;
	private Arbitrator arby;
	
	// Constructeur
	public Arreter(EV3TouchSensor _touch) {
		this.touch = _touch;
	}
	
	public void setArby(Arbitrator _arby) {
		this.arby = _arby;
	}

	@Override
	public boolean takeControl(){
		return Button.LEFT.isDown();
	}

	@Override
	public void action() {
		this.touch.close();
		Motor.B.stop(true);
		Motor.C.stop(true);
		
		if (arby != null) {
			arby.stop();
		}
		
		System.exit(0);
	}

	@Override
	public void suppress() {} //okok

}
