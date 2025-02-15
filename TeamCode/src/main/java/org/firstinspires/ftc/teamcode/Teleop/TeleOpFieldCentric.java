package org.firstinspires.ftc.teamcode.Teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import org.firstinspires.ftc.teamcode.Commands.ComandsforIntake.OutTakeCommand;
import org.firstinspires.ftc.teamcode.Commands.ComandsforIntake.TakeCommandIntake;
import org.firstinspires.ftc.teamcode.Commands.DriveTrainCommands.MecanumDriveCommand;
import org.firstinspires.ftc.teamcode.Commands.ExtendCommands.CommandExtend;
import org.firstinspires.ftc.teamcode.Commands.ExtendCommands.ExtendDefaulCommand;
import org.firstinspires.ftc.teamcode.Commands.ExtendCommands.RetractCommand;
import org.firstinspires.ftc.teamcode.Commands.WristCommands.MuñecaDownCommand;
import org.firstinspires.ftc.teamcode.Commands.WristCommands.MuñecaNormalCommand;
import org.firstinspires.ftc.teamcode.Commands.WristCommands.MuñecaUpCommand;
import org.firstinspires.ftc.teamcode.Subsystems.ElevatorSystem;
import org.firstinspires.ftc.teamcode.Subsystems.Escalador;
import org.firstinspires.ftc.teamcode.Subsystems.ExtensionIntakeSystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSystem;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.MuñecaIntakeSystem;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.drive.TwoWheelTrackingLocalizer;


@TeleOp(name = "Teleop FieldCentric")
public class TeleOpFieldCentric extends CommandOpMode {

    SampleMecanumDrive sampleMecanumDrive;
    MecanumDriveSubsystem m_drive;
    GamepadEx m_chasisDriver;
    GamepadEx m_systemasDriver;
    ExtensionIntakeSystem m_extensionIntake;
    MuñecaIntakeSystem m_muñecaSystem;
    IntakeSystem m_intake;
    ElevatorSystem m_elevatorSystem;
    Escalador m_escalador;
    TwoWheelTrackingLocalizer localizer;

