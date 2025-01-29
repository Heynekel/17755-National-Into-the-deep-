package org.firstinspires.ftc.teamcode.Commands.ComandsforIntake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.ExtensionIntakeSystem;

public class BackIntakeCoomand extends CommandBase {

    ExtensionIntakeSystem m_extensionIntake;

    public BackIntakeCoomand(ExtensionIntakeSystem m_extensionIntake){

        this.m_extensionIntake = m_extensionIntake;

        addRequirements(m_extensionIntake);
    }

    @Override
    public void execute() {
       m_extensionIntake.Back();
    }

    @Override
    public boolean isFinished(){
        return m_extensionIntake.GetAngle() <= 1;
    }

}


