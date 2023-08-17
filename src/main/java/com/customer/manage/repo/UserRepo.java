package com.customer.manage.repo;

import com.customer.manage.model.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CouchbaseRepository<User,Integer> {
}
