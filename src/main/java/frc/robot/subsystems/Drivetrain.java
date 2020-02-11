 /*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  public DifferentialDrive m_drive;

  public Joystick driverJoystick;

  /*
  *  If you define your variables in your class definition, the public Drivetrain method, 
  *  you can only use them there. If you ever wanted to test the motors outside of that method 
  *  you would have to redefine them. This just allows you to be able to use the speed controllers whenever you need to.
  */
  private SpeedController frontLeftMotor;
  private SpeedController rearLeftMotor;
  private SpeedController frontRightMotor;
  private SpeedController rearRightMotor;

  /*
  *  This is the definition of the new single motor, name it what you would like.
  */
  private SpeedController singleMotor;

  /*
  *  This is the same thing as with the speed controller definitions, it just allows you more control over your motors.
  */
  private SpeedControllerGroup leftSideGroup;
  private SpeedControllerGroup rightSideGroup;

  /**
   * Creates a new drivetrain.
   */
  public Drivetrain(Joystick tempJoystick) {

    driverJoystick = tempJoystick;
  
    /*
    *  This is the actual assignment of the speed controllers. This sets the actual variable to a device ID.
    */
    //Motor controllers for 4 drive motors
    frontLeftMotor = new Spark(0);
    rearLeftMotor = new Spark(1);
    frontRightMotor = new Spark(2);
    rearRightMotor = new Spark(3);

    /*
    *  This is where you would need to set the device ID of the new motor.
    */
    singleMotor = new Spark(4); 
    
    //Speed Controller Groups that allow independent motor control for seperate sides
    leftSideGroup = new SpeedControllerGroup(frontLeftMotor, rearLeftMotor);
    rightSideGroup = new SpeedControllerGroup(frontRightMotor, rearRightMotor);

    m_drive = new DifferentialDrive(leftSideGroup, rightSideGroup);
  
    }  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    /*
    *  This is where you used to have the arcade drive. This is good for some short term testing, 
    *  but if you want to be able to call it in a command you need to move it outside of this method.
    */
  }

  public void driveWithArcade() {

    /*
    *  This is where you need to actually run your code. You need a sperate method for every "action" that needs to be taken.
    *  For example, you need a method for running the arcade drive, and one for moving the motor.
    *  This is what the commands will call and will use to run your robot. My team currently uses the depreciated "getRawAxis" method, so I
    *  am unsure if this will actually work, but I assume it does. 
    */

    m_drive.arcadeDrive(driverJoystick.getY(GenericHID.Hand.kLeft),
                        driverJoystick.getX(GenericHID.Hand.kLeft));
  }

  public void stopDriveTrainMotors() {
    leftSideGroup.set(0);
    rightSideGroup.set(0);
  }

  public void moveASingleMotorLeft() {
    singleMotor.set(Constants.singleMotorPowerLevelLeft);
  }

  public void moveASingleMotorRight(){
    singleMotor.set(Constants.singleMotorPowerLevelRight);
  }


  public void stopASingleMotor() {
    singleMotor.set(0);
  }
}
