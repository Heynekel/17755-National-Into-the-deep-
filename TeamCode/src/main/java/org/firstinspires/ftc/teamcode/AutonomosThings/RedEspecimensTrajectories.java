package org.firstinspires.ftc.teamcode.AutonomosThings;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class RedEspecimensTrajectories {

    public Trajectory Redespecimen1(SampleMecanumDrive drive){
        Pose2d firstpose = new Pose2d(8.15, -63.05, Math.toRadians(270));
        drive.setPoseEstimate(firstpose);
        return drive.trajectoryBuilder(firstpose)
                .lineToConstantHeading(new Vector2d(2 ,-28))
                .build();
        /*Deja el primer especimen*/
    }

    public  Trajectory Redespecimen2(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(2, -25, Math.toRadians(340)))
                .lineToConstantHeading(new Vector2d(30, -42))
                .build();
  /*Va a al punto medio*/
    }

    public Trajectory girar1(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(30, -41.5, Math.toRadians(340)))
                .lineToLinearHeading(new Pose2d(24, -41.3, Math.toRadians(33)))
                .build();
    }

    public Trajectory Redespecimen3(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(24, -40.8, Math.toRadians(33)))
                .forward(24)
                .build();
    }


    public Trajectory Redespecimen4(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(24, -40, Math.toRadians(32)))
                .lineToLinearHeading(new Pose2d(30, -53, Math.toRadians(330)))
                .build();

    }

    public Trajectory Redespecimen5(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(45, -50, Math.toRadians(330)))
                .lineToLinearHeading(new Pose2d(50, -20, Math.toRadians(30)))
                .build();

    }

    public Trajectory RedEspecimen6(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(50, -20, Math.toRadians(30)))
                .forward(8.5)
                .build();
    }

    public Trajectory RedEspecimen7(SampleMecanumDrive drive) {
        return drive.trajectoryBuilder(new Pose2d(52, -20, Math.toRadians(30)))
                .lineToLinearHeading(new Pose2d(45, -35, Math.toRadians(330)))
                .build();

    }

    }







