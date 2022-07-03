//********************************************************************
//
//  Developer:     Cory Munselle
//
//  Project #:     One
//
//  File Name:     SalariedEmployee.java
//
//  Course:        COSC 4301 - Modern Programming
//
//  Due Date:      2/13/2022
//
//  Instructor:    Fred Kumi
//
//  Description:   Extends the employee class, adding salary
//                 as well as exception handling
//
//********************************************************************

package project1;

public class SalariedEmployee extends Employee{

    private final double salary;

    //***************************************************************
    //
    //  Method:       SalariedEmployee
    //
    //  Description:  The constructor of the program
    //
    //  Parameters:   String firstName, String lastName, String socialSecurityNumber,
    //                double salary
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double salary) {
        super(firstName, lastName, socialSecurityNumber);

        if (salary > 0.0)
            this.salary = salary;
        else
            throw new IllegalArgumentException("Salary must be greater than zero.");
    }

    //***************************************************************
    //
    //  Method:       getSalary
    //
    //  Description:  getters for SalariedEmployee class
    //
    //  Parameters:
    //
    //  Returns:      salary
    //
    //**************************************************************
    public double getSalary() {
        return salary;
    }

    //***************************************************************
    //
    //  Method:       earnings
    //
    //  Description:  Override for the virtual earnings method in the Employee class
    //                with salary
    //
    //  Parameters:
    //
    //  Returns:      salary
    //
    //**************************************************************
    @Override
    public double earnings() {
        return this.salary;
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
        return String.format("Salaried Employee: %s %s%nSocial Security Number: %s%nSalary: $%.2f",
                super.getFirstName(), super.getLastName(), super.getSocialSecurityNumber(), this.earnings());
    }
}
