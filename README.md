# Projeto desenvolvido com base no back-end basic test do IFood

Este projeto foi desenvolvido a fim de cumprir os requisitos propostos no backend basic teste do IFood.

## Tecnologias utilizadas

**Spring Boot**: Na versão 2.3.7.

**Open-feign** : Utilizado como http client.

**Hazelcast**: Utilizado para cacher as chamadas a api de clima.

**Resilliency4j**: Utilizado o padrão Circuit-breaker para lidar com tolerância a falhas nas chamadas da api de clima.

### GET-STARTED
Utilize o endpoint /weather?city={cityname} informando com querystring a cidade para retornar os dados climaticos do local informado.
**Obs** : É necessaria passar uma key válida da api do openweather como variável de ambiente: **API_KEY**




## Tarefas

### 1. Crie um endpoint para retornar informações sobre o serviço

Para testar rapidamente se nosso serviço está funcionando, crie na classe `About` um endpoint `GET /about` que retorna
uma mensagem confirmando que nosso serviço está funcionando e recebendo requisições.


### 2. Integração com OpenWeatherMap

Vamos usar o OpenWeatherMap para obter informações do clima de uma cidade.

Primeiro, faça um registro rápido no [OpenWeatherMaps][OpenWeather] para obter uma API Key.

Agora, crie um endpoint `GET /weather` no nosso micro-serviço que aceite o parâmetro `city` e retorne os detalhes do
tempo na cidade (ensolarado, nublado, etc) e detalhes meteorológicos (temperatura, pressão, etc), utilizando 
requisições HTTP para o OpenWeatherMaps.

Estruture a resposta da maneira que achar mais organizada. 

Sugestão: Pesquise alguma biblioteca de requisições HTTP robusta, que trate erros e serialização/deserialização 
automaticamente. 


### 3. Cache

Pesquise alguma biblioteca de cache para tornar nosso micro-serviço mais rápido.

Adicione cache na chamada ao servidor do OpenWeatherMaps.


### 4. Tolerância a falhas

Se por algum motivo o serviço do OpenWeatherMaps estiver indisponível, não deveríamos deixar que nosso micro-serviço 
seja afetado.

Para isso, podemos adicionar uma biblioteca de controle de falhas chamada Hystrix.

Nessa etapa, adiciona e configure o [Hystrix][HystrixRepo] para tornar nosso micro-serviço mais robusto.

Em caso de falha... o que poderia acontecer para que o nosso endpoint não retorne apenas uma resposta de erro genérica?


[OpenWeather]: https://openweathermap.org/appid
[FeignRepo]: https://github.com/OpenFeign/feign
[HystrixRepo]: https://github.com/Netflix/Hystrix
[SpringInitializr]: https://start.spring.io/
[SpringBoot]: https://docs.spring.io/spring-boot/docs/1.5.2.RELEASE/reference/htmlsingle/#getting-started
