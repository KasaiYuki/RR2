package org.firstinspires.ftc.teamcode


import com.qualcomm.robotcore.eventloop.opmode.Disabled
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Servo
import com.qualcomm.robotcore.util.ElapsedTime

/**
 * Created by KasaiYuki on 9/21/2018.
 */

@Autonomous(name="KtAutoOp", group = "Autonomous")
//@Disabled
class KtAutoOp : LinearOpMode()
{
    //adds robot objects for variables and methods
    val robot = KtRobot()

    @Throws(InterruptedException::class)
    override fun runOpMode()
    {
        telemetry.addData("Status", "Initialized")
        telemetry.update()
        //initializes all parts
        robot.init(hardwareMap)

        waitForStart()
        //runtime.reset()//IDK WHY RUNTIME DOESN'T WORK!

        //robot.unClamp()
        sleep(100)
        //robot.drive(-1.0,1.0)
        robot.drive(5.9)
        robot.dropArm()
        sleep(1000)
    }

}