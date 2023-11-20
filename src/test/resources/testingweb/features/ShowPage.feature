Feature: Visualización de la paginación

  Como estudiante, quiero visualizar y seleccionar la paginación de búsqueda, para navegar libremente por la página y encontrar los cursos de mi preferencia.

  Scenario: Visualización de página siguiente
    Given que me encuentro en la sección de cursos
    When realizo una búsqueda
    And se cargan los resultados
    Then si indica que hay más resultados encontrados
    And quiero visualizar más resultados, selecciono página siguiente

  Scenario: Intento de acceso a más resultados
    Given que me encuentro en la sección de cursos
    When realizo una búsqueda
    And se cargan los resultados
    Then si indica que hay más resultados encontrados
    And selecciono página siguiente no se accede a más resultados

  Scenario: Sin opción de página siguiente
    Given que me encuentro en la sección de cursos
    When realizo una búsqueda
    And se cargan los resultados
    Then si indica que hay más resultados encontrados
    And no aparece la opción de página siguiente, no se visualizan los resultados
