package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class MuñecaIntakeSystem extends SubsystemBase {

    Telemetry telemetry;
    HardwareMap hardwareMap;
    ServoEx muñeca1;
public MuñecaIntakeSystem(Telemetry telemetry, HardwareMap hardwareMap){
    this.hardwareMap = hardwareMap;
    this.telemetry = telemetry;

    muñeca1 = new SimpleServo(hardwareMap, "muñeca1", 0, 180, AngleUnit.DEGREES);


    Up();
}

public void Down(){
    muñeca1.turnToAngle(95);

}

public void  Up(){
    muñeca1.turnToAngle(16);
}

public void Normal(){
    muñeca1.turnToAngle(63);
}

public double getAngle(){
    return muñeca1.getAngle();
}

}

