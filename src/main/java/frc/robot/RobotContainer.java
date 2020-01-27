/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.*;
/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final Joystick controller1 = new Joystick(0);

  private final JoystickButton runMotorButtonLeft = new JoystickButton(controller1, 5); //TODO: Change the 0 here to the button ID desired. Use DriverStation to find a button you would like
  private final JoystickButton runMotorButtonRight = new JoystickButton(controller1, 6);
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Drivetrain drivetrain = new Drivetrain(controller1);

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final MotorMovementCommand motorMovementCommand = new MotorMovementCommand(drivetrain);
  private final MotorMovementCommandRight motorMovementCommandRight = new MotorMovementCommandRight(drivetrain);
  private final DriveWithArcade driveWithArcade = new DriveWithArcade(drivetrain);




  

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // I'm not sure this line is nessicary with my edits
   // CommandScheduler.getInstance().registerSubsystem(drivetrain);

    /*
    *  This will run the DriveWithArcade command whenever no other command is running that uses the Drivetrain subsystem 
    */
    drivetrain.setDefaultCommand(driveWithArcade);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    CommandScheduler.getInstance().schedule(new RunCommand(() -> drivetrain.m_drive.arcadeDrive(
                                                                 controller1.getY(GenericHID.Hand.kLeft),
                                                                 controller1.getX(GenericHID.Hand.kLeft)),
                                                                 drivetrain));

    runMotorButtonLeft.whenHeld(motorMovementCommand, true);
    runMotorButtonRight.whenHeld(motorMovementCommandRight, true);
    
  }

  
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
