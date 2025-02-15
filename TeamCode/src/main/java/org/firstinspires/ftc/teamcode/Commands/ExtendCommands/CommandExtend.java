package org.firstinspires.ftc.teamcode.Commands.ExtendCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Subsystems.ExtensionIntakeSystem;

public class CommandExtend extends CommandBase {

    int limit = 0;
    ExtensionIntakeSystem m_extensionIntakeSystem;

    public CommandExtend(ExtensionIntakeSystem m_extensionIntakeSystem, int position){

        this.m_extensionIntakeSystem = m_extensionIntakeSystem;
        limit = position;
        addRequirements(m_extensionIntakeSystem);
    }

    @Override
    public void execute(){
        m_extensionIntakeSystem.Extend(1);
    }

    @Override
    public void end(boolean interrupted){
        m_extensionIntakeSystem.Extend(0);
        super.end(interrupted);
    }

    @Override
    public boolean isFinished(){
       return m_extensionIntakeSystem.getEncoderPosition() > limit;
    }


}
