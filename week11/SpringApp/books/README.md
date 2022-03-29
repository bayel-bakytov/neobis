# For Dockerfile
1. Download mysql image: ```docker pull mysql```
2. Run MySQL container: ```docker run --name mysqldb -e MYSQL_DATABASE=bookstore -e MYSQL_ROOT_PASSWORD=baiel_admin -e MYSQL_PASSWORD=baiel_admin -d mysql```
3. Check MySQL logs: ```docker container logs mysqldb```
4. Build an application container: ```docker build -t app .```
5. Run an application container: ```docker run -d -p 8080:8080 --name app --link mysqldb:mysql app```
6. Check an application container logs: ```docker container logs app```
7. Done!

# For docker-compose
Run docker-compose: ```docker-compose up --build```