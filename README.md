# Java CRUD Application

Aplicação CRUD em Java 17 com Spring Boot e MongoDB.

## Executar Localmente

1. Iniciar MongoDB:
```bash
docker run -d -p 27017:27017 --name mongodb mongo:latest
```

2. Compilar e executar:
```bash
mvn clean package
java -jar target/java-crud-1.0.0.jar
```

## Configuração

Variáveis de ambiente disponíveis:
- `MONGO_HOST` (default: localhost)
- `MONGO_PORT` (default: 27017)
- `MONGO_DATABASE` (default: cruddb)
- `MONGO_USERNAME` (opcional)
- `MONGO_PASSWORD` (opcional)
- `SERVER_PORT` (default: 8080)

## Docker

```bash
# Build
mvn clean package
docker build -t java-crud .

# Run
docker run -p 8080:8080 -e MONGO_HOST=host.docker.internal java-crud
```

## Kubernetes

```bash
kubectl apply -f k8s-deployment.yaml
```

## Funcionalidades

- Listar usuários (/)
- Criar usuário (/new)
- Editar usuário (/edit/{id})
- Visualizar usuário (/view/{id})
- Excluir usuário (/delete/{id})
