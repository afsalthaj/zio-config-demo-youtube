
## Configuration Details


|FieldName|Format                     |Description|Sources|
|---      |---                        |---        |---    |
|         |[all-of](fielddescriptions)|           |       |

### Field Descriptions

|FieldName       |Format              |Description                                                       |Sources|
|---             |---                 |---                                                               |---    |
|[source](source)|[any-one-of](source)|ETL framework related config                                      |       |
|region          |primitive           |value of type string, optional value, ETL framework related config|hocon  |

### source

|FieldName           |Format            |Description|Sources|
|---                 |---               |---        |---    |
|[Database](database)|[all-of](database)|           |       |
|[Kafka](kafka)      |[all-of](kafka)   |           |       |
|[S3Bucket](s3bucket)|[all-of](s3bucket)|           |       |

### Database

|FieldName|Format   |Description                                                       |Sources|
|---      |---      |---                                                               |---    |
|host     |primitive|value of type string, Host of the database (if source is database)|hocon  |
|password |primitive|value of type string, Database password                           |hocon  |
|userName |primitive|value of type string, Database username                           |hocon  |
|port     |primitive|value of type int, Port if the source is a database               |hocon  |

### Kafka

|FieldName|Format   |Description         |Sources|
|---      |---      |---                 |---    |
|topicName|primitive|value of type string|hocon  |
|brokers  |list     |value of type string|hocon  |

### S3Bucket

|FieldName |Format   |Description         |Sources|
|---       |---      |---                 |---    |
|bucketName|primitive|value of type string|hocon  |
|prefix    |primitive|value of type string|hocon  |
