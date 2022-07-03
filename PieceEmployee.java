//********************************************************************
//
//  Developer:     Cory Munselle
//
//  Project #:     One
//
//  File Name:     PieceEmployee.java
//
//  Course:        COSC 4301 - Modern Programming
//
//  Due Date:      2/13/2022
//
//  Instructor:    Fred Kumi
//
//  Description:   Extends the employee class, adding wage
//                 and pieces as well as exception handling
//                 for both
//
//********************************************************************

package project1;

public class PieceEmployee extends Employee{

    private final double wage;
    private final double pieces;

    //***************************************************************
    //
    //  Method:       PieceEmployee
    //
    //  Description:  The constructor of the program
    //
    //  Parameters:   String firstName, String lastName, String socialSecurityNumber,
    //                double wage, double pieces
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public PieceEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double pieces) {
        super(firstName, lastName, socialSecurityNumber);

        if (wage > 0.0)
            this.wage = wage;
        else
            throw new IllegalArgumentException("Wage must be above zero.");

        if (pieces >= 0.0)
            this.pieces = pieces;
        else
            throw new IllegalArgumentException("Pieces must be greater than or equal to zero.");
    }

    //***************************************************************
    //
    //  Method:       getWage & getPieces
    //
    //  Description:  getters for PieceEmployee class
    //
    //  Parameters:
    //
    //  Returns:      wage and pieces
    //
    //**************************************************************
    public double getWage() {
        return wage;
    }

    public double getPieces() {
        return pieces;
    }

    //***************************************************************
    //
    //  Method:       earnings
    //
    //  Description:  Override for the virtual earnings method in the Employee class
    //                with wage and pieces
    //
    //  Parameters:
    //
    //  Returns:      wage * pieces
    //
    //**************************************************************
    @Override
    public double earnings()
    {
        return wage * pieces;
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
        return String.format("Piece Employee: %s %s%nSocial Security Number: %s%nPieces Produced: $%.0f; Pay per Piece: %.2f%n",
                super.getFirstName(), super.getLastName(), super.getSocialSecurityNumber(), this.pieces, this.wage);
    }

}
