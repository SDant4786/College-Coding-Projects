/*Project 17-2: Conversions from file
Author: Spencer Dant
11/3/2018

Conversion class
*/
package project172.pkg;


public class Conversion {

    private double fromValue, toValue, conversionRatio;
    private String fromUnit, toUnit;
    
public Conversion(double fromValue, double toValue, double conversionRatio, String 
        fromUnit, String toUnit){
    this.fromValue = fromValue;
    this.toValue = toValue;
    this.conversionRatio = conversionRatio;
    this.fromUnit = fromUnit;
    this.toUnit = toUnit;
}

public Conversion(){
fromValue = 0;
toValue = 0;
conversionRatio = 0;
fromUnit = "";
toUnit = "";
}

public void setFromValue(double fromValue){
    this.fromValue= fromValue;
}

public double getFromValue(){
    return this.fromValue;
}

public void setToValue(double toValue){
    this.toValue = toValue;
}

public double getToValue(){
    return this.toValue;
}

public void setConversionRatio(double conversionRatio){
    this.conversionRatio = conversionRatio;
}

public double getConversionRatio(){
    return this.conversionRatio;
}

public void setFromUnit(String fromUnit){
    this.fromUnit = fromUnit;
}

public String getFromUnit(){
    return this.fromUnit;
}

public void setToUnit(String toUnit){
    this.toUnit = toUnit;
}

public String getToUnit(){
    return this.toUnit;
}

public Double convert(){
    return this.toValue = this.fromValue * this.conversionRatio;
    
}
}
