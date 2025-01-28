package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class ElevatorSystem extends SubsystemBase {

    HardwareMap hardwareMap;
    Telemetry telemetry;
    DcMotorEx elevatorleft, elevatorright;

    public ElevatorSystem(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        this.hardwareMap = hardwareMap;
        elevatorleft = hardwareMap.get(DcMotorEx.class, " elevatorleft");
        elevatorright = hardwareMap.get(DcMotorEx.class, " elevatorright");

        elevatorleft.setCurrentAlert(4000, CurrentUnit.MILLIAMPS);
        elevatorright.setCurrentAlert(4000, CurrentUnit.MILLIAMPS);


/*Direccion del motor*/
        elevatorleft.setDirection(DcMotorEx.Direction.REVERSE);//FORDWARD
        elevatorright.setDirection(DcMotorSimple.Direction.FORWARD);//REVERSE


        /*Los tiks sean 0*/
        elevatorleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        elevatorright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        /*Para mantener los motores fijos*/

        elevatorleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        elevatorright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }



    public void resetTicks() {
        elevatorleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        elevatorright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }



    public boolean isAtSetPoint() {
        boolean isAtSetPoint = elevatorleft.getCurrentPosition() - elevatorleft.getTargetPosition() < elevatorleft.getTargetPositionTolerance();
        return isAtSetPoint;
    }

    public int getElevatorPosition() {
        return elevatorright.getCurrentPosition();
    }

    public void setPosition(int pos){
        elevatorleft.setPower(1);
        elevatorleft.setTargetPosition(pos);
        elevatorleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        elevatorright.setPower(1);
        elevatorright.setTargetPosition(pos);
        elevatorright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public  void velocidad(int vel){
        elevatorleft.setVelocity(vel);
        elevatorright.setVelocity(vel);
    }

    public void setPower(double power){
        elevatorleft.setPower(power);
        elevatorright.setPower(power);
    }

    /*@Override
    public  void periodic(){
        telemetry.addData("Elevator right position", elevatorright.getCurrentPosition());
        telemetry.addData("Elevator left position", elevatorleft.getCurrentPosition());
        telemetry.addData("Voltage left elevator motor", elevatorleft.getCurrent(CurrentUnit.MILLIAMPS));
        telemetry.addData("Voltage right elevator motor", elevatorright.getCurrent(CurrentUnit.MILLIAMPS));

        //telemetry.addData("Elevator left v", brazoizq.isOverCurrent());
        //telemetry.addData("Elevator right v", brazoder.isOverCurrent());
    }*/
}