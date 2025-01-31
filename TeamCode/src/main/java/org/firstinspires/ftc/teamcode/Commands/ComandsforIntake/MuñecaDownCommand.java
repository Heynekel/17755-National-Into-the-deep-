package org.firstinspires.ftc.teamcode.Commands.ComandsforIntake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.MuñecaIntakeSystem;

public class MuñecaDownCommand extends CommandBase {
    MuñecaIntakeSystem m_intakeMuñeca;

    public MuñecaDownCommand(MuñecaIntakeSystem m_intakeMuñeca){

this.m_intakeMuñeca = m_intakeMuñeca;

addRequirements(m_intakeMuñeca);

    }

    @Override
    public void execute() {
      m_intakeMuñeca.Down();
    }

    @Override
    public boolean isFinished(){
return m_intakeMuñeca.getAngle()  <= 94;
    }

}
