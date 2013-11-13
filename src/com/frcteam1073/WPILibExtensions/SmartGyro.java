/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.frcteam1073.WPILibExtensions;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Gyro;

/**
 *
 * @author Evin Ugur
 */
public class SmartGyro extends Gyro{
    
    private GyroMode gyroMode;
    
    public SmartGyro(AnalogChannel channel) {
        super(channel);
         initialize();
    }
    public SmartGyro(int channel) {
        super(channel);
        initialize();
    }
    public SmartGyro(int slot, int channel) {
        super(slot, channel);
        initialize();
    }
    
    public void setGyroMode(GyroMode gyroMode) {
        this.gyroMode = gyroMode;
    }
    
    private void initialize() {
        // place initialization logic here
        gyroMode = GyroMode.radiansOverPi; // default angle representation
    }
    
    public double getAngle(){
       double angle = super.getAngle();
       switch (gyroMode) {
           case radians: return angle * Math.PI;
           case degrees: return Math.toDegrees(angle * Math.PI);
           default: return angle;
       }
    }
    
    public enum GyroMode {
        radiansOverPi,
        radians,
        degrees;
    }
}
