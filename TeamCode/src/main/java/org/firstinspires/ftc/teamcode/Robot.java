package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.*;


/**
 * This is a hardware class, NOT an OpMode
 * 
 * Naming and Coding Conventions
 * ==================
 * 1. All HardwareMap refernces will use lowerCamelCase without underscores between words
 * 2. When calling the same method on a component that has left and right variants, work on the left one first,
 *    this makes the code easier to read.
 *      ie: Initialize the left drive motor then the right drive motor.
 */
public class Robot {
    
    /*
     * Drivetrain components
     */
    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;

    /*
     * Arm components
     */
    public DcMotor arm = null;
    public Servo leftClaw = null;
    public Servo rightClaw = null;

    HardwareMap hwdMap = null;

    /*
     * CONSTANTS
     */
    public static final double CLAW_HOME = 0.0;
    public static final double CLAW_SPEED = 0.5;

    // Default Constructor
    public Robot() {}

    public void init(HardwareMap ahwdMap) {
        // Save ref to HardwareMap
        HardwareMap hwMap = ahwdMap;

        // Init components
        leftDrive = hwdMap.get(DcMotor.class, "leftDrive");
        rightDrive = hwdMap.get(DcMotor.class, "rightDrive");
        arm = hwdMap.get(DcMotor.class, "arm");
        leftClaw = hwdMap.get(Servo.class, "leftClaw");
        rightClaw = hwdMap.get(Servo.class, "rightClaw");

        // Reverse the direction of the left drive motor
        leftDrive.setDirection(DcMotor.Direction.REVERSE);

        // Zero out motor power
        leftDrive.setPower(0);
        rightDrive.setPower(0);

        // Don't use encoders
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Set servo positions
        leftClaw.setPosition(CLAW_HOME);
        rightClaw.setPosition(CLAW_HOME);
    }
}