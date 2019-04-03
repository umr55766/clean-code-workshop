package com.thoughtworks.movierental;

public class Rental {

  private int daysRented;
  private Movie movie;

  public Rental(Movie movie, int daysRented){
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  public double getRentAmount() {
    double thisAmount = 0;

    switch (this.getMovie().getPriceCode()) {
      case Movie.REGULAR:
        thisAmount += 2;

        if (this.getDaysRented() > 2)
          thisAmount += (this.getDaysRented() - 2) * 1.5;
        break;

      case Movie.NEW_RELEASE:
        thisAmount += this.getDaysRented() * 3;
        break;

      case Movie.CHILDRENS:
        thisAmount += 1.5;

        if (this.getDaysRented() > 3)
          thisAmount += (this.getDaysRented() - 3) * 1.5;
        break;
    }

    return thisAmount;
  }

  int frequentRenterPoints() {
    int frequentRenterPoints = 1;

    if (isBonusApplicable())
      frequentRenterPoints++;

    return frequentRenterPoints;
  }

  private boolean isBonusApplicable() {
    return (getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1;
  }
}
