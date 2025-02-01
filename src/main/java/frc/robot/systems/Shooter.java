package frc.robot.systems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkBase.PersistMode;

public class Shooter {
    
    private SparkFlex motor;
    
    public Shooter(SparkFlex motor) {
        this.motor = motor;
        
        SparkFlexConfig config = new SparkFlexConfig();
        config
            .idleMode(IdleMode.kCoast)
            .inverted(false);

        motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        motor.set(0);
    }

    public void increaseSpeed() {
        double currentSpeed = motor.get();
        if (currentSpeed == 1.0) motor.set(1);
        else motor.set(currentSpeed + 0.1);
    }

    public void decreaseSpeed() {
        double currentSpeed = motor.get();
        if (currentSpeed == 0.0) motor.set(0);
        else motor.set(currentSpeed - 0.1);
    }

    public void stop() {
        motor.set(0);
    }
}
