package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import static com.qualcomm.hardware.hitechnic.HiTechnicNxtIrSeekerSensor.DIRECTION;

/**
 * Base class for autonomous modes. This has a bunch of turtle like utilities.
 * All methods are blocking (they don't return until their job is finished).
 */

public abstract class AutonomousBase extends LinearOpMode {
    /**
     * maximum power for the drivetrain that is passed to motor.setPower
     */
    private static final float MAX_DRIVETRAIN_POWER = 1;
    /**
     * radial (on the outside) of the wheel when the power is at
     * MAX_DRIVETRAIN_POWER
     */
    private static final float MAX_DRIVETRAIN_SPEED = 1;
    /**
     * how far the wheels are from the center of the robot
     */
    private static final float DRIVETRAIN_RADIUS = 1;

    /**
     * the motors in charge of the drivetrain wheels
     */
    protected DcMotor leftDrivetrain;
    protected DcMotor rightDrivetrain;

    public void initialize() {
        leftDrivetrain = hardwareMap.dcMotor.get("left");
        rightDrivetrain = hardwareMap.dcMotor.get("right");
        leftDrivetrain.setDirection(DcMotor.Direction.REVERSE);
    }

    /**
     * waits the specified number of seconds
     * @param seconds the seconds to wait
     */
    protected void wait(float seconds) {
        try {
            Thread.sleep((long) seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * moves the robot forward
     * @param time the time to move in seconds
     * @param power the power for the motors
     */
    protected void forward(float time, float power) {
        power = Math.min(power, MAX_DRIVETRAIN_POWER);
        leftDrivetrain.setPower(power);
        rightDrivetrain.setPower(power);
        wait(time);
        leftDrivetrain.setPower(0);
        rightDrivetrain.setPower(0);
    }

    /**
     * turns the robot
     * @param time the time in seconds
     * @param power the power of the motors
     */
    protected void turn(float time, float power) {
        leftDrivetrain.setPower(-power);
        rightDrivetrain.setPower(power);
        wait(time);
        leftDrivetrain.setPower(0);
        rightDrivetrain.setPower(0);
    }
}
