package com.thoughtworks.movierental;

import org.junit.Test;

import static com.thoughtworks.movierental.CustomerTestUtils.getTestCustomer;
import static com.thoughtworks.movierental.CustomerTestUtils.getTestCustomerStatement;

public class CustomerTest {
    @Test
    public void testStatementReturnString(){
        assert getTestCustomerStatement().length() > 0;
    }

    @Test
    public void testForNameIsCorrect(){
        assert getTestCustomerStatement().contains("Rental Record for "+ CustomerTestConsts.testCustomerName + "\n");
    }

    @Test
    public void testAmountOwedIsCorrect() {
        Customer testCustomer = getTestCustomer();
        testCustomer.addRental(new Rental(new Movie("Test Movie", Movie.CHILDRENS), 10));
        assert getTestCustomerStatement(testCustomer).contains("Amount owed is 12.0");
    }

    @Test
    public void testMovieNameIsCorrect() {
        Customer testCustomer = getTestCustomer();
        testCustomer.addRental(new Rental(new Movie("Test Movie", Movie.CHILDRENS), 10));
        assert getTestCustomerStatement(testCustomer).contains("Test Movie");
    }

    @Test
    public void testYouEarnedFrequestPointsIsCorrect() {
        Customer testCustomer = getTestCustomer();
        testCustomer.addRental(new Rental(new Movie("Test Movie", Movie.CHILDRENS), 10));
        assert getTestCustomerStatement(testCustomer).contains("You earned 1 frequent renter points");
    }

    @Test
    public void testLineCountIsCorrect() {
        Customer testCustomer = getTestCustomer();
        testCustomer.addRental(new Rental(new Movie("Test Movie", Movie.CHILDRENS), 10));
        assert getTestCustomerStatement(testCustomer).chars().filter(ch -> ch =='\n').count() == 3;
    }
}