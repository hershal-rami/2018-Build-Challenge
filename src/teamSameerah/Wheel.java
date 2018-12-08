package teamSameerah;

import edu.wpi.first.wpilibj.Spark;

public class Wheel implements Runnable {
	
	private Spark Wheel;

	@SuppressWarnings("deprecation")
	
	private Boolean running = new Boolean(false);
	
	Wheel(int channel) {
		Wheel = new Spark(channel);
	}
	
	public void startWheel() {
		synchronized(running) {
			if (running) {
				return;
			}
			running = true;
		}
		new Thread(this, "wheelThread").start();
	}
	
	public void run() {
		while (running) {
			Wheel.set(1);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stop() {
		Wheel.set(0);
		running = false;
	}
	
	public boolean getRunning() {
		return running;
	}
	
}