<h1 align=center>Java JDBC</h1>
<p align=center>Projeto java utilizando jdbc para a conexão com banco de dados mysql</p>


## Configuração

Crie um banco de dados mysql

```sql
CREATE DATABASE test;
```

Crie uma tabela neste banco de dados:

```sql
USE test;

CREATE TABLE pessoa (
  id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  nome VARCHAR(100) NOT NULL
);
```

Mude o usuário e senha no arquivo [ConnectionUtil](https://github.com/Lucas-Severo/java-jdbc/blob/master/src/main/java/com/projeto/java/jdbc/ConnectionUtil.java#L21)

```bash
DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "username", "password");
```

## Instalação

### Linux

```bash
./mvnw compile assembly:single
```

### Windows

```bat
mvnw.cmd compile assembly:single
```

## Execução

Digite

```bash
cd target/
java -jar jdbc-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```

