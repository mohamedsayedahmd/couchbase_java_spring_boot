package com.customer.manage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Data // getters and setters for each field
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Customer {
    @Id
    private Integer id;
    @Field
    private String name;
    @Field
    private String[] address;
}
