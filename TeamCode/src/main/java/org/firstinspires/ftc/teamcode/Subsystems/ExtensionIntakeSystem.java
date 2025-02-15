package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.util.Encoder;

public class ExtensionIntakeSystem extends SubsystemBase {
    Telemetry telemetry;
    HardwareMap hardwareMap;
    CRServo extension1, extension2;
    private final Encoder EncoderExtension1, EncoderExtension2;


    public ExtensionIntakeSystem(Telemetry telemetry, HardwareMap hardwareMap) {
        this.telemetry = telemetry;
        this.hardwareMap = hardwareMap;

        extension1 = hardwareMap.get(CRServo.class, "extension1");
        extension2 = hardwareMap.get(CRServo.class, "extension2");

        extension1.setDirection(DcMotorSimple.Direction.REVERSE);
        extension2.setDirection(DcMotorSimple.Direction.FORWARD);





        EncoderExtension2 = new Encoder(hardwareMap.get(DcMotorEx.class, "intake"));

        EncoderExtension1 = new Encoder(hardwareMap.get(DcMotorEx.class, "leftRear"));


        EncoderExtension1.setDirection(Encoder.Direction.REVERSE);
    }

  public void Extend(double power){
        extension1.setPower(power);
        extension2.setPower(power);
}

public double getEncoderPosition(){
      return   EncoderExtension1.getCurrentPosition();

}

    public double getEncoderPosition2(){
        return   EncoderExtension2.getCurrentPosition();
    }

@Override
    public void periodic(){

        telemetry.addData("extension1", EncoderExtension1.getCurrentPosition());


}







}

