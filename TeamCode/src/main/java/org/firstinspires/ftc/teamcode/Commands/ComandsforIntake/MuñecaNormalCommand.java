package org.firstinspires.ftc.teamcode.Commands.ComandsforIntake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.MuñecaIntakeSystem;

public class MuñecaNormalCommand extends CommandBase {

    MuñecaIntakeSystem m_inatkeMueñeca;

    public MuñecaNormalCommand(MuñecaIntakeSystem m_inatkeMueñeca){
        this.m_inatkeMueñeca = m_inatkeMueñeca;

        addRequirements(m_inatkeMueñeca);
    }
    @Override
    public void execute() {
        m_inatkeMueñeca.Normal();
    }
    @Override
    public boolean isFinished(){
        return m_inatkeMueñeca.getAngle() <= 63;
    }
}
