package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake extends SubsystemBase {

    DcMotorEx intake;
    ColorSensor colorSensor;
    Telemetry telemetry;
    HardwareMap hardwareMap;

    public Intake(Telemetry telemetry, HardwareMap hardwareMap){
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;


        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
        intake = hardwareMap.get(DcMotorImplEx.class, "intake");
        intake.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    public void Take(double power){
        intake.setPower(power);
    }

    public void OutTake(double power){
        intake.setPower(power);
    }


    @Override
    public void periodic(){
        telemetry.addData("Light Detected:", ((OpticalDistanceSensor) colorSensor).getLightDetected());
        telemetry.addData("Red:", colorSensor.red());
        telemetry.addData("Green:", colorSensor.green());
        telemetry.addData("Blue:", colorSensor.blue());
        telemetry.update();
    }




}
