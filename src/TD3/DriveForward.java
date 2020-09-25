package TD3;

import lejos.hardware.motor.Motor;
import lejos.robotics.subsumption.Behavior;

public class DriveForward implements Behavior {

	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		Motor.B.forward();
		Motor.C.forward();
	}

	@Override
	public void suppress() {
		Motor.B.stop(true);
		Motor.C.stop(true);
	}

}
