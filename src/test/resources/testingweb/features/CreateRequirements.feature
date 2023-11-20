Feature: Establecer requisitos de inscripción
  Como docente, quiero establecer requisitos de inscripción para los estudiantes, como nivel de conocimiento previo o la aprobación de ciertas pruebas, para asegurarme de que los estudiantes adecuados se unan al curso.

  Scenario: Establecer requisitos de inscripción exitosamente
    Given que soy un docente autenticado en la plataforma
    When deseo establecer requisitos de inscripción para los estudiantes en mi curso
    And defino los requisitos de manera válida, como nivel de conocimiento previo o la aprobación de ciertas pruebas
    Then los requisitos de inscripción se establecen exitosamente para el curso
    And los estudiantes deben cumplir con estos requisitos para unirse al curso

  Scenario: Error al establecer requisitos de inscripción por problemas técnicos o requisitos inválidos
    Given que soy un docente autenticado en la plataforma
    When intento establecer requisitos de inscripción
    And ocurre un error técnico o proporciono requisitos inválidos
    Then se me muestra un mensaje de error indicando que el establecimiento de requisitos de inscripción ha fallado
    And se me proporcionan instrucciones para solucionar el problema o corregir los requisitos

  Scenario: Cancelar establecimiento de requisitos de inscripción
    Given que soy un docente autenticado en la plataforma
    When deseo cancelar la configuración de requisitos de inscripción en cualquier punto del proceso
    And decido no establecer requisitos adicionales en ese momento
    Then se cancela la acción de establecer requisitos de inscripción
    And los estudiantes pueden unirse al curso sin cumplir con requisitos específicos
