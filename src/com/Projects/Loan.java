package com.Projects;

import java.time.LocalDateTime;

public class Loan {
    private double annualInterestRate;
    private String annualInterestRateString;//String duplicate of annualInterestRate with % sign
    private int numberOfYears;
    private double loanAmount;
    private LocalDateTime dateTime;

    //default constructor that calls the constructor that accepts double, int and double as parameters
    public Loan(){
        this(2.5d, 1, 1000d);
    }

    //constructor that asks the user for a String interestRate
    //It then calls other constructor and passes the interest, number of years and loan amount
    public Loan(String annualInterestRateString){
        this(annualInterestRateString, 1, 1000);
    }

    public Loan(Double annualInterestRate){
        this(annualInterestRate, 1, 1000);
    }

    //Constructor for user amount of years
    //It then calls on the constructor that accepts double int and double as parameters
    public Loan(int years){
        this(2.5d, years, 1000d);
    }

    //Constructor that takes user input for interest and the loan amount
    //It then calls the constructor that accepts double int double as parameters
    //and passes both variables as parameters
    public Loan(double annualInterestRate, double loanAmount){
        this(annualInterestRate, 1, loanAmount);
    }

    //Constructor that takes user input for interest as a String and the loan amount
    //It then calls the constructor that accepts String, int, double as parameters
    //and passes both variables as parameters
    public Loan(String annualInterestRateString, double loanAmount){
        this(annualInterestRateString, 1, loanAmount);
    }

    //Constructor that takes user input for String interest, number of years and the loan amount
    //the String is then converted to a double and assigned to annualInterestRate
    public Loan(String annualInterestRateString, int numberOfYears, double loanAmount){
        this.annualInterestRate = Double.parseDouble(annualInterestRateString.substring(0, annualInterestRateString.indexOf('%')));
        this.annualInterestRateString = annualInterestRateString;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.dateTime = dateTime.now();
    }
    //Constructor that takes user input for interest, number of years and the loan amount
    //the annualInterestRate is then  converted to a String
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount){
        this.annualInterestRate = annualInterestRate;
        this.annualInterestRateString = annualInterestRate + "%";
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.dateTime = dateTime.now();
    }

    public double getMonthlyRepayment(){
        int months = this.numberOfYears*12;
        double payment = getTotalPayment();
        return payment/months;
    }

    //this method multiplies the loan amount by the interest rate
    //using the formula A = (1 + r/n)nt
    public double getTotalPayment(){
        int months = this.numberOfYears*12;
        double interest = this.annualInterestRate/100;
        double total  = this.loanAmount*(Math.pow((1 + interest/months), months*this.numberOfYears));

        return total;
    }

    @Override
    public String toString(){
        return "\nInterest rate: " + this.annualInterestRateString + "\nYears: " + this.numberOfYears + "\nInitial loan amount: " + this.loanAmount + "\nTotal to be re-payed: " + round(this.getTotalPayment(),2) + "\nMonthly repayment: " + round(this.getMonthlyRepayment(),2) + "\nDate time: " + getDate();
    }

    private double round(double number, int precision){
        //first, multiply 10 by the expected number of decimal places
        int decimalPlaces = (int)Math.pow(10, precision);
        //now multiply the number the precision, round the number a,d then divided again by precision and cast to a double to get the correct
        //number of deciaml places
        double rounded = (double)Math.round(number*decimalPlaces)/decimalPlaces;
        return rounded;
    }

    ////Setters////
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
        //When setting the annualInterest Variable, the String should also be updated accordingly
        this.annualInterestRateString = annualInterestRate + "%";
    }

    public void setAnnualInterestRateString(String annualInterestRateString) {
        this.annualInterestRateString = annualInterestRateString;
        //When setting the annualInterestString Variable, the double variable should also be updated accordingly
        //This achieved by using a substring to remove the %. The String is then parsed to a double value
        this.annualInterestRate = Double.parseDouble(annualInterestRateString.substring(0, annualInterestRateString.indexOf('%')));
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setDate(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    //////Getters//////
    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    public String getAnnualInterestRateString() {
        return this.annualInterestRateString;
    }

    public int getNumberOfYears() {
        return this.numberOfYears;
    }

    public double getLoanAmount() {
        return this.loanAmount;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public String getDate() {
        return dateTime.getDayOfMonth() + "/" + dateTime.getMonthValue() + "/" + dateTime.getYear();
    }


}
