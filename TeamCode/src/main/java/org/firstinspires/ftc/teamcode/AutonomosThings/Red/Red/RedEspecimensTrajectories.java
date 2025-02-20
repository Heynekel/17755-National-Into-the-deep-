package org.firstinspires.ftc.teamcode.AutonomosThings.Red.Red;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class RedEspecimensTrajectories {

    public Trajectory Redespecimen1(SampleMecanumDrive drive){
        Pose2d firstpose = new Pose2d(8.15, -63.05, Math.toRadians(270));
        drive.setPoseEstimate(firstpose);
        return drive.trajectoryBuilder(firstpose)
                .lineToConstantHeading(new Vector2d(7 ,-30))
                .build();
        /*Deja el primer especimen*/
    }

    public  Trajectory Redespecimen2(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(7, -33, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(32.5, -38.5, Math.toRadians(33)))
                .build();
  /*Va a al punto medio*/
    }

    public Trajectory girar1(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(34.5, -40, Math.toRadians(33)))
                .lineToLinearHeading(new Pose2d(40, -50, Math.toRadians(330)))
                .build();
    }

    public Trajectory Redespecimen3(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(40, -50, Math.toRadians(330)))
                .lineToLinearHeading(new Pose2d(42, -37, Math.toRadians(33)))
                .build();

    }


    public Trajectory Redespecimen4(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(45, -37, Math.toRadians(33)))
                .lineToLinearHeading(new Pose2d(45, -50, Math.toRadians(330)))
                .build();

    }

    public Trajectory Redespecimen5(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(45, -50, Math.toRadians(330)))
                .lineToLinearHeading(new Pose2d(41, -49, Math.toRadians(90)))
                .build();

    }

    public Trajectory estamparse(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(41, -49, Math.toRadians(90)))
                .lineToLinearHeading(new Pose2d(41, -66, Math.toRadians(90)))
                .build();

    }

    public Trajectory RedEspecimen6(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(48, -60, Math.toRadians(90)))
                .lineToLinearHeading(new Pose2d(-4, -25, Math.toRadians(270)))
                .build();
    }

    public Trajectory RedEspecimen7(SampleMecanumDrive drive) {
        return drive.trajectoryBuilder(new Pose2d(0, -40, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(41, -49, Math.toRadians(90)))
                .build();

    }

    public Trajectory RedEspecimen8(SampleMecanumDrive drive) {
        return drive.trajectoryBuilder(new Pose2d(40, -66, Math.toRadians(90)))
                .lineToLinearHeading(new Pose2d(0.5, -26, Math.toRadians(270)))
                .build();
    }





    }







