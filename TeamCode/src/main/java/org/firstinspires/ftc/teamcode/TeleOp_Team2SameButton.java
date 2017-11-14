package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="TeleOp Team 2 Same Button", group="Driver Controlled")
public class TeleOp_Team2SameButton extends OpMode {
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
        double right = gamepad2.right_stick_y;
        double left = gamepad2.left_stick_y;

        motorRight.setPower(-right);
        motorLeft.setPower(-left);

        if(gamepad1.right_bumper) {
            motorWinch.setPower(0.2);
        }
        else if(gamepad1.left_bumper) {
            motorWinch.setPower(-0.4);
        }
        else{
            motorWinch.setPower(-0.05);
        }

        if(gamepad1.y) {
            // moves back.
            servoRight.setPosition(0.5);

        } else if(gamepad1.b) {
            servoRight.setPosition(0.0);
        }
        if (gamepad1.y) {
            // moves half.
            servoLeft.setPosition(0.0);
        } else if (gamepad1.b) {
            // moves full.
            servoLeft.setPosition(0.5);
        }
    }


    @Override
    public void stop() {

    }

}
