#!/bin/bash
# Levantar MySQL y RabbitMQ en Docker 

docker start mysql 2>/dev/null || \
docker run -d --name mysql -p 3306:3306 \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=arquitectura \
  -e MYSQL_USER=appuser \
  -e MYSQL_PASSWORD=password123 \
  mysql:8

docker start rabbitmq 2>/dev/null || \
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 \
  rabbitmq:3-management-alpine

echo "MySQL y RabbitMQ corriendo."
