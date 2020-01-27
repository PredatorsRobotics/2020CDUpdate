/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class MotorMovementCommand extends CommandBase {

  private final Drivetrain m_driveTrainSubsystem;

  /**
   * Creates a new MotorMovementCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public MotorMovementCommand(Drivetrain subsystem) {
    m_driveTrainSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /*
    *  This is where you tell the command what to run. Whatever methods get put here will run whenever this command is active, so ideally when the button is pressed. 
    */
    m_driveTrainSubsystem.moveASingleMotorLeft();
  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTrainSubsystem.stopASingleMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
