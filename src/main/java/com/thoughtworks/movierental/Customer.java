package com.thoughtworks.movierental;

import java.util.List;

import static com.thoughtworks.movierental.HtmlUtils.*;

public class Customer {
  private String name;
  private Rentals rentals;

  public Customer(String name) {
    this.name = name;
    rentals = new Rentals(this);
  }

  public void addRental(Rental arg) {
    rentals.addRental(arg);
  }

  public List<Rental> getRental() {
    return rentals.getRentals();
  }

  public String getName() {
    return name;
  }

  public String statement() {
    return TextStatement.getStatementFor(rentals);
  }

  public String htmlStatement() {
    String result = getAsHeading("Rental Record for " + getAsBold(getName()) + LINE_BREAK);

    for (Rental rental : rentals.getRentals()) {
      //show figures for this rental
      result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getRentAmount() + LINE_BREAK;
    }

    //add footer lines result
    result += "Amount owed is " + getAsBold(rentals.getTotalAmountOwed()) + LINE_BREAK;
    result += "You earned " + getAsBold(rentals.getTotalFrequentRenterPoints()) + " frequent renter points";

    return result;
  }

}

