package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake extends SubsystemBase {

    DcMotorEx intake;
    Telemetry telemetry;
    HardwareMap hardwareMap;

    public Intake(Telemetry telemetry, HardwareMap hardwareMap){
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;

        intake = hardwareMap.get(DcMotorImplEx.class, "intake");
        intake.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    public void Take(int power){
        intake.setPower(power);
    }

    public void OutTake(double power){
        intake.setPower(power);
    }


}
