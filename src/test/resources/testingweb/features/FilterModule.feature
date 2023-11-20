Feature: Filtrar por módulo

  Como estudiante, quiero aplicar filtros en los cursos para obtener resultados por módulos o temas de cursos.

  Scenario: Aplicar filtros de búsqueda por módulo exitosamente
    Given que estoy dentro de la plataforma
    When le doy clic a la sección de cursos
    And empiezo a realizar mi búsqueda
    Then aplico los filtros de búsqueda para los cursos por módulo
    And me muestra los resultados de los cursos filtrados por módulo

  Scenario: No obtener resultados con filtros de búsqueda por módulo
    Given que estoy dentro de la plataforma
    When le doy clic a la sección de cursos
    And empiezo a realizar mi búsqueda
    Then aplico los filtros de búsqueda para los cursos por módulo
    And no se muestran resultados de cursos filtrados por módulo

  Scenario: Error al cargar filtros de búsqueda por módulo
    Given que estoy dentro de la plataforma
    When le doy clic a la sección de cursos
    And empiezo a realizar mi búsqueda
    Then no cargan los filtros de búsqueda para los cursos por módulo
    And se muestran los resultados de búsqueda sin filtrar
