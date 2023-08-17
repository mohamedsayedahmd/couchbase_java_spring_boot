
# Spring Boot, Couchbase
___

### This project was created with Spring Boot and Couchbase technology, in addition, This project consists of 2 buckets, the first one called "customer" and the second one called "user".
### We must add an index to the bucket after creating any bucket.
& go to Query at Couchbase
& type the following command :
```
CREATE PRIMARY INDEX `#primary` ON `bucketName`
```

### Relevant Requests for customer Bucket: 

- POST REQUEST: http://localhost:8010/customers/
```
{
    "id": "555",
    "name" : "Rami Sayed 1",
    "address" : ["Sakhnin", "City", "Country"]
}
```
- GET REQUEST : http://localhost:8010/customers/fetchAllCustomers

### Relevant Requests for user Bucket: 
- POST REQUEST: http://localhost:8010/users/ :
```
{
    "id" : 121,
    "name": "Amer",
    "email" : "Amer@gmail.com"
}
```
- GET REQUEST : http://localhost:8010/users/getAllUsers

___
This Project has 5 Packages That I had create :
- controller
- model
- service
- repo
- config

___

## Others :
server port : 8010
