🐱 MeowSpace - Fullstack-App
Este proyecto es una aplicación Fullstack integral diseñada para la gestión y consulta de razas de gatos. El sistema permite consumir datos de una API externa, gestionar información de usuarios y persistir datos en una base de datos distribuida en la nube.

🚀 Tecnologías Utilizadas
Backend (Spring Boot)
Java 17 & Spring Boot 3: Framework principal para la lógica de la API.

Spring Data MongoDB: Integración para el manejo de datos NoSQL.

JUnit 5 & Mockito: Suite de pruebas unitarias y simulación de dependencias.

Maven: Gestión de ciclo de vida y dependencias.

Frontend (Angular)
Angular 17+: Framework para una interfaz de usuario dinámica.

RxJS: Programación reactiva mediante Observables.

Angular Router: Sistema de navegación y protección de rutas (Guards).

Infraestructura & DevOps
Docker & Docker Compose: Contenedorización de toda la plataforma.

MongoDB Atlas: Base de datos como servicio (DBaaS) alojada en la nube.

🏛️ Arquitectura y División de Capas
Para asegurar un código limpio y escalable, el proyecto se divide en las siguientes capas:

Controller: Punto de entrada de las peticiones HTTP.

Service / Use Case: Contiene la lógica de negocio y reglas del sistema.

Repository: Capa encargada de la comunicación con MongoDB.

Component (Frontend): Maneja la lógica visual y la interacción del usuario.

🧠 Desafíos y Aprendizajes
Este proyecto representó un crecimiento técnico importante, enfrentando los siguientes retos:

Implementación de MongoDB Atlas: Fue mi primera experiencia configurando una base de datos NoSQL en la nube. El mayor aprendizaje fue gestionar el acceso a la red (Network Access) y las cadenas de conexión seguras.

Dockerización Integral: Lograr que el contenedor del Backend se comunicara de forma fluida con el Frontend y con el clúster de Atlas en la nube, manejando variables de entorno y redes internas de Docker.

Integración Fullstack: Sincronizar el ciclo de vida de los componentes de Angular con las respuestas asíncronas de la API en Spring Boot.

🧪 Pruebas Unitarias
Se implementaron pruebas unitarias para garantizar la estabilidad del sistema:

UseCase Tests: Validación de la lógica de negocio aislando el RestTemplate mediante @Mock.

Controller Tests: Pruebas de integración web usando MockMvc para validar los endpoints y códigos de estado HTTP.

Para ejecutar los tests, utiliza el siguiente comando en la carpeta del backend:

Bash

cd Backend/catapi
./mvnw test

🛠️ Guía de Ejecución
Sigue estos pasos para levantar el proyecto completo en tu máquina local:

1. Clonar el repositorio
Bash

git clone https://github.com/TU_USUARIO/TU_REPOSITORIO.git
cd TU_REPOSITORIO

2. Levantar la infraestructura con Docker
Asegúrate de tener Docker abierto y ejecuta:

Bash

docker-compose up --build

3. Acceso a las aplicaciones
Una vez que los contenedores estén en ejecución (Status: Running), abre tu navegador en:

Frontend: bash http://localhost:4200

Backend API: bash http://localhost:8080

📦 Entregables Adjuntos
✅ Código fuente completo en GitHub.

✅ Archivos de configuración Docker y Docker Compose.

✅ Documentación técnica en formato PDF.

✅ Suite de Pruebas Unitarias funcional.

Desarrollado por: Kevin Beltran.

GitHub: https://github.com/Nicolas121918
