package com.Projects;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        double interestRate = 0d, loanAmount = 0d;
        int numberOfYears = 0;
        boolean error = false;
        do {
            //try get a double as input
            try {
                interestRate = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter interest"));
                //error is now false, so the loop will not repeat
                error = false;
            }
            //if we get an error we output an error message, and ask the user for input again
            catch (Exception anError) {
                //error is now true, so the loop will repeat
                error = true;
                JOptionPane.showConfirmDialog(null, "Error: " + anError.getMessage());
            }
        }while(error);

        do {
            try {
                numberOfYears = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter term in years"));
                error = false;
            } catch (Exception anError) {
                error = true;
                JOptionPane.showConfirmDialog(null, "Error: " + anError.getMessage());
            }
        }while(error);

        do {
            try {
                loanAmount = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter initial amount"));
                error = false;
            } catch (Exception anError) {
                error = true;
                JOptionPane.showConfirmDialog(null, "Error: " + anError.getMessage());
            }
        }while(error);

        Loan newLoan = new Loan(interestRate, numberOfYears, loanAmount);
        JOptionPane.showConfirmDialog(null, newLoan.toString());

    }
}