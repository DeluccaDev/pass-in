## 🚀 Tecnologias

Esse projeto foi desenvolvido com as seguintes tecnologias:

- Java
- Springboot

## 💻 Projeto:

Aplicação desenvolvida durante o NLW Unite da Rocketseat

Pass.in - Sistema de check-in para eventos presenciais.

## 🎨 Requisitos:

https://www.notion.so/Aula-01-Pass-in-39891374cb85415b97856fc422ca7f91

---

Pass.in - Sistema de check-in para eventos presenciais.

> O pass.In é uma aplicação para a gestão de participantes em eventos presenciais.
> 
- A Ferramenta permite que o organizador cadastre um evento e abra uma pagina publica de inscrição.
- Os participantes podem emitir uma credencial para o check-in no dia do evento.
- O sistema fara um Scan da credencial do participante para permitir a entrada no evento.

## Requisitos funcionais.

- O organizador deve poder cadastrar um novo evento.
- O organizador deve poder visualizar dados de um evento.
- O organizador deve poder visualizar a lista de participantes.
- O organizador deve poder se inscrever em um evento.
- O organizador deve poder visualizar seu cracha de inscrição.
- O organizador deve poder realizar check-In no evento.
- O organizador deve poder cadastrar um novo evento;
- O organizador deve poder visualizar dados de um evento;
- O organizador deve poder visualizar a lista de participantes;
- O participante deve poder se inscrever em um evento;
- O participante deve poder visualizar seu crachá de inscrição;
- O participante deve poder realizar check-in no evento;

## Regra de negocios.

- O participante só pode se inscrever uma unica vez para o evento.
- O participante só pode se inscrever em eventos com vagas disponiveis.
- O participante só pode realizar check-In em um evento uma unica vez.

## Requisitos nao funcionais.

- O check-In no evento será realizado atraves de QrCode.

## Criando o projeto

- [ ]  Criar projeto utilizando Spring Initializr
- Spring Web
- Flyway
- Dev Tools
- Lombok
- JPA
- [x]  Criar e configurar banco de dados na aplicação.

```xml
		<dependency>
			<groupId>org.hsqldb</groupId>
			<artifactId>hsqldb</artifactId>
			<version>2.7.1</version>
		</dependency>
```

- [ ]  Criar migrations para criação das tabelas
- [ ]  Criar entidades que irão representar os dados
    - [ ]  Event
    - [ ]  Attendee
    - [ ]  Check-in
- [ ]  Criar repositories
    - [ ]  Event
    - [ ]  Attendee
    - [ ]  Check-in
- [ ]  Criar controllers
    - [ ]  **/events**
    - [ ]  **/attendees**

# Criando funcionalidade de organizador

- Criar `EventService`
- Listagem de eventos
- Criação de eventos
- Criar Endpoints
- GET /events/{eventId}
- POST /events
- Adicionar tratamento para Exceções
- Criar `AttendeeService`
- Listagem de Attendees de um evento
- Criar Endpoint
- GET /events/{eventId}/attendees

# Criando funcionalidade do participante

- Implementar novas funcionalidades no `AttendeeService`
- Inscrição de participante num evento
- O participante deve enviar `name` e `email`
- Exibição do crachá
- O retorno do crachá deverá ser o `name`, `email`, `checkInURL` e **`eventTitle`**
- Criar Endpoints
- POST /events/{eventId}/attendees
- GET /attendees/{attendeeId}/badge
- Criar **`CheckInService`**
- Criar método para checkIn
- Criar Endpoint
- POST /attendees/{attendeeId}/check-in
- Tratamento das exceções
