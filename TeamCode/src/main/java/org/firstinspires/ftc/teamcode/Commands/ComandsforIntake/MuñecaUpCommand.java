package org.firstinspires.ftc.teamcode.Commands.ComandsforIntake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.MuñecaIntakeSystem;

public class MuñecaUpCommand extends CommandBase {
    MuñecaIntakeSystem m_inatkeMueñeca;

    public MuñecaUpCommand(MuñecaIntakeSystem m_inatkeMueñeca){
        this.m_inatkeMueñeca = m_inatkeMueñeca;

        addRequirements(m_inatkeMueñeca);
    }
    @Override
    public void execute() {
  m_inatkeMueñeca.Up();
    }

}
