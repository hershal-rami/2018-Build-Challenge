package teamWeenis;

import edu.wpi.first.wpilibj.Spark;

public class Wheel implements Runnable {

	private static Spark myWheel;
	private Boolean running = new Boolean(false);
	private XboxController xbox; //= new XboxController(0);;

	public Wheel(int portNumber) {
		myWheel = new Spark(portNumber);
		xbox = new XboxController(0);
	}

	public void startWheel() {
		synchronized (running) {
			if (running)
				return;
			running = true;
		}
		new Thread(this, "driveThread").start();
	}

	@Override
	public void run() {
		while (running) {
			// This sets speed of the motor that mySpark is connected to in percentage
			if (xbox.getSingleButtonPress(1)) {
				myWheel.set(1.0);
			} else if (xbox.getSingleButtonPress(2)) {
				myWheel.set(0.5);
			} else if (xbox.getSingleButtonPress(3)) {
				myWheel.set(0.25);
			} else if (xbox.getSingleButtonPress(4)) {
				myWheel.set(0.0);
			} else if (xbox.getDPad(0)) {
				myWheel.set(myWheel.getSpeed() + 0.1);
			} else if (xbox.getDPad(180)) {
				myWheel.set(myWheel.getSpeed() - 0.1);
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean getRunning() {
		return running;
	}

	public void stop() {
		myWheel.set(0);
		running = false;
	}

	public void summonSatan() {
		// Don't worry about this method
	}
}