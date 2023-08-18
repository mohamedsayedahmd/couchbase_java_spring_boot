package com.customer.manage.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
@Data
public class User {
    @Id
    private Integer id;
    private String name;
    private String email;
    private String password;
}
