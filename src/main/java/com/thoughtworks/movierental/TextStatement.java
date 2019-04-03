package com.thoughtworks.movierental;

public class TextStatement {
    public static String getStatementFor(Customer customer, double totalAmountOwed, int totalFrequentRenterPoints) {
        String result = "Rental Record for " + customer.getName() + "\n";

        for (Rental rental : customer.getRental()) {
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getRentAmount() + "\n";
        }

        //add footer lines result
        result += "Amount owed is " + totalAmountOwed + "\n";
        result += "You earned " + totalFrequentRenterPoints + " frequent renter points";

        return result;
    }
}
