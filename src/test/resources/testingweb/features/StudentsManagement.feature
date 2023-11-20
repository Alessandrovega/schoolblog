Feature: Gestionar inscripciones de estudiantes
  Como docente, quiero gestionar inscripciones de estudiantes, viendo una lista de estudiantes inscritos en mi curso y teniendo la capacidad de aprobar o denegar sus solicitudes de inscripción, para mantener un control sobre quiénes participan en el curso.

  Scenario: Gestionar inscripciones exitosamente
    Given que soy un docente autenticado en la plataforma
    When deseo gestionar las inscripciones de los estudiantes en mi curso
    And veo una lista de estudiantes inscritos en el curso y tengo la capacidad de aprobar sus solicitudes de inscripción
    Then puedo aprobar las solicitudes de inscripción de los estudiantes de manera exitosa
    And los estudiantes obtienen acceso al curso

  Scenario: Error al gestionar inscripciones por problemas técnicos
    Given que soy un docente autenticado en la plataforma
    When intento gestionar las inscripciones de los estudiantes
    And ocurre un error técnico o surge un problema al procesar las solicitudes de inscripción
    Then se me muestra un mensaje de error indicando que la gestión de inscripciones ha fallado
    And se me proporcionan instrucciones para solucionar el problema técnico

  Scenario: Cancelar gestión de inscripciones
    Given que soy un docente autenticado en la plataforma
    When deseo cancelar la gestión de inscripciones en cualquier punto del proceso
    And decido no aprobar ni denegar las solicitudes de inscripción de los estudiantes en ese momento
    Then se cancela la acción de gestión de inscripciones
    And las solicitudes de inscripción de los estudiantes permanecen pendientes hasta que se toma una decisión
