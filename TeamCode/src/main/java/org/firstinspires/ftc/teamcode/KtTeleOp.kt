package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.Disabled
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Servo
import com.qualcomm.robotcore.util.ElapsedTime

/**
 * Created by KasaiYuki on 9/20/2018.
 */

@TeleOp(name="KtTeleOp", group="TeleOp")
//@Disabled
class KtTeleOp : OpMode()
{
    //using robot class for motors, servos etc
    val robot = KtRobot()


/*    var extArm: DcMotor? = null
    var armServo: Servo? = null

    var motF = DcMotorSimple.Direction.FORWARD
    var motR = DcMotorSimple.Direction.REVERSE
    var serR = Servo.Direction.REVERSE
    var serF = Servo.Direction.FORWARD*/
    override fun init()
    {
        telemetry.addData("Status", "Initialized")
        telemetry.update()
        //initializes all parts
        robot.init(hardwareMap)
/*        extArm = hardwareMap.dcMotor.get("extArm")
        armServo = hardwareMap.servo.get("armServo")

        extArm?.direction = motF
        armServo?.direction = serF*/
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

        try {
            if (gamepad2.a)
                robot.dropArm()
        }
        catch (e: Exception) {
            telemetry.addData("Error!", println(e))
        }

        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower)
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower)
        telemetry.addData("Arm Motor", " (%.2f)", -gamepad2.left_stick_y)
        telemetry.addData("Servo", robot.armServo?.position)
    }

    override fun stop()
    {

    }

/*    //Will close the armt o different positions based on what is being grabbed
    private fun spinServo() {
        if (gamepad2.left_bumper) {
            armServo?.position = 0.25 //Sphere
        } else if (gamepad2.right_bumper) {
            armServo?.position = 0.45 //Cube
        } else {
            armServo?.position = 0.0 }
    }*/
}