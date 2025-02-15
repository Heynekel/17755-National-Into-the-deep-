package org.firstinspires.ftc.teamcode.Commands.ComandsforIntake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.IntakeSystem;

public class OutTakeCommand extends CommandBase {

    IntakeSystem m_intake;

    public OutTakeCommand(IntakeSystem m_intake){

        this.m_intake = m_intake;

        addRequirements(m_intake);
    }


    @Override
    public void execute() {
        m_intake.OutTake(-1);
    }

    @Override
    public void end(boolean interrupted) {
        m_intake.OutTake(0);
        super.end(interrupted);
    }

}
