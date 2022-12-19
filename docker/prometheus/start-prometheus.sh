docker build --tag starter/monitoring-prometheus:1.0 .
docker run -d \
-p 30090:9090 \
--name spring-monitoring-starter-prometheus \
starter/monitoring-prometheus:1.0
