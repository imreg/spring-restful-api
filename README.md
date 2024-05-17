# Jobs RestFul API Service

###Execute Server:

```
./mvnw spring-boot:run
```


### GET ALL

```
http://localhost:8080/api/jobs
```

### GET By Id

```
http://localhost:8080/api/jobs/{id}
```

### POST
```
http://localhost:8080/api/jobs
```

### Payload
```
{
    "title": "Junior React Developer",
    "type": {
        "id": 1,
        "title": "Full-Time"
    },
    "location": "Boston, MA",
    "description": "We are seeking a talented Front-End Developer to join our team in Boston, MA. The ideal candidate will have strong skills in HTML, CSS, and JavaScript, with experience working with modern JavaScript frameworks such as React or Angular.",
    "salary": "$70K - $90K",
    "company": {
        "name": "NewTek Solutions",
        "description": "NewTek Solutions is a leading technology company specializing in web development and digital solutions. We pride ourselves on delivering high-quality products and services to our clients while fostering a collaborative and innovative work environment.",
        "email": "contact@teksolutions.com",
        "phone": "555-555-5555"
    }
}
```


### PUT 
```
http://localhost:8080/api/jobs/{id}
```

### Payload
```
{
    "id": 1,
    "title": "Junior React Developer",
    "type": {
        "id": 1,
        "title": "Fullo-Time"
    },
    "location": "Boston, MA",
    "description": "We are seeking a talented Front-End Developer to join our team in Boston, MA. The ideal candidate will have strong skills in HTML, CSS, and JavaScript, with experience working with modern JavaScript frameworks such as React or Angular.",
    "salary": "$70K - $90K",
    "company": {
        "id": 1,
        "name": "NewTekkl Solutions",
        "description": "NewTek Solutions is a leading technology company specializing in web development and digital solutions. We pride ourselves on delivering high-quality products and services to our clients while fostering a collaborative and innovative work environment.",
        "email": "contact@teksolutions.com",
        "phone": "555-555-5555"
    }
}
```


### DELETE

```
http://localhost:8080/api/jobs/{id}
```
