# Utiliser une image de base avec OpenJDK 17
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier pom.xml et le wrapper Maven
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
COPY mvnw.cmd .

# Rendre le wrapper Maven exécutable
RUN chmod +x ./mvnw

# Télécharger les dépendances (pour optimiser le cache Docker)
RUN ./mvnw dependency:go-offline -B

# Copier le code source
COPY src ./src

# Construire l'application
RUN ./mvnw clean package -DskipTests

# Exposer le port de l'application
EXPOSE 8082

# Commande pour démarrer l'application
CMD ["java", "-jar", "target/micrommerce-0.0.1-SNAPSHOT.jar"]