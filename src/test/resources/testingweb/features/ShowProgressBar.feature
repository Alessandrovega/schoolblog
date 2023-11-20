Feature: Visualizar Porcentaje de Avance de Curso
  Como estudiante, quiero ver el porcentaje de avance de mi curso actual, para tener una idea clara de cuánto he completado y cuánto me queda por aprender.

  Scenario: Ver porcentaje de avance del curso
    Given que soy un estudiante inscrito en un curso
    When accedo a la página del curso
    Then veo un porcentaje que muestra mi avance en el curso actual

  Scenario: Error al intentar ver el porcentaje de avance
    Given que soy un estudiante inscrito en un curso
    When intento ver el porcentaje de avance
    And no se puede calcular el porcentaje debido a un error en los datos del curso
    Then se muestra un mensaje de error

  Scenario: Porcentaje de avance en curso sin contenido
    Given que soy un estudiante inscrito en un curso
    And el curso no tiene contenido aún
    When accedo a la página del curso
    Then el porcentaje de avance se muestra como 0%
    And el porcentaje de avance se actualiza a medida que completo lecciones
