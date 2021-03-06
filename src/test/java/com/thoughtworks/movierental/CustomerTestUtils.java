package com.thoughtworks.movierental;

public class CustomerTestUtils {
    public static Customer getTestCustomer() {
        return new Customer(CustomerTestConsts.testCustomerName);
    }

    public static String getTestCustomerStatement() {
        return getTestCustomer().statement();
    }

    public static String getTestCustomerHtmlStatement() {
        return getTestCustomer().htmlStatement();
    }

    public static String getTestCustomerHtmlStatement(Customer customer) {
        return customer.htmlStatement();
    }

    public static String getTestCustomerStatement(Customer customer) {
        return customer.statement();
    }
}
