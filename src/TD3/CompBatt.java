package TD3;

import lejos.hardware.Battery;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import java.lang.Object;

public class CompBatt implements Behavior {
	
	float nb;
	private EV3TouchSensor touch;
	private Arbitrator arby;
	
	public CompBatt (float seuil,EV3TouchSensor _touch) {
		this.nb = seuil;
		this.touch = _touch;
	
	}
	@Override
	public boolean takeControl() {
		if (Battery.getBatteryCurrent() <= this.nb) {
			return false;
			
		} else { 
			return true;
		}
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
	public void suppress() {
		
		
	}

	
	
	
	}
	
	
