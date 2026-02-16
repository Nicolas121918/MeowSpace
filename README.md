<html>

<body class="stackedit">
  <div class="stackedit__html"><h1 id="🐱-meowspace-full-stack-app">🐱 MeowSpace Full-Stack App</h1>
<p>Este proyecto es una aplicación <strong>Fullstack</strong> integral diseñada para la gestión y consulta de razas de gatos. El sistema permite consumir datos de una API externa, gestionar información de usuarios y persistir datos en una base de datos distribuida en la nube.</p>
<h2 id="🚀-tecnologías-utilizadas">🚀 Tecnologías Utilizadas</h2>
<h3 id="backend-spring-boot"><strong>Backend (Spring Boot)</strong></h3>
<ul>
<li>
<p><strong>Java 17 &amp; Spring Boot 3</strong>: Framework principal para la lógica de la API.</p>
</li>
<li>
<p><strong>Spring Data MongoDB</strong>: Integración para el manejo de datos NoSQL.</p>
</li>
<li>
<p><strong>JUnit 5 &amp; Mockito</strong>: Suite de pruebas unitarias y simulación de dependencias.</p>
</li>
<li>
<p><strong>Maven</strong>: Gestión de ciclo de vida y dependencias.</p>
</li>
</ul>
<h3 id="frontend-angular"><strong>Frontend (Angular)</strong></h3>
<ul>
<li>
<p><strong>Angular 17+</strong>: Framework para una interfaz de usuario dinámica.</p>
</li>
<li>
<p><strong>RxJS</strong>: Programación reactiva mediante Observables.</p>
</li>
<li>
<p><strong>Angular Router</strong>: Sistema de navegación y protección de rutas (Guards).</p>
</li>
</ul>
<h3 id="infraestructura--devops"><strong>Infraestructura &amp; DevOps</strong></h3>
<ul>
<li>
<p><strong>Docker &amp; Docker Compose</strong>: Contenedorización de toda la plataforma.</p>
</li>
<li>
<p><strong>MongoDB Atlas</strong>: Base de datos como servicio (DBaaS) alojada en la nube.</p>
</li>
</ul>
<hr>
<h2 id="🏛️-arquitectura-y-división-de-capas">🏛️ Arquitectura y División de Capas</h2>
<p>Para asegurar un código limpio y escalable, el proyecto se divide en las siguientes capas:</p>
<ul>
<li>
<p><strong>Controller</strong>: Punto de entrada de las peticiones HTTP.</p>
</li>
<li>
<p><strong>Service / Use Case</strong>: Contiene la lógica de negocio y reglas del sistema.</p>
</li>
<li>
<p><strong>Repository</strong>: Capa encargada de la comunicación con MongoDB.</p>
</li>
<li>
<p><strong>Component (Frontend)</strong>: Maneja la lógica visual y la interacción del usuario.</p>
</li>
</ul>
<hr>
<h2 id="🧠-desafíos-y-aprendizajes">🧠 Desafíos y Aprendizajes</h2>
<p>Este proyecto representó un crecimiento técnico importante, enfrentando los siguientes retos:</p>
<ol>
<li>
<p><strong>Implementación de MongoDB Atlas</strong>: Fue mi primera experiencia configurando una base de datos NoSQL en la nube. El mayor aprendizaje fue gestionar el acceso a la red (Network Access) y las cadenas de conexión seguras.</p>
</li>
<li>
<p><strong>Dockerización Integral</strong>: Lograr que el contenedor del Backend se comunicara de forma fluida con el Frontend y con el clúster de Atlas en la nube, manejando variables de entorno y redes internas de Docker.</p>
</li>
<li>
<p><strong>Integración Fullstack</strong>: Sincronizar el ciclo de vida de los componentes de Angular con las respuestas asíncronas de la API en Spring Boot.</p>
</li>
</ol>
<hr>
<h2 id="🧪-pruebas-unitarias">🧪 Pruebas Unitarias</h2>
<p>Se implementaron pruebas unitarias para garantizar la estabilidad del sistema:</p>
<ul>
<li>
<p><strong>UseCase Tests</strong>: Validación de la lógica de negocio aislando el <code>RestTemplate</code> mediante <code>@Mock</code>.</p>
</li>
<li>
<p><strong>Controller Tests</strong>: Pruebas de integración web usando <code>MockMvc</code> para validar los endpoints y códigos de estado HTTP.</p>
</li>
</ul>
<p>Para ejecutar los tests, utiliza el siguiente comando en la carpeta del backend:</p>
<p>Bash</p>
<pre><code>cd Backend/catapi
./mvnw test

</code></pre>
<hr>
<h2 id="🛠️-guía-de-ejecución">🛠️ Guía de Ejecución</h2>
<p>Sigue estos pasos para levantar el proyecto completo en tu máquina local:</p>
<h3 id="clonar-el-repositorio"><strong>1. Clonar el repositorio</strong></h3>
<p>Bash</p>
<pre><code>git clone https://github.com/Nicolas121918/MeowSpace.git
cd App-fullstack

</code></pre>
<h3 id="levantar-la-infraestructura-con-docker"><strong>2. Levantar la infraestructura con Docker</strong></h3>
<p>Asegúrate de tener Docker abierto y ejecuta:</p>
<p>Bash</p>
<pre><code>docker-compose up --build

</code></pre>
<h3 id="acceso-a-las-aplicaciones"><strong>3. Acceso a las aplicaciones</strong></h3>
<p>Una vez que los contenedores estén en ejecución (Status: Running), abre tu navegador en:</p>
<ul>
<li>
<p><strong>Frontend:</strong> <code>bash http://localhost:4200</code></p>
</li>
<li>
<p><strong>Backend API:</strong> <code>bash http://localhost:8080</code></p>
</li>
</ul>
<hr>
<h2 id="📦-entregables-adjuntos">📦 Entregables Adjuntos</h2>
<ul>
<li>
<p>✅ Código fuente completo en <strong>GitHub</strong>.</p>
</li>
<li>
<p>✅ Archivos de configuración <strong>Docker</strong> y <strong>Docker Compose</strong>.</p>

</li>
<li>
<p>✅ Documentación técnica en formato <strong>PDF</strong>.</p>
</li>
<li>
<p>✅ Suite de <strong>Pruebas Unitarias</strong> funcional.</p>
</li>
</ul>
<hr>
<p><strong>Desarrollado por:</strong> Kevin Beltran</p>
<p><strong>GitHub:</strong> <a href="https://github.com/Nicolas121918">https://github.com/Nicolas121918</a></p>
</div>
</body>


video : 
https://github.com/user-attachments/assets/a156fe42-d4ff-40c3-909e-03e708e96697

</html>
