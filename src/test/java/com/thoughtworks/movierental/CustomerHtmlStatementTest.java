package com.thoughtworks.movierental;

import org.junit.Test;

import static com.thoughtworks.movierental.CustomerTestUtils.getTestCustomer;
import static com.thoughtworks.movierental.CustomerTestUtils.getTestCustomerHtmlStatement;

public class CustomerHtmlStatementTest {
    @Test
    public void testStatementReturnString(){
        assert getTestCustomerHtmlStatement().length() > 0;
    }

    @Test
    public void testForNameIsCorrect(){
        assert getTestCustomerHtmlStatement().contains("<h1>Rental Record for <b>"+ CustomerTestConsts.testCustomerName + "</b><br></h1>");
    }

    @Test
    public void testAmountOwedIsCorrect() {
        Customer testCustomer = getTestCustomer();
        testCustomer.addRental(new Rental(new Movie("Test Movie", Movie.CHILDRENS), 10));
        assert getTestCustomerHtmlStatement(testCustomer).contains("Amount owed is <b>12.0</b>");
    }

    @Test
    public void testMovieNameIsCorrect() {
        Customer testCustomer = getTestCustomer();
        testCustomer.addRental(new Rental(new Movie("Test Movie", Movie.CHILDRENS), 10));
        assert getTestCustomerHtmlStatement(testCustomer).contains("Test Movie");
    }

    @Test
    public void testYouEarnedFrequestPointsIsCorrect() {
        Customer testCustomer = getTestCustomer();
        testCustomer.addRental(new Rental(new Movie("Test Movie", Movie.CHILDRENS), 10));
        assert getTestCustomerHtmlStatement(testCustomer).contains("You earned <b>1.0</b> frequent renter points");
    }
}
