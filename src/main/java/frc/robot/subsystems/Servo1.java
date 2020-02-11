/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Servo;


public class Servo1 extends SubsystemBase {
  /**
   * Creates a new Servo1.
   */
 Servo newServo = new Servo(1);
 



  public Servo1() {
    newServo.set(Constants.testServoValue);
 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
