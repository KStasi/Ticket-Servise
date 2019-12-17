### Как скомпилировать ###

Всегда удаляй target перед компиляцией. Особенно если меняешь плагины

    rm -rf target/ && mvn package

### Как запустить ###

    java -jar target/TicketService-1.0-SNAPSHOT.jar
