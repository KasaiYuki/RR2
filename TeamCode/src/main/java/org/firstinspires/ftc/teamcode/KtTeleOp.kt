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
    val robot = Robot()

    override fun init()
    {
        robot.init(hardwareMap)

        telemetry.addData("Status", "Initialized")
    }

    override fun loop()
    {
        //Tank Drive
        var leftPower: Float = -gamepad1.left_stick_y
        var rightPower: Float = -gamepad1.right_stick_y

        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower)
    }

    override fun stop()
    {

    }

}