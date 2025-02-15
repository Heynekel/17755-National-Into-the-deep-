package org.firstinspires.ftc.teamcode.AutonomosThings;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.DriveTrainCommands.TrajectoryFollowerCommand;
import org.firstinspires.ftc.teamcode.Commands.ExtendCommands.CommandExtend;
import org.firstinspires.ftc.teamcode.Commands.ExtendCommands.ExtendDefaulCommand;
import org.firstinspires.ftc.teamcode.Commands.ExtendCommands.RetractCommand;
import org.firstinspires.ftc.teamcode.Commands.WristCommands.MuñecaDownCommand;
import org.firstinspires.ftc.teamcode.Commands.WristCommands.MuñecaNormalCommand;
import org.firstinspires.ftc.teamcode.Commands.WristCommands.MuñecaUpCommand;
import org.firstinspires.ftc.teamcode.Subsystems.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystems.ExtensionIntakeSystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSystem;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.MuñecaIntakeSystem;

public class AutonomosProcesRed extends SequentialCommandGroup {

    RedEspecimensTrajectories redEspecimensTrajectories = new RedEspecimensTrajectories();

public AutonomosProcesRed(MecanumDriveSubsystem m_drive, ElevatorSystem m_elevatorSystem, ExtensionIntakeSystem m_extensionIntakeSystem, IntakeSystem m_intakeSystem,
                          MuñecaIntakeSystem m_muñecaIntakeSystem){
addCommands(
        new WaitCommand(1),
        new InstantCommand(()-> m_elevatorSystem.setPosition(1000)),
    new ParallelCommandGroup(
            new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.Redespecimen1(m_drive.getDrive())),
                new InstantCommand(()-> m_elevatorSystem.setPosition(2300))
                ),
        new WaitCommand(150),
        new InstantCommand(()-> m_elevatorSystem.setPosition(1100)),
        /*Deja el 1 especimen*/
        new WaitCommand(150),
        new ParallelCommandGroup(
                new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.Redespecimen2(m_drive.getDrive())),
                new InstantCommand(()-> m_elevatorSystem.setPosition(0))
        ),

                new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.girar1(m_drive.getDrive())),
        new CommandExtend(m_extensionIntakeSystem, 9000)
  /* new ParallelCommandGroup(
           new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.Redespecimen3(m_drive.getDrive())),
           new InstantCommand(()-> m_muñecaIntakeSystem.PositionforAutos()),
           new InstantCommand(()-> m_intakeSystem.Take(-1)),
    new CommandExtend(m_extensionIntakeSystem, 17000)
           ),
        /*Agarra un sample
        new WaitCommand(400),
        new ParallelCommandGroup(
                new MuñecaUpCommand(m_muñecaIntakeSystem),
                new InstantCommand(()-> m_intakeSystem.Take(0)),
              new RetractCommand(m_extensionIntakeSystem, 200)
        )
    /*new ParallelCommandGroup(
                new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.Redespecimen4(m_drive.getDrive())),
                new MuñecaNormalCommand(m_muñecaIntakeSystem)
        ),
        /*Deja el sample
        new InstantCommand(()-> m_intakeSystem.Take(0.75)),
        new WaitCommand(250)
        /*
        /*Va por otro sample
        new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.Redespecimen5(m_drive.getDrive())),
        new InstantCommand(()-> m_muñecaIntakeSystem.PositionforAutos()),
    new ParallelCommandGroup(
                new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.RedEspecimen6(m_drive.getDrive())),
    new InstantCommand(()-> m_intakeSystem.Take(-1))
        ),

        new ParallelCommandGroup(
                new MuñecaNormalCommand(m_muñecaIntakeSystem)
    new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.RedEspecimen7(m_drive.getDrive()))
        )*/
       // new InstantCommand(()-> m_intakeSystem.Take(1))








        );
}
}
