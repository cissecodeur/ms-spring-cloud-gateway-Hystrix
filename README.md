# ms-spring-cloud-gateway-Hystrix

Cette application montre comment mettre en place une architecture Hautement distribuée en utilisant des Microservices.

- Nous avons 3 microservices qui communiquent entre elle via un systemes de communication RestTemplate avec (OpenFeign).

- Toutes les identités de nos microservices sont gerés dans un microservices servant d'annuaire et de load-Balancer (service-eurekaEnregistrementMs) geré avec Eureka-server.

- Il existe aussi Actuator dans tous nos microservices afin d'avoir en temps reel leur etats et donc de les monitorer . 

- En frontal de notre load-Balancer, il ya un serveur proxy chargé du routage des urls venant des clients et cela est geré par le microservice (service-gateway) geré avec le proxy spring-cloud-gateway
     qui contrairement au proxy Zuul utilise un serveur Netty avec le modele de requetage non bloquant ou Single Thread Non bloquant.
     
- Connecté a ce serveur proxy un circuit-breaker(Hystrix qui lui meme connecté a actuator via des endpoints disponibles) permettant de monitorer et aussi de d'assurer la disponibilité et la gestion du temps de latence de la reponse de nos requetes.
   Hystrix a pour avantage de nous fournir un dashboard de monitoring .
