package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class IntakeSystem extends SubsystemBase {

    DcMotorEx intake;
    //ColorSensor colorSensor;
    Telemetry telemetry;
    HardwareMap hardwareMap;

    public IntakeSystem(Telemetry telemetry, HardwareMap hardwareMap){
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;


       // colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
        intake = hardwareMap.get(DcMotorImplEx.class, "intake");
        intake.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    public void Take(int power){
        intake.setPower(power);
    }
    public void OutTake(double power){
        intake.setPower(power);
    }


 /* public ColorSensor getColorSensor(){
        return  colorSensor;
    }

    public boolean getRed(){
        if (((colorSensor.green() + colorSensor.red()) / 2)  > 1700){
            return  false;
        }
        else {
            return  colorSensor.red() > 1000;
        }
    }

    public  boolean getBlue(){

        if (((colorSensor.green() + colorSensor.blue()) / 2) > 1700){
            return  false;

        }

        else {
            return  colorSensor.blue() > 1000;
        }
    }


    public boolean getGreen(){
        return  colorSensor.green() > 500;
    }



    @Override
    public void periodic(){
        telemetry.addData("Light Detected:", ((OpticalDistanceSensor) colorSensor).getLightDetected());
        telemetry.addData("Red:", colorSensor.red());
        telemetry.addData("Green:", colorSensor.green());
        telemetry.addData("Blue:", colorSensor.blue());

    }*/


}
