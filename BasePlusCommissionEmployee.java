//********************************************************************
//
//  Developer:     Cory Munselle
//
//  Project #:     One
//
//  File Name:     BasePlusCommissionEmployee.java
//
//  Course:        COSC 4301 - Modern Programming
//
//  Due Date:      2/13/2022
//
//  Instructor:    Fred Kumi
//
//  Description:   Extends the CommissionEmployee class, adding baseSalary
//                 as well as exception handling for both
//
//********************************************************************

package project1;

public class BasePlusCommissionEmployee extends CommissionEmployee{

    private final double baseSalary;

    //***************************************************************
    //
    //  Method:       BasePlusCommissionEmployee
    //
    //  Description:  The constructor of the program
    //
    //  Parameters:   String firstName, String lastName, String socialSecurityNumber,
    //                int grossSales, double commissionRate, double baseSalary
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, int grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

        if (baseSalary > 0)
            this.baseSalary = baseSalary;
        else
            throw new IllegalArgumentException("Base salary must be greater than zero.");
    }

    //***************************************************************
    //
    //  Method:       baseSalary
    //
    //  Description:  getters for BasePlusCommissionEmployee class
    //
    //  Parameters:
    //
    //  Returns:      baseSalary
    //
    //**************************************************************
    public double getBaseSalary() {
        return baseSalary;
    }

    //***************************************************************
    //
    //  Method:       earnings
    //
    //  Description:  Override for the virtual earnings method in the CommissionEmployee class
    //                with baseSalary, grossSales, and commissionRate
    //
    //  Parameters:
    //
    //  Returns:      baseSalary + grossSales * commissionRate
    //
    //**************************************************************
    @Override
    public double earnings() {
        return this.baseSalary + super.getGrossSales() * super.getCommissionRate();
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
        return String.format("Base + Commission Employee: %s %s%nSocial Security Number: %s%nBase Salary: $%.2f%nGross Sales: $%d; Commission Rate: %.2f%n",
                super.getFirstName(), super.getLastName(), super.getSocialSecurityNumber(), this.baseSalary, super.getGrossSales(), super.getCommissionRate());
    }

}
