package org.firstinspires.ftc.teamcode.AutonomosThings.Red;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class BlueEspecimensTrayectories {
    public Trajectory BlueEspecimen1(SampleMecanumDrive drive){
        Pose2d firstpose = new Pose2d(8.15, -63.05, Math.toRadians(270));
        drive.setPoseEstimate(firstpose);
        return drive.trajectoryBuilder(firstpose)
                .lineToConstantHeading(new Vector2d(6 ,-28))
                .build();
        /*Deja el primer especimen*/
    }

    public  Trajectory BlueEspecimen2(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(6, -35, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(34, -38, Math.toRadians(33)))
                .build();
        /*Va a al punto medio*/
    }

    public Trajectory BlueEspecimen3(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(34, -38, Math.toRadians(33)))
                .lineToLinearHeading(new Pose2d(41, -51, Math.toRadians(330)))
                .build();
    }

    public Trajectory BlueEspecimen4(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(41, -51, Math.toRadians(330)))
                .lineToLinearHeading(new Pose2d(43, -36, Math.toRadians(33)))
                .build();

    }


    public Trajectory BlueEspecimen5(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(43, -36, Math.toRadians(33)))
                .lineToLinearHeading(new Pose2d(46, -51, Math.toRadians(330)))
                .build();

    }

    public Trajectory BlueEspecimen6(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(46, -51, Math.toRadians(330)))
                .lineToLinearHeading(new Pose2d(51, -51, Math.toRadians(90)))
                .build();

    }


    public Trajectory Estamparse(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(51, -48, Math.toRadians(90)))
                .lineToLinearHeading(new Pose2d(51, -70, Math.toRadians(90)))
                .build();

    }

    public Trajectory BlueEspecimen7(SampleMecanumDrive drive){
        return drive.trajectoryBuilder(new Pose2d(51, -50.5, Math.toRadians(90)))
                .lineToLinearHeading(new Pose2d(-4, -25, Math.toRadians(270)))
                .build();
    }

    public Trajectory BlueEspecimen8(SampleMecanumDrive drive) {
        return drive.trajectoryBuilder(new Pose2d(0, -40, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(50, -49, Math.toRadians(90)))
                .build();

    }

    public Trajectory BlueEspecimen9(SampleMecanumDrive drive) {
        return drive.trajectoryBuilder(new Pose2d(50, -66, Math.toRadians(90)))
                .lineToLinearHeading(new Pose2d(0, -25, Math.toRadians(270)))
                .build();
    }



}
