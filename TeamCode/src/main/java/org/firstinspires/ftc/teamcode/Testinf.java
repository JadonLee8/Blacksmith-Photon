package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

import ftc.rogue.blacksmith.BlackOp;
import ftc.rogue.blacksmith.Scheduler;
import ftc.rogue.blacksmith.listeners.Listener;

@TeleOp
public class Testinf extends BlackOp {
    public SampleMecanumDrive drive;

    @Override
    public void go() {
        drive = new SampleMecanumDrive(hwMap());

        new Listener(() -> gamepad1.a).whileHigh(() -> {drive.setMotorPowers(.5,.5,.5,.5);}).onFall(() -> {drive.setMotorPowers(0,0,0,0);});

        Scheduler.launchOnStart(this, () -> {
            drive.setDrivePower(new Pose2d(gamepad1.left_stick_x, gamepad1.left_stick_y));
        });
    }
}
