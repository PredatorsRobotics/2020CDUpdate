/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Servo1;


public class DriveWithArcade extends CommandBase {

  private Drivetrain m_driveTrainSubsystem;
  //private Servo1 servo1;
  private Servo tempServo;
 

  /**
   * Creates a new driveWithArcade.
   */
  public DriveWithArcade(Drivetrain tempSubsystem, Servo servo1) {

    m_driveTrainSubsystem = tempSubsystem;
    servo1 = tempServo;
    

    // Use addRequirements() here to declare subsystem dependencies.

    addRequirements(tempSubsystem);
   // addRequirements(tempServo);
   
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveTrainSubsystem.driveWithArcade();
    

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
