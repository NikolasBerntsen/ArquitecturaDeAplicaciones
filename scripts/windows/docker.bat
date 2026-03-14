@echo off
REM Levantar MySQL

docker start mysql >nul 2>&1 || (
docker run -d --name mysql -p 3306:3306 ^
  -e MYSQL_ROOT_PASSWORD=root ^
  -e MYSQL_DATABASE=arquitectura ^
  -e MYSQL_USER=appuser ^
  -e MYSQL_PASSWORD=password123 ^
  mysql:8
)

echo MySQL corriendo.