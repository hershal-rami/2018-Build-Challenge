package teamWeenis;
import edu.wpi.first.wpilibj.IterativeRobot;


public class Robot extends IterativeRobot {
	
	Wheel wheel = new Wheel(1);
	
	@Override
	public void robotInit() {
		
	}

	@Override
	public void autonomousInit() {
		wheel.startWheel();
	}

	@Override
	public void autonomousPeriodic() {
		// This can be left empty
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
		if(wheel.getRunning()){
			wheel.stop();
		}
	}

	@Override
	public void disabledPeriodic() {
	}
}