package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp

/**
 * Created by KasaiYuki on 11/14/2018.
 */

@TeleOp(name="NEWTeleOp", group="TeleOp")

class NEWKtTeleOp : OpMode()
{
    val robot = KtRobot()

    override fun init() {
        telemetry.addData("Status", "Initialized")
        telemetry.update()
        //initializes all parts
        robot.init(hardwareMap)
        robot.armServo?.position = 0.8
    }

    override fun loop()
    {
        //Tank Drive
        var leftPower: Float = -gamepad1.left_stick_y
        var rightPower: Float = -gamepad1.right_stick_y
        var armPower: Float = -gamepad2.left_stick_y
        var extPower: Float = -gamepad2.right_stick_y

        robot.leftDrive?.power = leftPower.toDouble()
        robot.rightDrive?.power = rightPower.toDouble()
        robot.extArm?.power = armPower.toDouble()
        robot.extArm?.power = extPower.toDouble()
        robot.spinServo(gamepad2)

/*        try {
            if (gamepad2.a)
                robot.dropToken()
            else
                robot.liftToken()

        }
        catch (e: Exception) {
            telemetry.addData("Error in arm!", println(e))
        }*/

        try {
            if(gamepad1.a) {
                robot.liftRobot(10.0)
            }
            else
                robot.liftRobot(0.0)
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
        telemetry.addData("Servo", robot.armServo?.position)
    }

    override fun stop()
    {

    }

/*  //Will close the arm to different positions based on what is being grabbed
    private fun spinServo() {
        if (gamepad2.left_bumper) {
            armServo?.position = 0.25 //Sphere
        } else if (gamepad2.right_bumper) {
            armServo?.position = 0.45 //Cube
        } else {
            armServo?.position = 0.0 }
    }*/
}
