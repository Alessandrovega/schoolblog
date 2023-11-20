Feature: Filtrar por categoría

  Como estudiante, quiero aplicar filtros en mis resultados de búsqueda para obtener mejores resultados según mis preferencias.

  Scenario: Aplicar filtros de búsqueda exitosamente
    Given que estoy dentro de la plataforma
    When le doy clic a la sección de cursos
    And empiezo a realizar mi búsqueda
    Then aplico los filtros de búsqueda
    And me muestra los resultados de los cursos que coinciden con mis preferencias

  Scenario: No obtener resultados con filtros de búsqueda
    Given que estoy dentro de la plataforma
    When le doy clic a la sección de cursos
    And empiezo a realizar mi búsqueda
    Then aplico los filtros de búsqueda
    And no me muestra resultados de cursos que coincidan con mis preferencias

  Scenario: Error al cargar filtros de búsqueda
    Given que estoy dentro de la plataforma
    When le doy clic a la sección de cursos
    And empiezo a realizar mi búsqueda
    Then no se cargan los filtros de búsqueda
    And me muestra un mensaje de error
