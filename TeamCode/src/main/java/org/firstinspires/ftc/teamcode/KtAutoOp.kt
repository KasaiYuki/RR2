package org.firstinspires.ftc.teamcode


import com.qualcomm.robotcore.eventloop.opmode.Disabled
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Servo
import com.qualcomm.robotcore.util.ElapsedTime
import com.sun.beans.editors.DoubleEditor

/**
 * Created by KasaiYuki on 9/21/2018.
 */

@Autonomous(name="KtAutoOp", group = "Autonomous")
//@Disabled
class KtAutoOp : LinearOpMode()
{
    //adds robot objects for variables and methods
    val robot = Robot()

    var extArm: DcMotor? = null
    var armServo: Servo? = null

    var motF = DcMotorSimple.Direction.FORWARD
    var motR = DcMotorSimple.Direction.REVERSE
    var serR = Servo.Direction.REVERSE
    var serF = Servo.Direction.FORWARD

    @Throws(InterruptedException::class)
    override fun runOpMode()
    {
        telemetry.addData("Status", "Initialized")
        telemetry.update()
        //initializes all parts
        robot.init(hardwareMap)
        extArm = hardwareMap.dcMotor.get("extArm")
        armServo = hardwareMap.servo.get("armServo")

        extArm?.direction = motF
        armServo?.direction = serF

        waitForStart()
        //runtime.reset()//IDK WHY RUNTIME DOESN'T WORK!

        unClamp()
        robot.driveForward(-5.9)

    }

    fun unClamp()
    {
        extArm?.power = -1.0
        armServo?.position = 0.0
    }

    fun drive(leftM: Double, rightM: Double)
    {
        robot.rightDrive.power = rightM
        robot.leftDrive.power = leftM
    }
}