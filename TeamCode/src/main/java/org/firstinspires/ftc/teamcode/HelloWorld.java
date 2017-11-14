package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Hello World", group="Tests")
public class HelloWorld extends LinearOpMode {
    @Override
    public void runOpMode() {
        telemetry.addData("Message", "Hello World");
        telemetry.update();
    }
}