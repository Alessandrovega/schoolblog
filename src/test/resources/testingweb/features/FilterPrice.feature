Feature: Filtrar por precio

  Como estudiante, quiero aplicar filtros de precio en mis resultados de búsqueda para explorar los cursos que puedo adquirir con mis Goldies.

  Scenario: Aplicar filtros de búsqueda por precio exitosamente
    Given que estoy dentro de la plataforma
    When le doy clic a la sección de cursos
    And empiezo a realizar mi búsqueda
    Then aplico los filtros de búsqueda para los precios de los cursos
    And me muestra los resultados de acuerdo a los precios filtrados

  Scenario: No obtener resultados con filtros de búsqueda por precio
    Given que estoy dentro de la plataforma
    When le doy clic a la sección de cursos
    And empiezo a realizar mi búsqueda
    Then aplico los filtros de búsqueda para los precios de los cursos
    And no me muestra resultados de acuerdo a los precios filtrados

  Scenario: Error al cargar filtros de búsqueda por precio
    Given que estoy dentro de la plataforma
    When le doy clic a la sección de cursos
    And empiezo a realizar mi búsqueda
    Then no se aplican los filtros de búsqueda para los precios de los cursos
    And no me muestra ningún resultado
