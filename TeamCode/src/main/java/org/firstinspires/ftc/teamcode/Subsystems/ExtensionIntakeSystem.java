package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class ExtensionIntakeSystem extends SubsystemBase {

    Telemetry telemetry;
    HardwareMap hardwareMap;
    ServoEx extension1, extension2;

    public ExtensionIntakeSystem(Telemetry telemetry, HardwareMap hardwareMap) {
        this.telemetry = telemetry;
        this.hardwareMap = hardwareMap;

        extension1 = new SimpleServo(hardwareMap, "extension1", 0, 180, AngleUnit.DEGREES);
        extension2 = new SimpleServo(hardwareMap, "extension2", 0, 180, AngleUnit.DEGREES);
        extension1.setInverted(true);
    }

    public void Extend(){
        extension1.turnToAngle(100);
        extension2.turnToAngle(100);
    }

    public void Back(){
        extension2.turnToAngle(1);
        extension1.turnToAngle(1);
    }


    public double GetAngle(){
        return  extension1.getAngle();
    }


}

