Feature: Seleccionar método de pago
  Como apoderado, quiero tener acceso a una sección de pagos para seleccionar, ingresar y guardar el método de pago que prefiera.

  Scenario: Configuración exitosa del método de pago preferido
    Given que soy un apoderado
    When ingreso a la página de inicio
    And selecciono la opción de pago restringido en el menú lateral
    And accedo a las opciones de pago
    And selecciono la opción de mi preferencia
    And doy clic en aceptar
    Then estará configurado mi método de pago

  Scenario: Falla en la configuración del método de pago preferido
    Given que soy un apoderado
    When ingreso a la página de inicio
    And selecciono la opción de pago restringido en el menú lateral
    And accedo a las opciones de pago
    And selecciono la opción de mi preferencia
    And doy clic en aceptar
    Then no se guarda mi configuración

  Scenario: Configuración sin opciones disponibles
    Given que soy un apoderado
    When ingreso a la página de inicio
    And selecciono la opción de pago restringido en el menú lateral
    Then al dar clic en seleccionar las opciones para métodos de pagos no me muestra opciones
    And no puedo configurar mi método de pago
