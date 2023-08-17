package com.customer.manage.repo;

import com.customer.manage.model.Customer;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CouchbaseRepository<Customer,Integer> {
}
