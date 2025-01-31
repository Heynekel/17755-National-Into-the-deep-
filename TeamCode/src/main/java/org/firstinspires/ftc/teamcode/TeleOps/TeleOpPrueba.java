package org.firstinspires.ftc.teamcode.TeleOps;

import com.arcrobotics.ftclib.command.CommandOpMode;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import org.firstinspires.ftc.teamcode.Commands.ComandsforIntake.MuñecaDownCommand;
import org.firstinspires.ftc.teamcode.Commands.ComandsforIntake.MuñecaNormalCommand;
import org.firstinspires.ftc.teamcode.Commands.ComandsforIntake.MuñecaUpCommand;
import org.firstinspires.ftc.teamcode.Commands.MecanumDriveCommand;

import org.firstinspires.ftc.teamcode.Subsystems.ExtensionIntakeSystem;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.MuñecaIntakeSystem;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

@TeleOp
public class TeleOpPrueba extends CommandOpMode {
    SampleMecanumDrive sampleMecanumDrive;
    MecanumDriveSubsystem m_drive;
    GamepadEx m_prueba;
    ExtensionIntakeSystem m_extensionIntake;
    MuñecaIntakeSystem m_muñecaSystem;
    Intake m_intake;


    @Override
    public void initialize() {
        sampleMecanumDrive = new SampleMecanumDrive(hardwareMap);
        m_drive = new MecanumDriveSubsystem(sampleMecanumDrive, false, false);
        m_prueba = new GamepadEx(gamepad1);
        m_extensionIntake = new ExtensionIntakeSystem(telemetry, hardwareMap);
        m_muñecaSystem = new MuñecaIntakeSystem(telemetry, hardwareMap);
       m_intake = new Intake(telemetry, hardwareMap);


       m_drive.setDefaultCommand(
               new MecanumDriveCommand(
                       m_drive,
                       () -> -m_prueba.getLeftY(),
                       m_prueba::getLeftX,
                       m_prueba::getRightX
               ));




 m_prueba.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                        .whileHeld(
                                new ParallelCommandGroup(
                                       new MuñecaDownCommand(m_muñecaSystem),
                                        new InstantCommand(()->m_intake.Take(-0.75))
                                )
                        )
                                .whenReleased(
                                        new ParallelCommandGroup(
                                        new MuñecaUpCommand(m_muñecaSystem),
                                        new InstantCommand(()->m_intake.Take(0)))
                                );

        m_prueba.getGamepadButton( GamepadKeys.Button.A)
                .whenPressed(()-> m_muñecaSystem.Down());

        m_prueba.getGamepadButton( GamepadKeys.Button.B)
                .whenPressed(()-> m_muñecaSystem.Normal());

        m_prueba.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .whileHeld(
                        new ParallelCommandGroup(
                                new MuñecaNormalCommand(m_muñecaSystem),
                                new WaitCommand(750),
                                new InstantCommand(()->m_intake.Take(0.5))
                        )
                )
                .whenReleased(
                        new ParallelCommandGroup(
                                new MuñecaUpCommand(m_muñecaSystem),
                                new InstantCommand(()->m_intake.Take(0)))
                );


        m_prueba.getGamepadButton( GamepadKeys.Button.Y)
                .whenPressed(()->m_muñecaSystem.Up()
                );
//



        schedule(new RunCommand(() -> {
            m_drive.update();
            m_drive.updatePoseEstimate();
            telemetry.addData("Heading", m_drive.getPoseEstimate().getHeading());
           // telemetry.addData("Position", m_drive.getPoseEstimate());

        }));

    }
    }



