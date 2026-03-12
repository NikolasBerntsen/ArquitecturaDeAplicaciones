#!/bin/bash
# Levantar la app

PROJECT_DIR="$(cd "$(dirname "$0")/../.." && pwd)"

cd "$PROJECT_DIR"
./mvnw spring-boot:run
