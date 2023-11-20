Feature: Selección de curso

  Como estudiante, quiero visualizar y seleccionar los cursos que me aparecen en los resultados de búsqueda, para obtener información de los cursos antes de inscribirme.

  Scenario: Acceder a un curso y ver información
    Given que estoy dentro de la plataforma
    When ingreso a la sección de cursos
    And empiezo a seleccionar cualquier curso
    Then accedo al curso
    And me muestra la información, sus módulos y su precio

  Scenario: Acceder a un curso y no ver información
    Given que estoy dentro de la plataforma
    When ingreso a la sección de cursos
    And empiezo a seleccionar cualquier curso
    Then accedo al curso
    And no me muestra la información, sus módulos y su precio

  Scenario: No tener acceso a ningún curso
    Given que estoy dentro de la plataforma
    When ingreso a la sección de cursos
    And empiezo a seleccionar cualquier curso
    Then no tengo acceso a ningún curso
    And tengo que actualizar la plataforma
