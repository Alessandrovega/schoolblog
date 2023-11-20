Feature: Confirmación de Pago
  Como usuario, quiero recibir una confirmación inmediata después de realizar un pago, para tener la certeza de que mi pago se procesó correctamente.

  Scenario: Confirmación de pago exitoso
    Given que soy un usuario que ha realizado un pago
    When finalizo el proceso de pago y se confirma la transacción
    Then recibo una notificación inmediata que confirma el pago exitoso
    And se actualiza el saldo en mi cuenta

  Scenario: Error en la transacción de pago
    Given que soy un usuario que ha realizado un pago
    When finalizo el proceso de pago, pero ocurre un error en la transacción
    Then recibo una notificación que indica el fallo en el proceso
    And se proporciona información sobre cómo proceder para resolver el problema

  Scenario: Verificar el estado de la transacción
    Given que soy un usuario que ha realizado un pago
    When finalizo el proceso de pago, pero no recibo una confirmación inmediata
    Then puedo consultar el historial de transacciones en mi perfil
    And verificar el estado de la transacción para obtener la confirmación
