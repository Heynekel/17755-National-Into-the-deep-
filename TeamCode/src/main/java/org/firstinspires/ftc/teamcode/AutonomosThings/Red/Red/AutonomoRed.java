package org.firstinspires.ftc.teamcode.AutonomosThings.Red.Red;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.RunCommand;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Subsystems.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystems.Escalador;
import org.firstinspires.ftc.teamcode.Subsystems.ExtensionIntakeSystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSystem;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.MuñecaIntakeSystem;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

//@Autonomous(name = "RedEspecimens")
public class AutonomoRed extends CommandOpMode {


SampleMecanumDrive sampleMecanumDrive;
MecanumDriveSubsystem m_driveSubsystem;
ExtensionIntakeSystem m_extensionIntakeSystem;
IntakeSystem m_intakeSystem;
MuñecaIntakeSystem m_muñecaIntakeSystem;
ElevatorSystem m_elevatorSystem;
Escalador m_escalador;
AutonomosProcesRed autonomosProcesRed;

    @Override
    public void initialize() {

        sampleMecanumDrive = new SampleMecanumDrive(hardwareMap);/*siempre van al incio*/
     m_driveSubsystem = new MecanumDriveSubsystem(sampleMecanumDrive, false, false);

     m_escalador = new Escalador(telemetry, hardwareMap);
     m_extensionIntakeSystem = new ExtensionIntakeSystem(telemetry, hardwareMap);
     m_intakeSystem = new IntakeSystem(telemetry, hardwareMap);
     m_muñecaIntakeSystem = new MuñecaIntakeSystem(telemetry, hardwareMap);
     m_elevatorSystem =  new ElevatorSystem(hardwareMap, telemetry);
        schedule(new RunCommand(() -> {
            m_driveSubsystem.update();
            m_driveSubsystem.updatePoseEstimate();
            telemetry.addData("Heading", m_driveSubsystem.getPoseEstimate().getHeading());
            telemetry.addData("Position", m_driveSubsystem.getPoseEstimate());
            telemetry.update();
        }));
        autonomosProcesRed = new AutonomosProcesRed(m_driveSubsystem, m_elevatorSystem, m_extensionIntakeSystem, m_intakeSystem, m_muñecaIntakeSystem,m_escalador);
schedule(autonomosProcesRed);



    }
}
