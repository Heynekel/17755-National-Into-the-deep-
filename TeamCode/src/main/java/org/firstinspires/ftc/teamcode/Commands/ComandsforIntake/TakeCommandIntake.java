package org.firstinspires.ftc.teamcode.Commands.ComandsforIntake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.IntakeSystem;

public class TakeCommandIntake extends CommandBase{
    IntakeSystem m_intake;

    public TakeCommandIntake(IntakeSystem m_intake){
        this.m_intake = m_intake;

        addRequirements(m_intake);
    }

    @Override
    public void execute() {
       m_intake.Take(-1);
    }

    @Override
    public void end(boolean interrupted) {
        m_intake.Take(0);
        super.end(interrupted);
    }

}
