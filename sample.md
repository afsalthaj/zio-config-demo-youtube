
## Configuration Details


|FieldName|Format                     |Description|Sources|
|---      |---                        |---        |---    |
|         |[all-of](fielddescriptions)|           |       |

### Field Descriptions

|FieldName       |Format              |Description                                                           |Sources|
|---             |---                 |---                                                                   |---    |
|[source](source)|[any-one-of](source)|Config related to ETL frameworks                                      |       |
|region          |primitive           |value of type string, optional value, Config related to ETL frameworks|hocon  |

### source

|FieldName           |Format            |Description|Sources|
|---                 |---               |---        |---    |
|[Database](database)|[all-of](database)|           |       |
|[Kafka](kafka)      |[all-of](kafka)   |           |       |
|[S3Bucket](s3bucket)|[all-of](s3bucket)|           |       |

### Database

|FieldName|Format   |Description                                          |Sources|
|---      |---      |---                                                  |---    |
|host     |primitive|value of type string, HOST name if source is database|hocon  |
|password |primitive|value of type string                                 |hocon  |
|username |primitive|value of type string                                 |hocon  |
|port     |primitive|value of type int, Port if source is a database      |hocon  |

### Kafka

|FieldName|Format   |Description                      |Sources|
|---      |---      |---                              |---    |
|topicName|primitive|value of type string             |hocon  |
|brokers  |list     |value of type string, Topics that|hocon  |

### S3Bucket

|FieldName |Format   |Description         |Sources|
|---       |---      |---                 |---    |
|bucketName|primitive|value of type string|hocon  |
|prefix    |primitive|value of type string|hocon  |
