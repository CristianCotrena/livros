# CRUD livros usando o Spring Webflux

## G*uia de Instalação do MongoDB usando Docker*

### Visão Geral

Este guia irá orientá-lo pelo processo de configuração do MongoDB usando o Docker, uma plataforma popular de contêineres. Ao seguir estes passos, você poderá implantar uma instância do MongoDB com facilidade.

#### Pré-requisitos

Antes de começar, certifique-se de ter o Docker instalado em sua máquina. Se você ainda não o tiver instalado, pode baixar e instalar a partir do [site oficial do Docker](https://www.docker.com/get-started).

### Passos de Instalação

#### Passo 1: Baixar a Imagem do Docker do MongoDB

Abra seu terminal e execute o seguinte comando para baixar a imagem oficial do Docker do MongoDB:

```bash
sudo docker pull mongo
```

#### Passo 2: Executar o Contêiner do MongoDB

```bash
sudo docker run -d -p 27017:27017 --name my-reactive-mongo-container mongo
```

Este comando irá:

 - -d: Executar o contêiner em segundo plano (modo desanexado).
- -p 27017:27017: Mapear a porta local 27017 para a porta 27017 do contêiner.
- --name my-reactive-mongo-container: Atribuir um nome ao contêiner para referência fácil.
- mongo: Nome da imagem do Docker.

#### Passo 3: Conectar com o MongoDB Compass

Agora que seu contêiner MongoDB está em execução, você pode usar o MongoDB Compass, uma interface gráfica de usuário para o MongoDB, para interagir com o banco de dados.

Instale o MongoDB Compass em sua máquina a partir do [site oficial](https://www.mongodb.com/try/download/compass).

Abra o MongoDB Compass e conecte-se ao servidor MongoDB em _**mongodb://localhost:27017**_
