package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Escalador extends SubsystemBase {

    Telemetry telemetry;
    HardwareMap  hardwareMap;
    DcMotorEx escalador;
    ServoEx servoescalador;

    public Escalador(Telemetry telemetry, HardwareMap hardwareMap){
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;


        servoescalador = new SimpleServo(hardwareMap, "servoescalador", 0, 180, AngleUnit.DEGREES);

        escalador = hardwareMap.get(DcMotorEx.class,"escalador");

       // escalador.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        escalador.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        servoescalador.setInverted(true);

    }


    public void setPower(int power){
        escalador.setPower(power);
    }


    public void EscaladorOut(){
        servoescalador.turnToAngle(0);
    }

    public void EscaladorIn(){
        servoescalador.turnToAngle(180);
    }

    public void Brake(){
        escalador.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }


    /*Por posiciones*/

    public void setPosition(int pos) {
        escalador.setPower(1);
        escalador.setTargetPosition(pos);
        escalador.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    @Override
    public void periodic(){
        telemetry.addData("escalador", escalador.getCurrentPosition());
        telemetry.addData("servoescalador", servoescalador.getAngle());
    }


}
