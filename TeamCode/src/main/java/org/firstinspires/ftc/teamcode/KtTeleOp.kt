package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp

/**
 * Created by KasaiYuki on 9/20/2018.
 */

@TeleOp(name="KtTeleOp", group="TeleOp")
//@Disabled
class KtTeleOp : OpMode()
{
    //using robot class for motors, servos etc
    val robot = KtRobot()
    var slowDown = 1.25//default
    override fun init()
    {
        telemetry.addData("Status", "Initialized")
        telemetry.update()
        //initializes all parts
        robot.init(hardwareMap)
        robot.tokenServo?.position = 0.9

    }

    override fun loop()
    {
        slowDown = if(gamepad1.left_bumper) 2.0 else 1.25 //condensed if else
        //Tank Drive
        var leftPower: Float = -gamepad1.left_stick_y
        var rightPower: Float = -gamepad1.right_stick_y
        var slidePower: Float = -gamepad2.left_stick_y

        robot.leftDrive?.power = leftPower.toDouble() / slowDown
        robot.rightDrive?.power = rightPower.toDouble() / slowDown
        robot.lSlideArm?.power = slidePower.toDouble() //Option 2: use joystick for slide
        //robot.armMot?.power = extPower.toDouble()
        robot.spinServo(gamepad2)

        /*      try {
                  if (gamepad2.a)
                      robot.dropToken()
                  else (gamepad2.b)
                      robot.liftToken()

              }
              catch (e: Exception) {
                  telemetry.addData("Error in arm!", println(e))
              }*/



        try {
            if(gamepad1.a) {
                robot.liftRobot(10.0)
            }
/*            else
                robot.liftRobot(0.0)*/
        }
        catch (e: Exception) {
            telemetry.addData("Error in Linear Slide going up!", println(e))
        }

        try {
            if(gamepad1.b) {
                robot.liftRobot(-10.0)
            }
            else
                robot.liftRobot(0.0)
        }
        catch (e: Exception) {
            telemetry.addData("Error in Linear Slide going down!", println(e))
        }

        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower)
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower)
        telemetry.addData("Arm Motor", " (%.2f)", -gamepad2.left_stick_y)
        telemetry.addData("Servo", robot.tokenServo?.position)
    }

    override fun stop()
    {

    }

/*  //Will close the arm to different positions based on what is being grabbed
    private fun spinServo() {
        if (gamepad2.left_bumper) {
            tokenServo?.position = 0.25 //Sphere
        } else if (gamepad2.right_bumper) {
            tokenServo?.position = 0.45 //Cube
        } else {
            tokenServo?.position = 0.0 }
    }*/
}