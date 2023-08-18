package com.customer.manage.repo;

import com.customer.manage.model.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CouchbaseRepository<User,Integer> {
    @Query("#{#n1ql.selectEntity} WHERE email = $1")
    User findByEmail(String email);
    @Query("#{#n1ql.selectEntity} WHERE name = $1")
    List<User> findUsersByName(String name);


}