    @Override
    public void initialize() {
        sampleMecanumDrive = new SampleMecanumDrive(hardwareMap);
        m_drive = new MecanumDriveSubsystem(sampleMecanumDrive, true, false);
        m_chasisDriver = new GamepadEx(gamepad1);
        m_systemasDriver = new GamepadEx(gamepad2);
        m_extensionIntake = new ExtensionIntakeSystem(telemetry, hardwareMap);
        m_muñecaSystem = new MuñecaIntakeSystem(telemetry, hardwareMap);
        m_intake = new IntakeSystem(telemetry, hardwareMap);
        m_elevatorSystem = new ElevatorSystem(hardwareMap, telemetry);
        m_escalador = new Escalador(telemetry, hardwareMap);
        localizer = new TwoWheelTrackingLocalizer(hardwareMap, sampleMecanumDrive);

        /*Botones del Teleop*/

        /*Driver1*/
        /*drive train*/

        m_drive.setDefaultCommand(
                new MecanumDriveCommand(
                        m_drive,
                        () -> -m_chasisDriver.getLeftY(),
                        m_chasisDriver::getLeftX,
                        m_chasisDriver::getRightX
                ));


        /*Intake*/
        m_chasisDriver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whenPressed(new CommandExtend(m_extensionIntake, 6750))
                .whileHeld(
                        new SequentialCommandGroup(
                                new MuñecaDownCommand(m_muñecaSystem),
                                new InstantCommand(() -> m_intake.Take(-1)))
                )
                .whenReleased(
                        new ParallelCommandGroup(
                                new MuñecaUpCommand(m_muñecaSystem),
        new InstantCommand(() -> m_intake.Take(0)))
                );

        m_chasisDriver.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .whenPressed(new CommandExtend(m_extensionIntake, 6750))
                .whileHeld(
                        new SequentialCommandGroup(
                                new MuñecaNormalCommand(m_muñecaSystem),
                                new WaitCommand(250),
                                new InstantCommand(()-> m_intake.OutTake(1)))
                )
                .whenReleased(
                        new ParallelCommandGroup(
                                new MuñecaUpCommand(m_muñecaSystem),
                                new InstantCommand(()-> m_intake.OutTake(0)),
        new CommandExtend(m_extensionIntake, 100)

                        )
                );

        /*muñeca*/

        m_chasisDriver.getGamepadButton(GamepadKeys.Button.X)
                .whenPressed(()-> m_muñecaSystem.Normal());

        /*Extencion del intake*/

        m_extensionIntake.setDefaultCommand(new ExtendDefaulCommand(m_extensionIntake, m_chasisDriver));

        m_chasisDriver.getGamepadButton(GamepadKeys.Button.B)
                .whenPressed(
                        new RetractCommand(m_extensionIntake, 100)
                );

m_chasisDriver.getGamepadButton(GamepadKeys.Button.DPAD_LEFT)
                .whenPressed(()-> m_muñecaSystem.sacar());

m_chasisDriver.getGamepadButton(GamepadKeys.Button.DPAD_RIGHT)
                        .whenPressed(()-> m_muñecaSystem.guardar());


        /*Driver2*/

        /*elevator*/

        m_systemasDriver.getGamepadButton( GamepadKeys.Button.DPAD_UP)
                .whileHeld(()->  m_elevatorSystem.setPosition(2300));


        m_systemasDriver.getGamepadButton( GamepadKeys.Button.DPAD_RIGHT)
                .whileHeld(()->m_elevatorSystem.setPosition(1100));


        m_systemasDriver.getGamepadButton( GamepadKeys.Button.DPAD_DOWN)
                .whileHeld(()-> m_elevatorSystem.setPosition(0))
                .whileHeld(()-> m_escalador.EscaladorIn());


        /*Para escalar*/

        m_systemasDriver.getGamepadButton(GamepadKeys.Button.Y)
                .whileHeld(()-> m_escalador.setPower(1))
                .whenReleased(()-> m_escalador.setPower(0));

        m_systemasDriver.getGamepadButton(GamepadKeys.Button.A)
                .whileHeld(()-> m_escalador.setPower(-1))
                .whenReleased(()-> m_escalador.setPower(0));


        m_systemasDriver.getGamepadButton(GamepadKeys.Button.B)

                .whenPressed(
                        new ParallelCommandGroup(
                                new InstantCommand(()-> m_escalador.EscaladorOut()),
                                new InstantCommand(()-> m_elevatorSystem.setPosition(2400))
                        )
                );

        m_systemasDriver.getGamepadButton(GamepadKeys.Button.X)
                .whileHeld(()-> m_escalador.EscaladorOut());

        m_systemasDriver.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whenPressed(
                        new SequentialCommandGroup(
                                new InstantCommand(()-> m_elevatorSystem.setPosition(2710)),
                                new WaitCommand(750),
                                new InstantCommand(()-> m_escalador.EscaladorIn()),
                                new InstantCommand(()-> m_elevatorSystem.setPosition(2300)),
                                new  WaitCommand(750),
                                new ParallelCommandGroup(
                                        new InstantCommand(()-> m_elevatorSystem.setPosition(0)),
                                        new InstantCommand(()-> m_escalador.setPosition(-13800)),
                                        new WaitCommand(500),
                                        new RetractCommand(m_extensionIntake, 90)


                                )

                        )
                );




        /*boton de emregencia*/

        m_systemasDriver.getGamepadButton(GamepadKeys.Button.START)
                .whenPressed(
                        new SequentialCommandGroup(
                                new MuñecaUpCommand(m_muñecaSystem),
                                new RetractCommand(m_extensionIntake, 110)
                        )
                );

        schedule(new RunCommand(() -> {
            m_drive.update();
            m_drive.updatePoseEstimate();



            telemetry.addData("Heading", m_drive.getPoseEstimate().getHeading());
            telemetry.addData("Position", m_drive.getPoseEstimate());
            telemetry.addData("Wheel Velocities", m_drive.getWheelVelocities());
            // telemetry.addData("Voltage", m_drive.isOverCurrent());
            telemetry.update();
        }));
    }

    }




