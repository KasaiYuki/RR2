package org.firstinspires.ftc.teamcode


import com.qualcomm.robotcore.eventloop.opmode.Disabled
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.util.ElapsedTime

/**
 * Created by KasaiYuki on 9/21/2018.
 */

@Autonomous(name="KtAutoOp", group = "Autonomous")
//@Disabled
class KtAutoOp : LinearOpMode()
{
    val robot = Robot()

    //val time = ElapsedTime()
    @Throws(InterruptedException::class)
    override fun runOpMode()
    {
        telemetry.addData("Status", "Initialized")
        telemetry.update()
        robot.init(hardwareMap)

        waitForStart()
        //runtime.reset()//IDK WHY RUNTIME DOESN"T WORK!

        robot.driveForward(5.9)
        robot.clampServo(.2)
    }
}