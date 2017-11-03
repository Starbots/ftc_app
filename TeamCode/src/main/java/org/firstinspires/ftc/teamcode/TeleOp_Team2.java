package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="TeleOp Team 2", group="Driver Controlled")
public class TeleOp_Team2 extends OpMode {
    private float inputScale = 1f;

    private DcMotor motorRight;
    private DcMotor motorLeft;
    private DcMotor motorWinch;
    private Servo servoRight;
    private Servo servoLeft;
    private boolean claw;

    @Override
    public void init() {

        motorRight = hardwareMap.dcMotor.get("right");
        motorLeft = hardwareMap.dcMotor.get("left");
        motorWinch = hardwareMap.dcMotor.get("winch");

        servoRight = hardwareMap.servo.get("sRight");
        servoLeft = hardwareMap.servo.get("sLeft");

        motorLeft.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        float right = gamepad1.right_stick_y;
        float left = gamepad1.left_stick_y;
        right = Range.clip(right, -1, 1);
        left = Range.clip(left, -1, 1);

        right *= inputScale;
        left *= inputScale;

        motorRight.setPower(right);
        motorLeft.setPower(left);
       // motorWinch.setPower(lTrigger);

        if(gamepad1.right_bumper) {
            motorWinch.setPower(0.3);
        }
        else if(gamepad1.left_bumper) {
            motorWinch.setPower(-0.3);
        }
        else{
            motorWinch.setPower(0);
        }

        if(gamepad1.y) {
            // moves back.
            servoLeft.setPosition(0.5);
            servoRight.setPosition(0.5);
        } else if (gamepad1.x || gamepad1.b) {
            // moves half.
            servoLeft.setPosition(0.7);
            servoRight.setPosition(0.7);
        } else if (gamepad1.a) {
            // moves full.
            servoLeft.setPosition(1);
            servoRight.setPosition(1);
        }
    }


    @Override
    public void stop() {

    }

}
