# Proyecto para Imatia por Carlos Rey Dacosta

El proyecto está incompleto por falta de tiempo pero la intención, una vez completado, era la siguiente: 
 - Aplicación Spring Boot reactiva con WebFlux y endpoints funcionales. 
 - Para evitar llamadas bloqueantes en el flujo reactivo se utiliza BlockHound. 
 - La aplicación sigue una arquitectura n-layer, constando de controlador (handler en el lexico reactivo-funcional), servicio y repositories. 
 - Los handler constan de un enrutado basándose en el nombre y tipo de método invocado. 
 - Los servicios siguen un patron Facade, abstrayendo al controlador tanto de la logica como de las llamadas internas a otros servicios.
 - Hay dos servicios, uno que controla la máquina de estados y otros que ejecuta las llamadas a la base de datos MongoDB. 
 - Se pretendía utilizar como documentación del API Swagger3
 - Con el archivo docker-compose.yml se pretende ayudar al desarrollo levantando una instancia local de la base de datos MongoDB.