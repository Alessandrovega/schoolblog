Feature: Mostrar sección de cursos inscritos

  Como estudiante, quiero visualizar una sección que muestre mis cursos inscritos, para tener un acceso más rápido a mis cursos.

  Scenario: Visualización de la sección de cursos inscritos y acceso a cursos
    Given que soy un usuario registrado
    And accedo a mi cuenta
    And me carga la página de inicio
    Then se visualiza una sección de cursos inscritos
    When doy clic en la sección de cursos inscritos
    Then accedo a mis cursos inscritos, incompletos y terminados.

  Scenario: Visualización de la sección de cursos inscritos sin acceso a cursos
    Given que soy un usuario registrado
    And accedo a mi cuenta
    And me carga la página de inicio
    Then se visualiza una sección de cursos inscritos
    When doy clic en la sección de cursos inscritos
    Then no tengo acceso a mis cursos inscritos

  Scenario: Falta de visualización de la sección de cursos inscritos
    Given que soy un usuario registrado
    And accedo a mi cuenta
    And me carga la página de inicio
    Then no se visualiza la sección de mis cursos inscritos
    And no tengo acceso al avance de mis cursos inscritos
