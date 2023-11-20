Feature: Mostrar notificaciones

  Como usuario, quiero visualizar las notificaciones en mi página de inicio, para tener información relevante sobre mi cuenta y cursos.

  Scenario: Visualización de notificaciones con acceso a información relevante
    Given que soy un usuario registrado
    And accedo a mi cuenta
    When me carga la página de inicio
    Then se visualizan mis notificaciones
    And al dar clic accedo a la información relevante de mi cuenta y cursos inscritos.

  Scenario: Visualización de notificaciones sin acceso a información relevante
    Given que soy un usuario registrado
    And accedo a mi cuenta
    When me carga la página de inicio
    Then se visualizan mis notificaciones
    And al dar clic no tengo acceso a la información relevante de mi cuenta y cursos inscritos.

  Scenario: Falta de visualización de notificaciones
    Given que soy un usuario registrado
    And accedo a mi cuenta
    When me carga la página de inicio
    Then no se visualizan mis notificaciones
    And no tengo acceso a la información relevante de mi cuenta y cursos inscritos.
