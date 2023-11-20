Feature: Visualizar Contenido de Curso Inscrito
  Como estudiante, quiero tener la capacidad de visualizar el contenido del curso al que me he inscrito, para acceder fácilmente a las lecciones y recursos necesarios para mi aprendizaje.

  Scenario: Acceder al contenido del curso inscrito
    Given que soy un estudiante inscrito en un curso
    When accedo a la página del curso
    Then veo una lista organizada de las lecciones, módulos o recursos disponibles para ese curso

  Scenario: Error al intentar acceder al contenido del curso
    Given que soy un estudiante inscrito en un curso
    When intento acceder al contenido del curso
    And se produce un error de carga o conexión
    Then recibo un mensaje de error que indica que no se puede acceder al contenido

  Scenario: Curso sin contenido disponible
    Given que soy un estudiante inscrito en un curso
    And el curso no tiene contenido aún
    When intento acceder al contenido del curso
    Then recibo un mensaje que informa que el contenido aún no está disponible
