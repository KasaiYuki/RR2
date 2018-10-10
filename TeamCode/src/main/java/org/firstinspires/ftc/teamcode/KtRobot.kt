package org.firstinspires.ftc.teamcode
import com.qualcomm.robotcore.hardware.*
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode

/**
 * Created by KasaiYuki on 9/25/2018.
 */
class KtRobot
{
    var leftDrive: DcMotor? = null
    var rightDrive: DcMotor? = null
    var extArm: DcMotor? = null
    var armServo: Servo? = null
    var hwdMap: HardwareMap? = null

    var motF = DcMotorSimple.Direction.FORWARD
    var motR = DcMotorSimple.Direction.REVERSE
    var serR = Servo.Direction.REVERSE
    var serF = Servo.Direction.FORWARD

    //Default Constructor
    init
    {

    }

    fun init(ahwdMap: HardwareMap)
    {
        hwdMap = ahwdMap
        leftDrive = ahwdMap.dcMotor.get("leftDrive")
        rightDrive = ahwdMap.dcMotor.get("rightDrive")
        extArm = ahwdMap.dcMotor.get("extArm")
        armServo = ahwdMap.servo.get("armServo")

        //Setting direction
        leftDrive?.direction = motF
        rightDrive?.direction = motR
        extArm?.direction = motF
        armServo?.direction = serR

        leftDrive?.power = 0.0
        rightDrive?.power = 0.0
        extArm?.power = 0.0
        leftDrive?.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        rightDrive?.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        extArm?.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        armServo?.position = 0.5
    }

    //METHODS
    fun unClamp()
    {
        extArm?.power = -0.5
        armServo?.position = 0.0
    }

    fun extendArm(pow: Double)
    {
        extArm?.power = pow
    }

    fun dropArm()
    {
        armServo?.position = 1.0
    }

    fun drive(leftM: Double, rightM: Double)
    {
        leftDrive?.power = leftM
        rightDrive?.power = rightM
    }

    fun drive(pow: Double)//OVERLOAD
    {
        drive(pow, pow)
    }

    fun spinServo(gp: Gamepad) {
        if (gp.left_bumper) {
            armServo?.position = 0.25 //Sphere
        } else if (gp.right_bumper) {
            armServo?.position = 0.45 //Cube
        } else {
            armServo?.position = 0.0 }
    }
}