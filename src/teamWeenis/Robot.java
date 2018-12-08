package teamWeenis;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	Wheel wheel;

	@Override
	public void robotInit() {
	}

	@Override
	public void autonomousInit() {
		wheel = new Wheel(1);
	}

	@Override
	public void autonomousPeriodic() {
	}

	@Override
	public void teleopInit() {

	}

	@Override
	public void teleopPeriodic() {

	}

	@Override
	public void testInit() {

	}

	@Override
	public void testPeriodic() {

	}

	@Override
	public void disabledInit() {
		wheel.stop();
	}

	@Override
	public void disabledPeriodic() {
		wheel.stop();
	}
}
