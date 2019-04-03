package com.thoughtworks.movierental;

public class TextStatement {
    public static String getStatementFor(Rentals rentals) {
        String result = "Rental Record for " + rentals.getCustomer().getName() + "\n";

        for (Rental rental : rentals.getCustomer().getRental()) {
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getRentAmount() + "\n";
        }

        //add footer lines result
        result += "Amount owed is " + rentals.getTotalAmountOwed() + "\n";
        result += "You earned " + rentals.getTotalFrequentRenterPoints() + " frequent renter points";

        return result;
    }
}
