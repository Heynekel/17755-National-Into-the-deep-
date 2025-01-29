package org.firstinspires.ftc.teamcode.TeleOps;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.ComandsforIntake.BackIntakeCoomand;
import org.firstinspires.ftc.teamcode.Commands.ComandsforIntake.ExtendsIntakeCommand;
import org.firstinspires.ftc.teamcode.Commands.ComandsforIntake.MuñecaDownCommand;
import org.firstinspires.ftc.teamcode.Commands.ComandsforIntake.MuñecaUpCommand;
import org.firstinspires.ftc.teamcode.Commands.ComandsforIntake.TakeCommandIntake;
import org.firstinspires.ftc.teamcode.Subsystems.ExtensionIntakeSystem;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.MuñecaIntakeSystem;

@TeleOp
public class TeleOpPrueba extends CommandOpMode {
    GamepadEx m_prueba;
    ExtensionIntakeSystem m_extensionIntake;
    MuñecaIntakeSystem m_muñecaSystem;
    Intake m_intake;

    @Override
    public void initialize() {
        m_prueba = new GamepadEx(gamepad1);
        m_extensionIntake = new ExtensionIntakeSystem(telemetry, hardwareMap);
        m_muñecaSystem = new MuñecaIntakeSystem(telemetry, hardwareMap);
       m_intake = new Intake(telemetry, hardwareMap);


/* m_prueba.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
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
                                );*/

        m_prueba.getGamepadButton( GamepadKeys.Button.A)
                .whenPressed(()-> m_extensionIntake.Back());

        m_prueba.getGamepadButton( GamepadKeys.Button.B)
                .whenPressed(()-> m_muñecaSystem.Normal());

       m_prueba.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                        .whileHeld(()-> m_intake.Take(-1))
                        .whileHeld(()-> m_muñecaSystem.Down())
                .whenReleased(()-> m_intake.Take(0))
                .whenReleased(()-> m_muñecaSystem.Up());


        m_prueba.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .whileHeld(()-> m_intake.OutTake(0.4))
                .whileHeld(()-> m_muñecaSystem.Normal())
                .whenReleased(()-> m_intake.OutTake(0))
                .whenReleased(()-> m_muñecaSystem.Up());


        m_prueba.getGamepadButton( GamepadKeys.Button.Y)
                .whenPressed(()->m_extensionIntake.Extend());
//
    }
    }



