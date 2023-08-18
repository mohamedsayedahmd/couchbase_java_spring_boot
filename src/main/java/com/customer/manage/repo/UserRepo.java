package com.customer.manage.repo;

import com.customer.manage.model.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CouchbaseRepository<User,Integer> {
    @Query("#{#n1ql.selectEntity} WHERE email = $1")
    User findByEmail(String email);

}
