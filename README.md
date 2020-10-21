# dio-spring-cloud :cloud:

<h2>Projeto com arquitetura de microserviços utilizando Spring Cloud :rocket:</h2>

![alt text](https://ucarecdn.com/03c5fc5c-2644-4116-9406-8b60ae094b13/)

<h3>Descrição</h3>
O projeto foi construído utilizando o conceito de arquitetura em Cloud, e com componentes/módulos do framework Spring. O projeto está dividido em 5 aplicações e a pasta com configurações:

<h4>:heavy_check_mark: config</h4>

Contém os arquivos .properties, com as configurações das nossas aplicações.

<h4>:heavy_check_mark: config-server</h4>

Responsável por carregar os arquivos .properties das nossas aplicações sempre que necessário. Nosso config-server, seguindo nossas configurações, roda no endereço
<a>http://localhost:8888/</a>. As aplicações abaixo chamam nosso config-server ao serem iniciadas para obterem o seu respectivo arquivo .properties.

<h4>:heavy_check_mark: service-discovery</h4>

Responsável pelo nosso painel do eureka, é essa aplicação que será chamada para registrar os serviços/aplicações que estiverem rodando e que fazem referência para se inscreverem no eureka informando que estão up.
Para acessar o painel do eureka, entre com o endereço <a>http://localhost:9000/</a>

<h4>:heavy_check_mark: gateway</h4>

Responsável por receber nossas requisições, fazer o load balance e redirecionar para o serviço solicitado pelo cliente. Ele roda no endereço <a>http://localhost:8080/</a>

<h4>:heavy_check_mark: product-catalog</h4>

Microserviço responsável por operações de crud em nosso catalogo de produtos. O endereço deste microserviço é <a>http://localhost:8081/api/v1/products/</a>, mas como faremos a utilização do gateway vamos utilizar a seguinte URL para acessá-lo <a>http://localhost:8080/api/v1/products/</a>

```
Para consultar a documentação de produtos acesse:
- http://localhost:8081/swagger-ui/
```

<h4>:heavy_check_mark: shopping-cart</h4>

Microserviço responsável por operações de crud em nosso carrinho de compras. O endereço deste microserviço é <a>http://localhost:8082/api/v1/carts/</a>, mas como faremos a utilização do gateway vamos utilizar a seguinte URL para acessá-lo <a>http://localhost:8080/api/v1/carts/</a>

```
Para consultar a documentação de carrinho de compras acesse:
- http://localhost:8082/swagger-ui/
```
Para verificar se a aplicação está UP, chame a URL:

* config-server :point_right: http://localhost:8888/actuator/health
* product-catalog :point_right: http://localhost:8081/actuator/health
* shopping-cart :point_right: http://localhost:8082/actuator/health
* gateway :point_right: http://localhost:8080/actuator/health
* service-discovery :point_right: http://localhost:9000/actuator/health


<h3>:loudspeaker: Atenção para execução do projeto</h3>

Para executar e subir as aplicações corretamente siga a ordem abaixo:

1. <b>config-server</b>
2. <b>service-discovery</b>
3. <b>gateway</b>
4. <b>product-catalog ou shopping-cart</b> (pode subir qualquer uma das duas, desde que siga os três primeiros itens corretamente)

<h3>Ferramentas e tecnologias</h3>

:ballot_box_with_check: Java 11

:ballot_box_with_check: Spring Boot

:ballot_box_with_check: Spring Data JPA

:ballot_box_with_check: Lombok

:ballot_box_with_check: Swagger

:ballot_box_with_check: Hikari

:ballot_box_with_check: Banco de dados H2

:ballot_box_with_check: Modelo arquitetural REST

:ballot_box_with_check: Spring Cloud

:ballot_box_with_check: Spring Actuator

:ballot_box_with_check: Spring Cloud Config Server

:ballot_box_with_check: Gateway

:ballot_box_with_check: Netflix Eureka

