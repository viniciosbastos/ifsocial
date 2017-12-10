# IFSocial

Projeto para a cadeira de Engenharia de Software do IFCE.

Objetivo: Desenvolver uma rede social.
Tecnologias utilizadas: Para o desenvolvimento do backend será utilizado Java + Spring MVC + Spring Boot para criar uma API REST.

# API

(GET) /user/{userId}

Retorna as informações para a homepage do usuário: posts de amigos, sugestão de amigos e issues favoritadas.

Exemplo:

Request: /user/3

Response:
```json
{
    "sucess": true,
    "data": {
        "posts": [
            {
                "text": "Teste post Renan",
                "creation": 1512919800000,
                "creator": {
                    "id": 4,
                    "registration": 444444,
                    "name": "Renan Silva",
                    "address": null,
                    "interests": null,
                    "email": "renan.silva@ifce.edu.br",
                    "birthday": null
                }
            },
            {
                "text": "Teste post Francisco",
                "creation": 1512918000000,
                "creator": {
                    "id": 2,
                    "registration": 222222,
                    "name": "Francisco Aguiar",
                    "address": null,
                    "interests": null,
                    "email": "francisco.aguiar@ifce.edu.br",
                    "birthday": null
                }
            }
        ]
    }
}
```	
	
(GET) /user/{userId}/groups

Retorna as informações da tela "Meus Grupos": grupos que o usuário criou e os que ele participa.

Exemplo:

Request: /user/3/groups

Response:
```json
{
    "sucess": true,
    "data": {
        "createdBy": [
            {
                "id": 2,
                "name": "Huehue da Comp",
                "creation": 1512874800000,
                "creator": {
                    "id": 3,
                    "registration": 333333,
                    "name": "Aurelio Vinicios",
                    "address": null,
                    "interests": null,
                    "email": "aurelio.vinicios@ifce.edu.br",
                    "birthday": null
                }
            }
        ],
        "participate": [
            {
                "id": 1,
                "name": "Grupo Eng de Soft",
                "creation": 1512874800000,
                "creator": {
                    "id": 2,
                    "registration": 222222,
                    "name": "Francisco Aguiar",
                    "address": null,
                    "interests": null,
                    "email": "francisco.aguiar@ifce.edu.br",
                    "birthday": null
                }
            }
        ]
    }
}
```