
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

|FieldName                 |Format                |Description|Sources|
|---                       |---                   |---        |---    |
|[DATASOURCE](datasource-2)|[all-of](datasource-2)|           |       |
|[DATASOURCE](datasource-1)|[all-of](datasource-1)|           |       |
|[DATASOURCE](datasource)  |[all-of](datasource)  |           |       |

### DATASOURCE

|FieldName|Format   |Description                                               |Sources|
|---      |---      |---                                                       |---    |
|TYPE     |primitive|value of type string, Expecting a constant string Database|hocon  |
|HOST     |primitive|value of type string                                      |hocon  |
|PASSWORD |primitive|value of type string                                      |hocon  |
|USERNAME |primitive|value of type string                                      |hocon  |
|PORT     |primitive|value of type int                                         |hocon  |

### DATASOURCE

|FieldName|Format   |Description                                            |Sources|
|---      |---      |---                                                    |---    |
|TYPE     |primitive|value of type string, Expecting a constant string Kafka|hocon  |
|TOPICNAME|primitive|value of type string                                   |hocon  |
|BROKERS  |list     |value of type string                                   |hocon  |

### DATASOURCE

|FieldName |Format   |Description                                               |Sources|
|---       |---      |---                                                       |---    |
|TYPE      |primitive|value of type string, Expecting a constant string S3Bucket|hocon  |
|BUCKETNAME|primitive|value of type string                                      |hocon  |
|PREFIX    |primitive|value of type string                                      |hocon  |
