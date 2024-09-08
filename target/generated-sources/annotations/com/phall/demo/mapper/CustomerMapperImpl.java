package com.phall.demo.mapper;

import com.phall.demo.entity.Customer;
import com.phall.demo.request.CustomerRequest;
import com.phall.demo.response.CustomerResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-08T21:49:05+0700",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toEntity(CustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setCustomerAddress( request.getCustomerAddress() );
        customer.setCustomerEmail( request.getCustomerEmail() );
        customer.setCustomerEngName( request.getCustomerEngName() );
        customer.setCustomerLocalName( request.getCustomerLocalName() );
        customer.setCustomerPhone( request.getCustomerPhone() );

        return customer;
    }

    @Override
    public CustomerResponse toDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setCustomerAddress( customer.getCustomerAddress() );
        customerResponse.setCustomerEmail( customer.getCustomerEmail() );
        customerResponse.setCustomerEngName( customer.getCustomerEngName() );
        customerResponse.setCustomerLocalName( customer.getCustomerLocalName() );
        customerResponse.setCustomerPhone( customer.getCustomerPhone() );
        if ( customer.getId() != null ) {
            customerResponse.setId( customer.getId().intValue() );
        }

        return customerResponse;
    }
}
