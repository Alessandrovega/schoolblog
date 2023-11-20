Feature: Ver historial de pagos
  Como apoderado del estudiante, quiero tener acceso a un historial de pagos para tener un control de las compras realizadas con mi medio de pago guardado.

  Scenario: Visualizar historial de pagos con movimientos
    Given que soy un apoderado de un estudiante registrado
    When ingreso a la página de inicio
    And selecciono la opción de pago restringido en el menú lateral
    Then accedo a la opción de historial de pago
    And visualizo los movimientos realizados con mi método de pago guardado.

  Scenario: Visualizar historial de pagos sin movimientos
    Given que soy un apoderado de un estudiante registrado
    When ingreso a la página de inicio
    And selecciono la opción de pago restringido en el menú lateral
    Then accedo a la opción de historial de pago
    And no visualizo ningún movimiento realizado con mi método de pago guardado.

  Scenario: No tener acceso al historial de pagos
    Given que soy un apoderado de un estudiante registrado
    When ingreso a la página de inicio
    And selecciono la opción de pago restringido en el menú lateral
    Then le doy clic a la opción de historial de pago
    And no tengo acceso, mostrándome un mensaje de error.
