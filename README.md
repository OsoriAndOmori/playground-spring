## spring 테스트 용, 공유 용

```
docker run --name local-my-mariadb \
-v $HOME/db/maria:/var/lib/mysql -p 3306:3306 \
-e MARIADB_ROOT_PASSWORD=osori \
-e MARIADB_USER=osori -e MARIADB_PASSWORD=osori \
-d mariadb:latest
```