
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
___
## User Bucket
### Relevant Requests for user Bucket: 
## Register User
- POST REQUEST: http://localhost:8010/api/users/register :
```
{
    "id" : 3,
    "name": "mhmd",
    "email" : "mhmd3@gmail.com",
    "password" : "123456"
}
```
## Login User
- POST REQUEST : http://localhost:8010/api/users/login
```
{

    "username" : "Amer@gmail.com",
    "password" : "123456"
}

```
## Return All Users
- GET REQUEST : http://localhost:8010/users/getAllUsers
## Delete User By ID
- DELETE REQUEST : http://localhost:8010/api/users/delete/111143
___
## Find All the users with the same name
- GET REQUEST : http://localhost:8010/api/users/find-users-by-name/mhmd
___
This Project has 6 Packages That I had create :
- controller
- model
- service
- repo
- config
- exception

___

## Others :
server port : 8010
