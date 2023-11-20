Feature: Recibir sugerencias de filtros de búsqueda

  Como estudiante, quiero recibir sugerencias de filtros personalizados de acuerdo a mi historial de búsqueda, para encontrar mis cursos de manera más rápida.

  Scenario: Activar sugerencias de filtros
    Given que me encuentro en la página de inicio
    When selecciono la opción de notificaciones
    And activo la opción de sugerencias
    Then al seleccionar la opción de cursos se activarán los filtros por defecto
    And me mostrará unos resultados de búsqueda predeterminada

  Scenario: Desactivar sugerencias de filtros
    Given que me encuentro en la página de inicio
    When selecciono la opción de notificaciones
    And activo la opción de sugerencias
    Then al seleccionar la opción de cursos no se activan los filtros por defecto
    And tengo que ingresar los filtros nuevamente

  Scenario: Sin opción de activar sugerencias
    Given que me encuentro en la página de inicio
    When selecciono la opción de notificaciones
    And no aparece la opción de activar de sugerencias
    Then no se tiene acceso a los filtros predeterminados
    And no se mostrará la búsqueda predeterminada
