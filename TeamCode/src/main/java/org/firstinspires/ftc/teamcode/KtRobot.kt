package org.firstinspires.ftc.teamcode
import com.qualcomm.robotcore.hardware.*

/**
 * Created by KasaiYuki on 9/25/2018.
 */
class KtRobot
{
    var hwdMap: HardwareMap? = null
    var leftDrive: DcMotor? = null
    var rightDrive: DcMotor? = null
    var armMot: DcMotor? = null
    var tokenServo: Servo? = null //servo to drop team token
    var lSlideArm: DcMotor? = null //motor to lift the linear slide

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
        armMot = ahwdMap.dcMotor.get("armMot")
        tokenServo = ahwdMap.servo.get("tokenServo")
        lSlideArm = ahwdMap.dcMotor.get("lSlideArm")

        //Setting direction
        leftDrive?.direction = motF
        rightDrive?.direction = motR
        armMot?.direction = motF
        tokenServo?.direction = serR

        leftDrive?.power = 0.0
        rightDrive?.power = 0.0
        armMot?.power = 0.0
        leftDrive?.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        rightDrive?.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        armMot?.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        tokenServo?.position = 0.8
    }

    //METHODS
    fun unClamp()
    {
        armMot?.power = -0.5
        tokenServo?.position = 0.0
    }

    /*
    PLAN-use math to input angle, and calculate the power and output time needed
     */
    fun rotateArm(pow: Double)
    {
        armMot?.power = pow
    }

    fun dropToken()
    {
        tokenServo?.position = 0.5
    }
    fun liftToken()
    {
        tokenServo?.position = 0.8
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
            tokenServo?.position = 0.25 //Sphere
        } else if (gp.right_bumper) {
            tokenServo?.position = 0.45 //Cube
        } else {
            tokenServo?.position = 0.0 }
    }
    fun liftRobot()
    {
        lSlideArm?.power = 10.0
    }

    fun liftRobot(pow: Double)
    {
        lSlideArm?.power = pow
    }
}