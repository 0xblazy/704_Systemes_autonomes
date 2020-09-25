package TD1;

import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class UltrasonicSensor {

	//Robot Configuration
	private static EV3UltrasonicSensor us1 = new EV3UltrasonicSensor(SensorPort.S4);

	//Configuration
	private static int HALF_SECOND = 500;
//ouiiii
	public static void main(String[] args) throws InterruptedException {

		SampleProvider sp;

		int distanceValue = 3;
        Motor.C.setSpeed(110);
        Motor.B.setSpeed(110);
        sp = us1.getListenMode();
		int sampleSize = sp.sampleSize();
		float[] sample = new float[sampleSize];
		sp.fetchSample(sample, 0);
		Motor.B.forward();
		Motor.C.forward();
		int i=1;
		while(distanceValue > 1) {

			sp.fetchSample(sample, i);

			distanceValue = (int)sample[i];
			i++;

			System.out.println(" Distance: {}" + distanceValue);

			Delay.msDelay(2000);	

	}
		Motor.B.stop();
		Motor.C.stop();
		us1.close();
}
}