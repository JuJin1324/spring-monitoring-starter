# spring-monitoring-starter

## Spring Actuator
### info.env 설정
> `GET /actuator/info` 에 프로젝트 빌드 정보 표시하기
> build.gradle
> ```groovy
> ...
> springBoot {
>     buildInfo()
> }
> ...
> ```
> 프로젝트 빌드 정보 표시 중에 java.time.Instant 를 json 으로 표시하기 위해서는 `ObjectMapper` 를 Bean 으로 등록해야하며, 등록 시
> `JavaTimeModule` 을 등록한 ObjectMapper Bean 이어야한다.  
