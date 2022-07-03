//********************************************************************
//
//  Developer:     Cory Munselle
//
//  Project #:     One
//
//  File Name:     HourlyEmployee.java
//
//  Course:        COSC 4301 - Modern Programming
//
//  Due Date:      2/13/2022
//
//  Instructor:    Fred Kumi
//
//  Description:   Extends the employee class, adding grossSales
//                 and commissionRate as well as exception handling
//                 for both
//
//********************************************************************

package project1;

public class HourlyEmployee extends Employee{

    private double hoursWorked;
    private double overtimeHours;
    private final double hourlyWage;

    //***************************************************************
    //
    //  Method:       HourlyEmployee
    //
    //  Description:  The constructor of the program
    //
    //  Parameters:   String firstName, String lastName, String socialSecurityNumber,
    //                double hoursWorked, double hourlyWage
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double hoursWorked, double hourlyWage) {
        super(firstName, lastName, socialSecurityNumber);

        if (hoursWorked >= 0.0)
            this.hoursWorked = hoursWorked;
        else
            throw new IllegalArgumentException("Hours worked must be greater than or equal to zero.");

        if (hourlyWage > 0.0)
            this.hourlyWage = hourlyWage;
        else
            throw new IllegalArgumentException("Hourly wage must be greater than zero.");

        this.overtimeHours = 0.0;
    }

    //***************************************************************
    //
    //  Method:       getHoursWorked, getOvertimeHours & getHourlyWage
    //
    //  Description:  getters for HourlyEmployee class
    //
    //  Parameters:
    //
    //  Returns:      hoursWorked, overtimeHours, and hourlyWage
    //
    //**************************************************************
    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    //***************************************************************
    //
    //  Method:       earnings
    //
    //  Description:  Override for the virtual earnings method in the Employee class
    //                with hourlyWage, hoursWorked, and overtimeHours
    //
    //  Parameters:
    //
    //  Returns:      hoursWorked * hourlyWage + (overtimeHours * hourlyWage * 1.5)
    //
    //**************************************************************
    @Override
    public double earnings() {

        this.overtimeHours = Math.max(0, this.hoursWorked - 40);
        this.hoursWorked = this.hoursWorked - this.overtimeHours;
        return this.hoursWorked * this.hourlyWage + (this.overtimeHours * this.hourlyWage * 1.5);
    }

    //***************************************************************
    //
    //  Method:       toString
    //
    //  Description:  Override for the toString method in the base class
    //
    //  Parameters:
    //
    //  Returns:      Formatted string
    //
    //**************************************************************
    @Override
    public String toString()
    {
        return String.format("Hourly Employee: %s %s%nSocial Security Number: %s%nHourly Wage: $%.2f; Hours Worked: %.2f%n",
                super.getFirstName(), super.getLastName(), super.getSocialSecurityNumber(), this.hourlyWage, this.hoursWorked);
    }
}
