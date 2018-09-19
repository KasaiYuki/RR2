package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="IterativeOpMode", group="TeleOp")
// @Disabled
public class IterativeOpMode extends OpMode {

    // Declare Members
    Robot robot = new Robot(); // Use the Robot hardware class

    // Called ONCE when the INIT button is pressed on DriverStation
    @Override
    public void init() {
        // Call the Robot's init() method. All the work is done the Robot class :)
        robot.init(hardwareMap);

        telemetry.addData("Status", "Initialized");
    }

    // Called REPEATEDLY when the INIT button is pressed but before the PLAY button is pressed
    @Override
    public void init_loop() {

    }

    // Called ONCE when the PLAY button is pressed
    @Override
    public void start() {

    }

    // Called REPEATEDLY when the PLAY button is pressed but before the STOP button is pressed
    @Override
    public void loop() {
        // Setup a variable for each drive wheel to save power level for telemetry
        double leftPower;
        double rightPower;

        // Choose to drive using either Tank Mode, or POV Mode
        // Comment out the method that's not used.  The default below is POV.

        // POV Mode uses left stick to go forward, and right stick to turn.
        // - This uses basic math to combine motions and is easier to drive straight.
        double drive = -gamepad1.left_stick_y;
        double turn  =  gamepad1.right_stick_x;
        leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
        rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

        // Tank Mode uses one stick to control each wheel.
        // - This requires no math, but it is hard to drive forward slowly and keep straight.
        // leftPower  = -gamepad1.left_stick_y ;
        // rightPower = -gamepad1.right_stick_y ;

        // Send calculated power to wheels
        robot.leftDrive.setPower(leftPower);
        robot.rightDrive.setPower(rightPower);

        // Show the wheel power.
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
    }

    // Called when the STOP button is pressed
    @Override
    public void stop() {

    }

}