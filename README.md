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

## Prometheus
> SpringBoot 2.0 이상부터는 애플리케이션의 metric 측정을 위해서 Micrometer 를 제공한다.  
> SpringBoot 에서 기본 제공하는 Micrometer 를 이용한 metric 을 Prometheus 를 이용해서 수집, 그리고 Grafana 로 시각화한다.  

### Dependencies
> build.gradle
> ```groovy
> ...
> dependencies {
>   ...
>   implementation 'io.micrometer:micrometer-registry-prometheus'
>   ...
> }
> ...
> ```

### application.yml
> ```yaml
> ...
> management:
>    endpoints:
>        web:
>            exposure:
>                include: health, info, prometheus
> ...
> ```

### JUnit MockMvc
> prometheus 의 경우 mockMvc 를 이용한 통합테스트로 call 하면 404 에러가 반환됨.  
> 해당 SpringBootTest 의 properties 에 `management.metrics.export.prometheus.enabled=true` 추가   
> ```java
> @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
>   properties = "management.metrics.export.prometheus.enabled=true")
> ```

### 참조사이트
> [SpringBoot Application의 monitoring 시스템 구축하기](https://jongmin92.github.io/2019/12/04/Spring/prometheus/)

