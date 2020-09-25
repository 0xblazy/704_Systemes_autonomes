package TD3;

import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class HitWall implements Behavior 
{
	private EV3TouchSensor touch; private float[] sample;
	public HitWall(EV3TouchSensor ts, float[] s) {
		this.touch = ts; this.sample = s;	
	}
	public boolean takeControl() {
		touch.fetchSample(sample, 0);
		return sample[0]==1;
	}
	public void suppress() {
		Motor.B.stop(true);
		Motor.C.stop(true);
	}
	public void action() {
		Motor.B.backward();
		Motor.C.backward();
		Delay.msDelay(1000);
		Motor.B.stop(true);
		Delay.msDelay(300);
		Motor.C.stop(true);
	}

}
