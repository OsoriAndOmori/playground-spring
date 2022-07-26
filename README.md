## spring 테스트 용, 공유 용 Multi Module Application
- application layer
  - 실제 Application 담당할 layer, 현 mvc, reative, batch + cloud 까지 추가 예정
- domain layer
  - application 에서 쓸 domain 별 기능 분리
  - 로직은 없이 설정 위주로 들어갈 예정이나 공통된 로직의 경우 구현 가능
- etc
  - yaml-importer : domain 의 설정을 읽어주는 yaml integration tool
    - application 에선 최상위 모듈에 `implementation project(':etc-yaml-importer')` 만 추가시 자동 설정 로드 
  - coverage : 테스트코드 coverage with github action

## Spec
- domain-maria : RDBMS
- domain-mongo : reactive 전용 예정
- domain-neo4j : 공부용 예정
- domain-kafka : cloud 전용 예정

## 사전 준비
```
mkdir $HOME/db/maria
docker run --name local-my-mariadb \
-v $HOME/db/maria:/var/lib/mysql -p 3306:3306 \
-e MARIADB_ROOT_PASSWORD=osori \
-e MARIADB_USER=osori -e MARIADB_PASSWORD=osori \
-d mariadb:latest
```