package org.firstinspires.ftc.teamcode.AutonomosThings.Red.Red;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.DriveTrainCommands.TrajectoryFollowerCommand;
import org.firstinspires.ftc.teamcode.Commands.ExtendCommands.CommandExtend;
import org.firstinspires.ftc.teamcode.Commands.ExtendCommands.RetractCommand;
import org.firstinspires.ftc.teamcode.Commands.WristCommands.MuñecaUpCommand;
import org.firstinspires.ftc.teamcode.Subsystems.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystems.Escalador;
import org.firstinspires.ftc.teamcode.Subsystems.ExtensionIntakeSystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSystem;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.MuñecaIntakeSystem;

public class AutonomosProcesRed extends SequentialCommandGroup {

    RedEspecimensTrajectories redEspecimensTrajectories = new RedEspecimensTrajectories();

public AutonomosProcesRed(MecanumDriveSubsystem m_drive, ElevatorSystem m_elevatorSystem, ExtensionIntakeSystem m_extensionIntakeSystem, IntakeSystem m_intakeSystem,
                          MuñecaIntakeSystem m_muñecaIntakeSystem, Escalador m_escalador){
addCommands(
        new WaitCommand(1),
        new InstantCommand(()-> m_elevatorSystem.setPosition(1500)),
    new ParallelCommandGroup(
            new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.Redespecimen1(m_drive.getDrive())),
                new InstantCommand(()-> m_elevatorSystem.setPosition(2300)),
            new InstantCommand(()-> m_escalador.EscaladorIn())
                ),

        new WaitCommand(100),
        new InstantCommand(()-> m_elevatorSystem.setPosition(1150)),

        /*Deja el 1 especimen*/
        new WaitCommand(100),
        new ParallelCommandGroup(
                new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.Redespecimen2(m_drive.getDrive())),
                new InstantCommand(()-> m_elevatorSystem.setPosition(0))
        ),
        new ParallelCommandGroup(
                new InstantCommand(()-> m_muñecaIntakeSystem.PositionforAutos()),
                new CommandExtend(m_extensionIntakeSystem, 17000),
                new InstantCommand(()-> m_intakeSystem.Take(-1))

                ),
        new WaitCommand(100),


new ParallelCommandGroup(
        new RetractCommand(m_extensionIntakeSystem, 11000),
        new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.girar1(m_drive.getDrive())),
        new InstantCommand(()->m_muñecaIntakeSystem.SacarAutos())
        ),
        new WaitCommand(100),
          new InstantCommand(()-> m_intakeSystem.Take(1)),
        new WaitCommand(100),
        new InstantCommand(()-> m_intakeSystem.Take(0)),
//deja el primer sample
        

        /*Va por otro sample*/
        new ParallelCommandGroup(
        new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.Redespecimen3(m_drive.getDrive())),
        new InstantCommand(()-> m_muñecaIntakeSystem.PositionforAutos())
        ),
        new ParallelCommandGroup(
            new CommandExtend(m_extensionIntakeSystem, 17000),
    new InstantCommand(()-> m_intakeSystem.Take(-1))
        ),

        new RetractCommand(m_extensionIntakeSystem, 11000),
    new ParallelCommandGroup(
              new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.Redespecimen4(m_drive.getDrive())),
            new InstantCommand(()->m_muñecaIntakeSystem.SacarAutos())
    ),
        new InstantCommand(()-> m_intakeSystem.Take(1)),

        new WaitCommand(100),
        new MuñecaUpCommand(m_muñecaIntakeSystem),

        new ParallelCommandGroup(
                new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.Redespecimen5(m_drive.getDrive())),
                new RetractCommand(m_extensionIntakeSystem, 200),
                new InstantCommand(()-> m_intakeSystem.Take(0))
                ),
        //15 segundos
        new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.estamparse(m_drive.getDrive())),
        new InstantCommand(()-> m_elevatorSystem.setPosition(2300)),
    new WaitCommand(100),

    new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.RedEspecimen6(m_drive.getDrive())),
        new WaitCommand(100),

        new InstantCommand(()-> m_elevatorSystem.setPosition(1150)),
        new WaitCommand(100),
        new ParallelCommandGroup(
            new InstantCommand(()-> m_elevatorSystem.setPosition(0)),
    new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.RedEspecimen7(m_drive.getDrive()))

                ),
        new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.estamparse(m_drive.getDrive())),

        new InstantCommand(()-> m_elevatorSystem.setPosition(2300)),

        new TrajectoryFollowerCommand(m_drive, redEspecimensTrajectories.RedEspecimen8(m_drive.getDrive())),

        new InstantCommand(()-> m_elevatorSystem.setPosition(1100)),
        new WaitCommand(50),
        new InstantCommand(()-> m_elevatorSystem.setPosition(0))

















        );
}
}
