Feature: Recibir Medallas por Finalización del Curso
  Como estudiante, quiero recibir medallas como reconocimiento por completar exitosamente un curso, para sentirme motivado y premiado por mis logros educativos.

  Scenario: Recibir medalla por finalización exitosa
    Given que soy un estudiante que ha completado un curso con éxito
    When finalicé el curso y obtuve una calificación satisfactoria
    Then recibo una medalla que se muestra en mi perfil y se registra en mi historial de logros

  Scenario: No cumplir con los requisitos para recibir una medalla
    Given que soy un estudiante que ha completado un curso con éxito
    When finalicé el curso pero no cumplo con los requisitos para obtener una medalla
    Then no recibo una medalla y se me informa que no cumplí con los criterios para recibirla

  Scenario: Recibir medalla especial por rendimiento excepcional
    Given que soy un estudiante que ha completado un curso con éxito
    When finalizo el curso y obtengo una calificación sobresaliente
    Then recibo una medalla especial por un rendimiento excepcional que se muestra en mi perfil
