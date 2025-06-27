
# Kotlinx + JobRunr + Spring Boot 3 Test Project

In this project, we investigate whether the three above components play nicely together. 

## Configuration

See `build.gradle`: to specify specific versions:

```
implementation 'org.jobrunr:jobrunr-spring-boot-3-starter:x.x.x'
implementation 'org.jobrunr:jobrunr-kotlin-2.1-support:x.x.x'
```

## Running

Start the Spring Boot app and launch http://localhost:8080/?name=john to enqueue a few sample jobs. 
See the Spring `SampleController` for more info. 

These should be serialized with kotlinx.serialization. 
