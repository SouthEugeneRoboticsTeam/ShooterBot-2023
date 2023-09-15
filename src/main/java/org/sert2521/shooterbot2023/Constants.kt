package org.sert2521.shooterbot2023

import edu.wpi.first.math.MatBuilder
import edu.wpi.first.math.Matrix
import edu.wpi.first.math.Nat
import edu.wpi.first.math.geometry.Translation2d
import edu.wpi.first.math.numbers.N1
import edu.wpi.first.math.numbers.N3
import kotlin.math.PI
import org.sert2521.shooterbot2023.commands.*
import org.sert2521.shooterbot2023.subsystems.*

/*
 * The Constants file provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This file should not be used for any other purpose.
 * All String, Boolean, and numeric (Int, Long, Float, Double) constants should use
 * `const` definitions. Other constant types should use `val` definitions.
 */

class SwerveModuleData(val position: Translation2d, val powerMotorID: Int, val angleMotorID: Int, val angleEncoderID: Int, val angleOffset: Double, val inverted: Boolean)

object PhysicalConstants
{
    const val angleEncoderMultiplier = 0.01745329251
    const val powerEncoderMultiplierPosition = PI * 0.1016 / 8.14
    // Velocity is in rpm so needs / 60
    const val powerEncoderMultiplierVelocity = powerEncoderMultiplierPosition / 60.0

    // REMEMBER TO CHANGE FOR SHOOTER BOT DEMENSIONS
    const val halfSideLength = 0.286378246381

}
object ConfigConstants
{
    const val drivetrainOptimized = true

    const val driveSpeed = 3.5

    const val powerDeadband = 0.075
    const val rotDeadband = 0.075

    const val driveSpeedup = 2.75

    const val driveSpeedupChangeSpeed = 6.5
    const val driveSlowdownChangeSpeed = 36.0

    const val rotSpeed = 3.5
    const val rotSpeedup = 2.75
}
object ElectronicIDs
{
    //REMEMBER TO CHANGE FOR SHOOTER BOT ELECTRONIC IDS
    val swerveModuleData = listOf(
            SwerveModuleData(Translation2d(PhysicalConstants.halfSideLength, -PhysicalConstants.halfSideLength), 4, 5, 14, 0.0, true),
            SwerveModuleData(Translation2d(-PhysicalConstants.halfSideLength, -PhysicalConstants.halfSideLength), 1, 2, 16, 0.0, true),
            SwerveModuleData(Translation2d(PhysicalConstants.halfSideLength, PhysicalConstants.halfSideLength), 12, 11, 13, 0.0, true),
            SwerveModuleData(Translation2d(-PhysicalConstants.halfSideLength, PhysicalConstants.halfSideLength), 7, 8, 15, 0.0, true))

}
object TunedConstants{
    val encoderDeviations: Matrix<N3, N1> = MatBuilder(Nat.N3(), Nat.N1()).fill(1.0, 1.0, 0.01)
    val defaultVisionDeviations: Matrix<N3, N1> = MatBuilder(Nat.N3(), Nat.N1()).fill(1.0, 1.0, 1000.0)

    const val swervePowerS = 0.3
    const val swervePowerV = 3.0
    const val swervePowerA = 0.0

    const val swervePowerP = 2.0
    const val swervePowerI = 0.0
    const val swervePowerD = 0.0


    const val swerveAngleP = 0.5
    const val swerveAngleI = 0.0
    const val swerveAngleD = 0.0

    val alignVisionDeviations: Matrix<N3, N1> = MatBuilder(Nat.N3(), Nat.N1()).fill(3.0, 3.0, 1000.0)

}



