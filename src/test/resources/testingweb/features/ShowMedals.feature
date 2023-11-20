Feature: Mostrar medallas obtenidas

  Como estudiante, quiero visualizar las medallas que obtuve como recompensa por terminar mis cursos, para conocer mi avance y logros obtenidos en la plataforma.

  Scenario: Visualización de medallas y avance en general
    Given que soy un usuario registrado
    And accedo a mi cuenta
    And me carga la página de inicio
    When me dirijo a mi perfil
    Then puedo visualizar un botón que me redirige a todos los logros que tengo hasta ahora
    And puedo visualizar otro botón que me redirige al avance en general que tengo en cada curso inscrito.

  Scenario: Visualización de medallas sin acceso al progreso de cursos
    Given que soy un usuario registrado
    And accedo a mi cuenta
    And me carga la página de inicio
    When me dirijo a mi perfil
    Then puedo visualizar un botón que me dirija a los logros que tengo hasta ahora
    And no cuento con un botón para ver el progreso que tengo en cada curso inscrito.

  Scenario: Falta de visualización de medallas y progreso
    Given que soy un usuario registrado
    And accedo a mi cuenta
    And me carga la página de inicio
    When me dirijo a mi perfil
    Then no cuento con un botón que me dirija a los logros que tengo hasta ahora
    And tampoco cuento con un botón para ver el progreso que tengo en cada curso inscrito.
