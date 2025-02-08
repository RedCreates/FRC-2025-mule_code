// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class DriveConstants {
        public static final int kFrontLeftDriveCANID = 1;
        public static final int kFrontRightDriveCANID = 3;
        public static final int kBackLeftDriveCANID = 5;
        public static final int kBackRightDriveCANID = 7;

        public static final int kFrontLeftSteerCANID = 2;
        public static final int kFrontRightSteerCANID = 4;
        public static final int kBackLeftSteerCANID = 6;
        public static final int kBackRightSteerCANID = 8;

        public static final double rotationSlewRate = 2.0;
        public static final double directionSlewRate = 1.2;
        public static final double magLimiterSlewRate = 1.8;

        public static final double kTrackWidth = Units.inchesToMeters(29);
        public static final double kTrackLength = Units.inchesToMeters(29);

        public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
                new Translation2d(kTrackLength / 2, kTrackWidth / 2),
                new Translation2d(kTrackLength / 2, -kTrackWidth / 2),
                new Translation2d(-kTrackLength / 2, kTrackWidth / 2),
                new Translation2d(-kTrackLength / 2, -kTrackWidth / 2));

        public static final double kFrontLeftOffset = (-Math.PI / 2);
        public static final double kFrontRightOffset = 0;
        public static final double kBackLeftOffset = Math.PI;
        public static final double kBackRightOffset = (Math.PI / 2);

        public static final double kMaxSpeedMetersPerSec = 4.0; // max speed in mps
        public static final double kMaxAngSpeedRadiansPerSec = 2 * Math.PI; // max turning speed in rps
    }

    public static class ModuleConstants {
        public static final int kDrivingMotorPinionTeeth = 13;

        public static final boolean kTurningEncoderInverted = true;

        public static final double kDrivingMotorFreeSpeedRps = NeoMotorConstants.kFreeSpeedRpm / 60;
        public static final double kWheelDiameterMeters = 0.0762;
        public static final double kWheelCircumferenceMeters = kWheelDiameterMeters * Math.PI;

        // 45 teeth on the wheel's bevel gear, 22 teeth on the first-stage spur gear, 15
        // teeth on the bevel pinion
        public static final double kDrivingMotorReduction = (45.0 * 22) / (kDrivingMotorPinionTeeth * 15);
        public static final double kDriveWheelFreeSpeedRps = (kDrivingMotorFreeSpeedRps * kWheelCircumferenceMeters)
                / kDrivingMotorReduction;
    }

    public static final class OIConstants {
        public static final int kDriverControllerPort = 0;
        public static final int kCoPilotControllerPort = 1;
        public static final double kDriveDeadband = 0.05;
    }

    public static final class NeoMotorConstants {
        public static final double kFreeSpeedRpm = 5676;
    }

    public static final class LEDConstants {
        public static final int kLEDBarPWM = 9;
        public static final int ledLength = 40;
        public static final int ledBufferLength = 40;
    }

    public static final class AutoConstants {
        public static final double kMaxSpeedMetersPerSecondStandard = 1.75;
        public static final double kMaxAccelerationMetersPerSecondSquaredStandard = 2.25;

        public static final double kMaxSpeedMetersPerSecondFast = 2.25;
        public static final double kMaxAccelerationMetersPerSecondSquaredFast = 2.5;

        public static final double kMaxSpeedMetersPerSecondSlow = 1.45;
        public static final double kMaxAccelerationMetersPerSecondSquaredSlow = 1.75;

        public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
        public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;

        public static final double kPXController = 1;
        public static final double kPYController = 1;
        public static final double kPThetaController = 1;

        // Constraint for the motion profiled robot angle controller
        public static final TrapezoidProfile.Constraints kThetaControllerConstraints = new TrapezoidProfile.Constraints(
            kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);

        public static final TrajectoryConfig kTrajConfigStandard = new TrajectoryConfig(
            AutoConstants.kMaxSpeedMetersPerSecondStandard, AutoConstants.kMaxAccelerationMetersPerSecondSquaredStandard)
            .setKinematics(DriveConstants.kDriveKinematics);
        
        public static final TrajectoryConfig kTrajConfigFast = new TrajectoryConfig(
            AutoConstants.kMaxSpeedMetersPerSecondFast, AutoConstants.kMaxAccelerationMetersPerSecondSquaredFast)
            .setKinematics(DriveConstants.kDriveKinematics);

        public static final TrajectoryConfig kTrajConfigSlow = new TrajectoryConfig(
            AutoConstants.kMaxSpeedMetersPerSecondSlow, AutoConstants.kMaxAccelerationMetersPerSecondSquaredSlow)
            .setKinematics(DriveConstants.kDriveKinematics);

        public static final TrajectoryConfig kTrajConfigStandardBackwards = kTrajConfigStandard.setReversed(true);
        
        public static final TrajectoryConfig kTrajConfigFastBackwards = kTrajConfigFast.setReversed(true);

        public static final TrajectoryConfig kTrajConfigSlowBackwards = kTrajConfigSlow.setReversed(true);
    }
}