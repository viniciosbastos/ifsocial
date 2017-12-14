# IFSocial

Projeto para a cadeira de Engenharia de Software do IFCE.

Objetivo: Desenvolver uma rede social.
Tecnologias utilizadas: Para o desenvolvimento do backend será utilizado Java + Spring MVC + Spring Boot para criar uma API REST.

Deploy feito nos servidores Heroku. Base Url: https://pacific-stream-91568.herokuapp.com/

# API

(POST) /user/login

Recebe matrícula e senha e verifica autenticidade do usuário.

Retorna as informações do usuário e informações da homepage;

Exemplo:

Request: https://pacific-stream-91568.herokuapp.com/user/login

```json
{
    "registration": 333333,
    "password": "123"
}
```

Response (Sucesso)

```json
{
    "sucess": false,
    "data": {
        "user": {
            "id": 3,
            "name": "Aurelio Vinicios",
            "profileImage": "https://i.pinimg.com/236x/90/7e/73/907e73f8a7a93fb60da9b9998741f767--window-decals-window-wall.jpg"
        },
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

Response (Erro): 

```
{
    "sucess": false,
    "data": {
        "message": "Usuário não encontrado na base de dados."
    }
}
```

(GET) /user/{userId}

Retorna as informações da tela de perfil do usuário, trazendo suas informações pessoais e posts feitos por ele;

Exemplo:

Request: https://pacific-stream-91568.herokuapp.com/user/3


```json
{
    "sucess": true,
    "data": {
        "userData": {
            "id": 3,
            "registration": 333333,
            "name": "Aurelio Vinicios",
            "address": null,
            "interests": null,
            "email": "aurelio.vinicios@ifce.edu.br",
            "birthday": null,
            "profileImage": {
                "id": 1,
                "name": "profile_vinicios",
                "path": "https://i.pinimg.com/236x/90/7e/73/907e73f8a7a93fb60da9b9998741f767--window-decals-window-wall.jpg"
            }
        },
        "posts": [
            {
                "id": 2,
                "text": "Teste post Aurelio",
                "creation": "10/12/2017 13:00",
                "creator": {
                    "id": 3,
                    "name": "Aurelio Vinicios",
                    "imagePath": "https://i.pinimg.com/236x/90/7e/73/907e73f8a7a93fb60da9b9998741f767--window-decals-window-wall.jpg"
                }
            }
        ]
    }
}
```

(GET) /user/home/{userId}

Retorna as informações para a homepage do usuário: posts de amigos e do usuário, sugestão de amigos e issues favoritadas.

Exemplo:

Request: https://pacific-stream-91568.herokuapp.com/user/home/3

Response:
```json
{
    "sucess": true,
    "data": {
        "user": {
            "id": 3,
            "name": "Aurelio Vinicios",
            "profileImage": "https://i.pinimg.com/236x/90/7e/73/907e73f8a7a93fb60da9b9998741f767--window-decals-window-wall.jpg"
        },
        "posts": [
            {
                "id": 4,
                "text": "Teste insert post",
                "creation": "12/12/2017 00:00",
                "creator": {
                    "id": 3,
                    "name": "Aurelio Vinicios",
                    "imagePath": "https://i.pinimg.com/236x/90/7e/73/907e73f8a7a93fb60da9b9998741f767--window-decals-window-wall.jpg"
                }
            },
            {
                "id": 5,
                "text": "VAI CURINTIAAAAAA!!!!",
                "creation": "12/12/2017 00:00",
                "creator": {
                    "id": 4,
                    "name": "Renan Silva",
                    "imagePath": "http://www.tshirtvortex.net/wp-content/uploads/Lannister-Lion.jpg"
                }
            },
            {
                "id": 2,
                "text": "Teste post Aurelio",
                "creation": "10/12/2017 13:00",
                "creator": {
                    "id": 3,
                    "name": "Aurelio Vinicios",
                    "imagePath": "https://i.pinimg.com/236x/90/7e/73/907e73f8a7a93fb60da9b9998741f767--window-decals-window-wall.jpg"
                }
            },
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
        ],
        "favoriteIssues": [
            {
                "name": "Droga de Issue de merda",
                "id": 3,
                "quantity_comments": 3,
                "creation": "12/12/2017",
                "creator": {
                    "id": 4,
                    "name": "Renan Silva",
                    "imagePath": "http://www.tshirtvortex.net/wp-content/uploads/Lannister-Lion.jpg"
                }
            }
        ]
    }
}
```	
	
(GET) /user/{userId}/groups

Retorna as informações da tela "Meus Grupos": grupos que o usuário criou e os que ele participa.

Exemplo:

Request: https://pacific-stream-91568.herokuapp.com/user/3/groups

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

Request: https://pacific-stream-91568.herokuapp.com/group/1

```json
{
    "sucess": true,
    "data": {
        "name": "Grupo Eng de Soft",
        "creator": {
            "id": 2,
            "name": "Francisco Aguiar",
            "imagePath": "https://vignette.wikia.nocookie.net/gameofthrones/images/e/e6/House-Frey-Main-Shield.PNG/revision/latest?cb=20170523011255"
        },
        "quantityMembers": 2,
        "issues": [
            {
                "name": "Teste issue",
                "id": 1,
                "quantity_comments": 5,
                "creation": "10/12/2017",
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

(GET) /group/{groupId}/issues/{issueId}

Retorna as informações da Issue.

Exemplo:

Request: https://pacific-stream-91568.herokuapp.com/group/1/issues/1

```json
{
    "sucess": true,
    "data": {
        "issue": {
            "name": "Teste issue",
            "id": 1,
            "quantity_comments": 5,
            "creation": "10/12/2017",
            "creator": {
                "id": 2,
                "name": "Francisco Aguiar",
                "imagePath": "https://vignette.wikia.nocookie.net/gameofthrones/images/e/e6/House-Frey-Main-Shield.PNG/revision/latest?cb=20170523011255"
            }
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

(POST) /group/{groupId}/issues/new

Insere uma nova issue na base de dados.

Exemplo:

Request: https://pacific-stream-91568.herokuapp.com/group/1/issues/new

```json
{
    "name": "Teste Insert Issue",
    "creation": "11/12/2017",
    "creator": {
        "id": 2
    }
}
```

Response:

```json
{
	"sucess": true,
	"data": {
		"message": "Issue inserida com sucesso."
	}
}
```

(POST) /group/{groupId}/issues/{issueId}/comments/new

Insere um novo comentário na issue.

Exemplo:

Request: https://pacific-stream-91568.herokuapp.com/group/1/issues/1/comments/new

```json
{
    "message": "Teste Insert IssueMessage",
    "creation": "11/12/2017",
    "creator": {
        "id": 3
    }
}
```

Response:

```json
{
	"sucess": true,
	"data": {
		"message": "Comentário inserido com sucesso."
	}
}
```

(POST) /user/{userId}/update

Atualiza as informações do usuário na base de dados.
Campos possíveis: Nome, Endereço, Email, Interesses e Data de Nascimento

Exemplo:

Request: https://pacific-stream-91568.herokuapp.com/user/3/update

```json
{
    "name": "Aurelio Vinicios",
    "email": "aurelio.vinicios@ifce.edu.br",
    "address": "Rua Bartolomeu Gusmão, 1025"
}
```

Response:

```json
{
    "sucess": true,
    "data": {
        "message": "Alteração realizada com sucesso."
    }
}
```

(GET) /user/search/{name}

Busca usuário que possua em seu nome a variável "name"

Exemplo:

Request: https://pacific-stream-91568.herokuapp.com/user/search/a

Response:

```json
{
    "sucess": true,
    "data": {
        "users": [
            {
                "id": 2,
                "name": "Francisco Aguiar",
                "profileImage": "https://vignette.wikia.nocookie.net/gameofthrones/images/e/e6/House-Frey-Main-Shield.PNG/revision/latest?cb=20170523011255"
            },
            {
                "id": 4,
                "name": "Renan Silva",
                "profileImage": "http://www.tshirtvortex.net/wp-content/uploads/Lannister-Lion.jpg"
            },
            {
                "id": 3,
                "name": "Aurelio Vinicios",
                "profileImage": "https://i.pinimg.com/236x/90/7e/73/907e73f8a7a93fb60da9b9998741f767--window-decals-window-wall.jpg"
            }
        ]
    }
}
```

(POST) /post/new

Cria um novo post e insere na base de dados.

Exemplo:

Request: https://pacific-stream-91568.herokuapp.com/post/new

```json
{
    "text": "Teste insert post",
    "creation": "12/12/2017",
	"creator":  {
		"id": 3
	}
}
```

Response:

```json
{
    "sucess": true,
    "data": {
        "message": "Post inserido com sucesso."
    }
}
```

(POST) /group/{groupId}/issues/{issueId}/comments/{commentId}/response

Insere um novo comentário na issue.

Exemplo:

Request: https://pacific-stream-91568.herokuapp.com/group/1/issues/3/comments/8/response

```json
{
    "message": "é isso ai",
    "creation": "12/12/2017",
    "creator": {
        "id": 3
    }
}
```

Response:

```json
{
    "sucess": true,
    "data": {
        "message": "Comentário inserido com sucesso."
    }
}
```

(GET) /group/{groupId}/issues/{issueId}/favorite?userId={userId}

Favorita a issue.

Exemplo:

Request: https://pacific-stream-91568.herokuapp.com/group/1/issues/3/favorite?userId=3


Response:

```json
{
    "sucess": true,
    "data": {
        "message": "Issue favoritada com sucesso."
    }
}
```

(GET) user/{userId}/follow/{toFollow}

service para registrar que um usuário deseja seguir outro;
{userId} => usuário logado.
{toFollow} => usuário a ser seguido


Exemplo:

Request: https://pacific-stream-91568.herokuapp.com/user/2/follow/3

Response:

```json
{
    "sucess": true,
    "data": {
        "message": "Operação concluída"
    }
}
```

(POST) /group/new

service para criar um novo grupo


Exemplo:

Request: https://pacific-stream-91568.herokuapp.com/group/new

```json
{
	"name": "SEMB",
	"type": 2,
	"creator": {
		"id": 2
	}
}
```

Response:

```json
{
    "sucess": true,
    "data": {
        "message": "Grupo criado com sucesso."
    }
}
```



