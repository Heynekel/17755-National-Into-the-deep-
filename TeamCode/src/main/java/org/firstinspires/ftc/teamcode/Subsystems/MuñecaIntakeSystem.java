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

    ServoEx servosamples;
    public MuñecaIntakeSystem(Telemetry telemetry, HardwareMap hardwareMap){
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        muñeca1 = new SimpleServo(hardwareMap, "muñeca1", 0, 180, AngleUnit.DEGREES);
        servosamples = new SimpleServo(hardwareMap, "servoSamples", 0, 180, AngleUnit.DEGREES);

        muñeca1.setInverted(false);


Up();
guardar();
    }

    public void Down(){
        muñeca1.turnToAngle(86);

    }


    public void guardar(){
        servosamples.turnToAngle(120);
    }

    public void  sacar(){
        servosamples.turnToAngle(55);
    }

    public void PositionforAutos(){
        muñeca1.turnToAngle(81);
    }

    public void  Up(){
        muñeca1.turnToAngle(23);
    }

    public void Normal(){
        muñeca1.turnToAngle(67);
    }

    public double getAngle(){
        return muñeca1.getAngle();
    }

    public void SacarAutos(){
        muñeca1.turnToAngle(80);
    }


    @Override
    public void periodic(){
        telemetry.addData("muñeca", muñeca1.getAngle());
    }
}

