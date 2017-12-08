package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@TeleOp(name="Hello World", group="Tests")
@Disabled
public class HelloWorld extends LinearOpMode {
    @Override
    public void runOpMode() {
        telemetry.addData("Message", "Hello World");
        telemetry.update();
    }
}