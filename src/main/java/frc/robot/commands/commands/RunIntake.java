package frc.robot.commands.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Intake.Intake;

public class RunIntake extends Command{
    private final Intake Intake;
    private boolean intakeOutake;

    public RunIntake(Intake Intake, boolean intakeOutake){
        this.Intake = Intake;
        this.intakeOutake = intakeOutake;
        addRequirements(Intake);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        double output = Constants.Intake.intakeVolts;
        if(intakeOutake){
            Intake.setIntakeOutake(true);
            output *= -1;
        }
        else{
            Intake.setIntakeOutake(false);
        }
        Intake.intakeSpin(output);
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void end(boolean interrupted){
        Intake.intakeSpin(0);
    }


    
}
