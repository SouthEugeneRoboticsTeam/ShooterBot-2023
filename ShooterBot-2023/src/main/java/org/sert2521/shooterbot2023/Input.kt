package org.sert2521.shooterbot2023

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj2.command.button.JoystickButton
//import com.pathplanner.lib.auto.PIDConstants
//import com.pathplanner.lib.auto.SwerveAutoBuilder
import edu.wpi.first.math.geometry.Pose2d
import edu.wpi.first.math.geometry.Rotation2d
import edu.wpi.first.math.geometry.Translation2d
import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj.DriverStation.Alliance
import edu.wpi.first.wpilibj.GenericHID
import edu.wpi.first.wpilibj.XboxController.Button
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import edu.wpi.first.wpilibj2.command.*
import edu.wpi.first.wpilibj2.command.button.Trigger
import org.sert2521.shooterbot2023.commands.*
import org.sert2521.shooterbot2023.subsystems.Drivetrain
import kotlin.math.PI

object Input : SubsystemBase() {
    private val driverController = XboxController(0)
    private val gunnerController = Joystick(1)

    private val slowButton = JoystickButton(driverController, 5)


    var slowMode = false



    init{
        slowButton.onTrue(InstantCommand({ slowMode = !slowMode }))
    }

    fun getX(): Double {
        return -driverController.leftY
    }

    fun getY(): Double {
        return -driverController.leftX
    }

    fun getBrakePos(): Boolean {
        return driverController.xButton
    }

    // Rename fast stuff because it actually slows it
    fun getFast(): Double {
        return if (!slowMode) {
            driverController.leftTriggerAxis
        } else {
            1.0
        }
    }

    fun getRot(): Double {
        return -driverController.rightX
    }

}