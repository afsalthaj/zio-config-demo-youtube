
## Configuration Details


|FieldName|Format                     |Description|Sources|
|---      |---                        |---        |---    |
|         |[all-of](fielddescriptions)|           |       |

### Field Descriptions

|FieldName       |Format              |Description                         |Sources|
|---             |---                 |---                                 |---    |
|[SOURCE](source)|[any-one-of](source)|                                    |       |
|REGION          |primitive           |value of type string, optional value|hocon  |

### SOURCE

|FieldName           |Format            |Description|Sources|
|---                 |---               |---        |---    |
|[DATABASE](database)|[all-of](database)|           |       |
|[KAFKA](kafka)      |[all-of](kafka)   |           |       |
|[S3BUCKET](s3bucket)|[all-of](s3bucket)|           |       |

### DATABASE

|FieldName|Format   |Description         |Sources|
|---      |---      |---                 |---    |
|HOST     |primitive|value of type string|hocon  |
|PASSWORD |primitive|value of type string|hocon  |
|USERNAME |primitive|value of type string|hocon  |
|PORT     |primitive|value of type int   |hocon  |

### KAFKA

|FieldName|Format   |Description         |Sources|
|---      |---      |---                 |---    |
|TOPICNAME|primitive|value of type string|hocon  |
|BROKERS  |list     |value of type string|hocon  |

### S3BUCKET

|FieldName |Format   |Description         |Sources|
|---       |---      |---                 |---    |
|BUCKETNAME|primitive|value of type string|hocon  |
|PREFIX    |primitive|value of type string|hocon  |
