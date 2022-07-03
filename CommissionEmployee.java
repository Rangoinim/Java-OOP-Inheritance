//********************************************************************
//
//  Developer:     Cory Munselle
//
//  Project #:     One
//
//  File Name:     CommissionEmployee.java
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

public class CommissionEmployee extends Employee{

    private final int grossSales;
    private final double commissionRate;

    //***************************************************************
    //
    //  Method:       CommissionEmployee
    //
    //  Description:  The constructor of the program
    //
    //  Parameters:   String firstName, String lastName, String socialSecurityNumber,
    //                int grossSales, double commissionRate
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, int grossSales, double commissionRate) {
        super(firstName, lastName, socialSecurityNumber);

        if (grossSales >= 0)
            this.grossSales = grossSales;
        else
            throw new IllegalArgumentException("Gross sales must be equal to or greater than zero.");

        if (commissionRate > 0)
            this.commissionRate = commissionRate;
        else
            throw new IllegalArgumentException("Commission rate must be above zero.");
    }

    //***************************************************************
    //
    //  Method:       getGrossSales & getCommissionRate
    //
    //  Description:  getters for CommissionEmployee class
    //
    //  Parameters:
    //
    //  Returns:      grossSales and commissionRate
    //
    //**************************************************************
    public int getGrossSales() {
        return grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    //***************************************************************
    //
    //  Method:       earnings
    //
    //  Description:  Override for the virtual earnings method in the Employee class
    //                with grossSales and commissionRate
    //
    //  Parameters:
    //
    //  Returns:      grossSales * commissionRate
    //
    //**************************************************************
    @Override
    public double earnings() {
        return (double)this.grossSales * this.commissionRate;
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
        return String.format("Commission Employee: %s %s%nSocial Security Number: %s%nGross Sales: $%d; Commission Rate: %.2f%n",
                super.getFirstName(), super.getLastName(), super.getSocialSecurityNumber(), this.grossSales, this.commissionRate);
    }

}
