package teamSameerah;

import edu.wpi.first.wpilibj.Spark;

public class Wheel implements Runnable {

	private Spark Wheel; // Variables should be camelcase, meaning first word lowercase and the first
							// letter of every other word uppercase. Ex: thisIsAnExample

	@SuppressWarnings("deprecation") // Did your computer add this? Mine works without it
	private Boolean running = new Boolean(false);

	Wheel(int channel) {
		Wheel = new Spark(channel);
		startWheel();
	}

	public void startWheel() {
		synchronized (running) {
			if (running) {
				return;
			}
			running = true;
			// The "new Thread(this...." line should be here
			// Otherwise you're making the thread inside the method thats only run when you make the thread
		}
	}

	public void run() {
		while (running) {
			Wheel.set(1); // Generally we don't run motors at full speed; its too fast. We stay around the 0.5-0.75 area
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			new Thread(this, "wheelThread").start(); // Like I said earlier, move this up to line 24
		}
	}

	public void stop() {
		Wheel.set(0);
	}

	public boolean getRunning() {
		return running;
	}

	// Good job!
}
