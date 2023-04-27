# feedback

# Ответы

GET
/get-responses
---

Параметры: eventId(Long)

Пример ответа:
```json
[
    {
        "responseId": 52,
        "responseRate": 3,
        "userId": 1,
        "question": {
            "questionId": 52,
            "questionTitle": "Чё по борщику?",
            "eventId": 1,
            "creatorId": 1
        }
    }
]
```

Данный запрос предназначен для получения всех ответов на все вопросы по id какого-либо события.


GET
/get-responses-by-user
---

Параметры: eventId(Long), userId(Long)

Пример ответа:
```json
[
    {
        "responseId": 52,
        "responseRate": 3,
        "userId": 1,
        "question": {
            "questionId": 52,
            "questionTitle": "Чё по борщику?",
            "eventId": 1,
            "creatorId": 1
        }
    }
]
```

Данный запрос предназначен для получения всех ответов пользователя по какому-либо мероприятию.
Подразумевается, что у пользователя в личном кабинете есть список всех мероприятий в которых он
участвовал, и он может ткнуть на какое-то из них и увидеть что он ответил на вопросы по
мероприятию.


POST
/add-response
---

Параметры: responseRate(int от 1 до 5), questionId(Long), userId(Long)

Пример ответа:
```json
{
    "responseId": 102,
    "responseRate": 3,
    "userId": 1,
    "question": {
        "questionId": 103,
        "questionTitle": "Оцените уровень организации",
        "eventId": 1,
        "creatorId": 1
    }
}
```

Данный запрос предназначен для добавления ответа на какой-либо вопрос по мероприятию от лица юзера.


PUT
/delete-responses
---

Параметры: userId(Long), eventId(Long)

Данный запрос предназначен для того, чтобы удалить ответы пользователя на все вопросы какого-либо
мероприятия. Подразумевается что на экране просмотра мероприятия у пользователя, который уже
отвечал на вопросы, будет кнопка удаления всех ответов.


# Вопросы

POST
/create-question
---

Параметры: questionTitle(String), creatorId(Long), eventId(Long)

Пример ответа:
```json
{
    "questionId": 103,
    "questionTitle": "Оцените уровень организации",
    "eventId": 1,
    "creatorId": 1
}
```

Данный запрос предназначен для создания вопроса для обратной связи к мероприятию.


GET
/get-questions
---

Параметры: eventId(Long)

Пример ответа:
```json
[
    {
        "questionId": 52,
        "questionTitle": "Чё по борщику?",
        "eventId": 1,
        "creatorId": 1
    },
    {
        "questionId": 102,
        "questionTitle": "Оцените уровень организации.?",
        "eventId": 1,
        "creatorId": 1
    },
    {
        "questionId": 103,
        "questionTitle": "Оцените уровень организации",
        "eventId": 1,
        "creatorId": 1
    }
]
```

Данный запрос предназначен для получения всех вопросов обратной связи к мероприятию.


PUT
/delete-question
---

Параметры: questionId(Long)

Данный запрос предназначен для удаления вопроса обратной связи для мероприятия.

 
