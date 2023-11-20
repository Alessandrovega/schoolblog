Feature: Configurar fechas y horarios
  Como docente, quiero la opción de configurar fechas y horarios para las sesiones en vivo, reuniones o clases presenciales relacionadas con el curso, permitiendo una programación efectiva.

  Scenario: Configurar fechas y horarios exitosamente
    Given que soy un docente autenticado en la plataforma
    When deseo configurar fechas y horarios para las sesiones en vivo, reuniones o clases presenciales relacionadas con el curso que he creado
    And establezco las fechas y horarios de manera válida
    Then las fechas y horarios se configuran exitosamente para las actividades del curso
    And los alumnos pueden acceder a la programación de manera efectiva

  Scenario: Error al configurar fechas y horarios por problemas técnicos o información inválida
    Given que soy un docente autenticado en la plataforma
    When intento configurar fechas y horarios
    And ocurre un error técnico o proporciono información inválida en la programación
    Then se me muestra un mensaje de error indicando que la configuración de fechas y horarios ha fallado
    And se me proporcionan instrucciones para solucionar el problema o corregir la información

  Scenario: Cancelar configuración de fechas y horarios
    Given que soy un docente autenticado en la plataforma
    When deseo cancelar la configuración de fechas y horarios en cualquier punto del proceso
    And decido no programar actividades adicionales en ese momento
    Then se cancela la acción de configuración de fechas y horarios
    And se mantiene la programación del curso sin cambios
