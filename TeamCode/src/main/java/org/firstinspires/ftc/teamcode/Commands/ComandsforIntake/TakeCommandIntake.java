package org.firstinspires.ftc.teamcode.Commands.ComandsforIntake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.Intake;

public class TakeCommandIntake extends CommandBase{
    Intake m_inatke;

    public TakeCommandIntake(Intake m_inatke){
        this.m_inatke = m_inatke;

        addRequirements(m_inatke);
    }

    @Override
    public void execute() {
       m_inatke.Take(-1);
    }

    @Override
    public void end(boolean interrupted) {
        m_inatke.Take(0);
        super.end(interrupted);
    }

}
