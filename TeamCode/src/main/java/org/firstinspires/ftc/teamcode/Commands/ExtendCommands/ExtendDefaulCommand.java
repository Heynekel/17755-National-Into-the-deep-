package org.firstinspires.ftc.teamcode.Commands.ExtendCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Subsystems.ExtensionIntakeSystem;

public class ExtendDefaulCommand extends CommandBase {

    ExtensionIntakeSystem m_extensionIntakeSystem;
    GamepadEx m_gamepad;

    public ExtendDefaulCommand(ExtensionIntakeSystem m_extensionIntakeSystem, GamepadEx m_gamepad){
        this.m_extensionIntakeSystem = m_extensionIntakeSystem;
        this.m_gamepad = m_gamepad;

        addRequirements(m_extensionIntakeSystem);
    }
    @Override
    public void execute(){
        //Por poder
/*Para sacar la extencion*/
        if(m_gamepad.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > .7){
            m_extensionIntakeSystem.Extend(1);
        }else if(m_gamepad.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) < 0.5  ){
            m_extensionIntakeSystem.Extend(0);
        }

        /*Para meter la extencion*/
        if (m_gamepad.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER)  >.7){
            m_extensionIntakeSystem.Extend(-1);
        }else if(m_gamepad.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) >0.5){
            m_extensionIntakeSystem.Extend(0);
        }



    }

}
