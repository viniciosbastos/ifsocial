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
                "id": 3,
                "text": "Teste post Renan",
                "creation": "10/12/2017 12:30",
                "creator": {
                    "id": 4,
                    "name": "Renan Silva",
                    "imagePath": "http://www.tshirtvortex.net/wp-content/uploads/Lannister-Lion.jpg"
                }
            },
            {
                "id": 1,
                "text": "Teste post Francisco",
                "creation": "10/12/2017 12:00",
                "creator": {
                    "id": 2,
                    "name": "Francisco Aguiar",
                    "imagePath": "https://vignette.wikia.nocookie.net/gameofthrones/images/e/e6/House-Frey-Main-Shield.PNG/revision/latest?cb=20170523011255"
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
                "name": "Huehue da Comp",
                "creator": {
                    "id": 3,
                    "name": "Aurelio Vinicios",
                    "imagePath": "https://i.pinimg.com/236x/90/7e/73/907e73f8a7a93fb60da9b9998741f767--window-decals-window-wall.jpg"
                },
                "quantityMembers": null,
                "issues": []
            }
        ],
        "participate": [
            {
                "name": "Grupo Eng de Soft",
                "creator": {
                    "id": 2,
                    "name": "Francisco Aguiar",
                    "imagePath": "https://vignette.wikia.nocookie.net/gameofthrones/images/e/e6/House-Frey-Main-Shield.PNG/revision/latest?cb=20170523011255"
                },
                "quantityMembers": null,
                "issues": [
                    {
                        "name": "Teste issue",
                        "id": 1,
                        "quantity_comments": 1
                    }
                ]
            }
        ]
    }
}
```

(GET) /group/{groupId}

Retorna as informações da tela do grupo.

Exemplo:

Request: /group/1

```json
{
    "sucess": true,
    "data": {
        "name": "Grupo Eng de Soft",
        "creatorName": "Francisco Aguiar",
        "quantityMembers": 2,
        "issues": [
            {
                "name": "Teste issue",
                "id": 1,
                "quantity_comments": 1
            }
        ]
    }
}
```

(GET) /issues/{issueId}

Retorna as informações da Issue.

Exemplo:

Request: /issues/1

```json
{
    "sucess": true,
    "data": {
        "issue": {
            "name": "Teste issue",
            "id": 1,
            "quantity_comments": 5
        },
        "comments": [
            {
                "id": 1,
                "message": "Testando",
                "creation": "10/12/2017 00:00",
                "creator": {
                    "id": 2,
                    "name": "Francisco Aguiar",
                    "imagePath": "https://vignette.wikia.nocookie.net/gameofthrones/images/e/e6/House-Frey-Main-Shield.PNG/revision/latest?cb=20170523011255"
                },
                "responses": [
                    {
                        "id": 4,
                        "message": "Teste 2",
                        "creation": "10/12/2017 00:00",
                        "creator": {
                            "id": 3,
                            "name": "Aurelio Vinicios",
                            "imagePath": "https://i.pinimg.com/236x/90/7e/73/907e73f8a7a93fb60da9b9998741f767--window-decals-window-wall.jpg"
                        },
                        "responses": null
                    },
                    {
                        "id": 5,
                        "message": "Teste 3",
                        "creation": "10/12/2017 00:00",
                        "creator": {
                            "id": 2,
                            "name": "Francisco Aguiar",
                            "imagePath": "https://vignette.wikia.nocookie.net/gameofthrones/images/e/e6/House-Frey-Main-Shield.PNG/revision/latest?cb=20170523011255"
                        },
                        "responses": null
                    }
                ]
            },
            {
                "id": 2,
                "message": "Teste 2",
                "creation": "10/12/2017 00:00",
                "creator": {
                    "id": 3,
                    "name": "Aurelio Vinicios",
                    "imagePath": "https://i.pinimg.com/236x/90/7e/73/907e73f8a7a93fb60da9b9998741f767--window-decals-window-wall.jpg"
                },
                "responses": [
                    {
                        "id": 3,
                        "message": "Teste 2",
                        "creation": "10/12/2017 00:00",
                        "creator": {
                            "id": 4,
                            "name": "Renan Silva",
                            "imagePath": "http://www.tshirtvortex.net/wp-content/uploads/Lannister-Lion.jpg"
                        },
                        "responses": null
                    }
                ]
            }
        ]
    }
}
```