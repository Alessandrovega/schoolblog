Feature: Generar Recibo
  Como usuario, quiero poder generar un recibo o comprobante de pago en formato digital, para mantener un registro de mis transacciones.

  Scenario: Generar un recibo individual
    Given que soy un usuario que desea generar un recibo
    When selecciono la opción para generar un recibo después de realizar un pago
    Then se genera un recibo en formato digital que incluye detalles de la transacción, como fecha, monto y descripción
    And puedo descargar o guardar el recibo para mis registros

  Scenario: Error al generar el recibo
    Given que soy un usuario que desea generar un recibo
    When intento generar un recibo pero ocurre un error en el proceso
    Then el sistema muestra un mensaje de error
    And se proporciona un enlace alternativo para intentar nuevamente o recibir ayuda

  Scenario: Generar un recibo consolidado
    Given que soy un usuario que desea generar un recibo
    When realizo múltiples transacciones en un solo pago
    Then el sistema permite generar un recibo consolidado que incluye todas las transacciones realizadas en ese pago
