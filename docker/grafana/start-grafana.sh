docker build --tag starter/monitoring-grafana:1.0 .
docker run -d \
-p 3000:3000 \
--name spring-monitoring-starter-grafana \
starter/monitoring-grafana:1.0
