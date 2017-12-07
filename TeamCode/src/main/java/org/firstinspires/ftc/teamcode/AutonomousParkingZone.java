package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

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

    protected AutonomousParkingZone(boolean isLeft) {
        this.isLeft = isLeft;
    }

    @Override
    public void loop() {
        wait(initial_wait);
        forward(2, 0.2F);
        turn(0.5F, 0.2F * (isLeft ? -1 : 1));
        forward(1, 0.2F);
    }
}
