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

@Autonomous(name="KtAuto2", group = "Autonomous")
//@Disabled
class KtAuto2 : LinearOpMode()
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

        robot.liftRobot(1.0)
        sleep(8000)
        /* robot.liftRobot()
         sleep(2000)
         robot.drive(0.0)
         sleep(1000)
         robot.drive(35.0)
         sleep(2500)
         robot.dropToken()
         sleep(1000)
         robot.liftToken()*/


    }

}