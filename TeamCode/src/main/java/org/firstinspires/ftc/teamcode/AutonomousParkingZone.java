package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


/**
 * Autonomous Mode where the robot starts from the balancing board and goes to
 * the parking zone. The robot waits, goes forward, turns left and then goes
 * forward again.
 */

public abstract class AutonomousParkingZone extends AutonomousBase {
    /**
     * distance in meters of the first time the robot goes forward.
     */
    private static final float FIRST_FORWARD = 1;
    /**
     * angle in radians of how far the robot turns left.
     */
    private static final float TURN_ANGLE = 1;
    /**
     * distance in meters of the second time the robot goes forward
     */
    private static final float SECOND_FORWARD = 1;

    /**
     * how long the robot waits at first
     */
    private float initial_wait = 1;
    protected boolean isLeft;
    DcMotor motorRight;
    DcMotor motorLeft;
    DcMotor motorWinch;
    Servo servoRight;
    Servo servoLeft;

    protected AutonomousParkingZone(boolean isLeft) {
        this.isLeft = isLeft;
    }

    @Override
    public void runOpMode() {
        motorRight = hardwareMap.dcMotor.get("right");
        motorLeft = hardwareMap.dcMotor.get("left");
        motorWinch = hardwareMap.dcMotor.get("winch");

        servoRight = hardwareMap.servo.get("sRight");
        servoLeft = hardwareMap.servo.get("sLeft");

        initialize();
        wait(initial_wait);
        forward(1, 0.5F);
    }


}