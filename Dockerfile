# Use a imagem base do OpenJDK 17 com suporte ao Alpine Linux
FROM eclipse-temurin:17-jdk-alpine

# Instale o Maven para gerenciar dependências e compilar o projeto
RUN apk add --no-cache maven

# Defina o diretório de trabalho para a aplicação
WORKDIR /app

# Copie o arquivo de configuração do Maven para o diretório de trabalho
COPY pom.xml .

# Copie o código-fonte da aplicação para o diretório de trabalho
COPY src ./src

# Compile a aplicação com o Maven e gere o arquivo JAR
RUN mvn clean package

# Crie um usuário não privilegiado para executar a aplicação com segurança
RUN adduser -D appuser

# Altere a propriedade do arquivo JAR gerado para o usuário não privilegiado
RUN chown appuser:appuser target/Playmix-0.0.1-SNAPSHOT.jar

# Altere para o usuário não privilegiado para evitar execução como root
USER appuser

# Exponha a porta 8080 para acesso à aplicação
EXPOSE 8080

# Defina o comando de entrada para iniciar a aplicação usando o JAR gerado
CMD ["java", "-jar", "target/Playmix-0.0.1-SNAPSHOT.jar"]
