#language: pt

Funcionalidade: Criando usuario

  Cenário: Criar um novo usuário
    Dado que envio uma requisição POST para "/api/users" com os detalhes do usuário
    Então o status da resposta deve ser 201
    E o corpo da resposta deve conter "name" com valor "Neiva"
    E o corpo da resposta deve conter "job" com valor "Qa chefe"
