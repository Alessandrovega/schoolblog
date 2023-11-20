Feature: Filtrar por nivel educativo

  Como estudiante, quiero aplicar filtros que me permitan seleccionar mi nivel educativo, para obtener resultados en cursos de mi interés.

  Scenario: Aplicar filtros de búsqueda por nivel educativo exitosamente
    Given que estoy dentro de la plataforma
    When le doy clic a la sección de cursos
    And empiezo a realizar mi búsqueda
    Then aplico los filtros de búsqueda para el nivel educativo de los cursos
    And me muestra los resultados de acuerdo al nivel educativo seleccionado

  Scenario: No obtener resultados con filtros de búsqueda por nivel educativo
    Given que estoy dentro de la plataforma
    When le doy clic a la sección de cursos
    And empiezo a realizar mi búsqueda
    Then aplico los filtros de búsqueda para el nivel educativo de los cursos
    And no me muestra resultados de acuerdo al nivel educativo seleccionado

  Scenario: Error al cargar filtros de búsqueda por nivel educativo
    Given que estoy dentro de la plataforma
    When le doy clic a la sección de cursos
    And empiezo a realizar mi búsqueda
    Then no se aplican los filtros de búsqueda para el nivel educativo de los cursos
    And no me muestra ningún resultado
