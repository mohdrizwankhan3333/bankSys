package com.bank.bankSys.service;
import com.bank.bankSys.dto.customerdto.*;
import java.util.*;
public interface CustomerService {
    CustomerRes createCustomer(CustomerCreateReq req);

    Optional<CustomerRes> getCustomerById(Long id);
    List<CustomerRes> getAllCustomers();
    CustomerRes updateCustomer(Long id,CustomerUpdateReq req);
    void delete(Long id);
    Optional<CustomerRes> getByEmail(String email);

    Boolean customerExists(Long id);
}
