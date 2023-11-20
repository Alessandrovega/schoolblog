Feature: Pago Restringido
  Como usuario, quiero que algunos pagos estén restringidos o requieran autorización adicional, para garantizar la seguridad de ciertas transacciones y evitar accesos no autorizados.

  Scenario: Realizar un pago restringido con autenticación adicional correcta
    Given que soy un usuario que desea realizar un pago restringido
    When inicio el proceso de pago y selecciono la transacción restringida
    And se me solicita la autenticación adicional, como una contraseña o código de seguridad único
    And ingreso la autenticación adicional correcta
    Then se procesa el pago restringido con éxito

  Scenario: Error al ingresar la autenticación adicional incorrecta
    Given que soy un usuario que desea realizar un pago restringido
    When inicio el proceso de pago y selecciono la transacción restringida
    And se me solicita la autenticación adicional, como una contraseña o código de seguridad único
    And ingreso una autenticación adicional incorrecta
    Then el sistema muestra un mensaje de error
    And se impide la realización del pago restringido

  Scenario: Habilitar la autenticación adicional en la cuenta
    Given que soy un usuario que desea realizar un pago restringido
    When inicio el proceso de pago y selecciono la transacción restringida
    And no tengo habilitada la autenticación adicional en mi cuenta
    Then el sistema me redirige a la configuración de seguridad para habilitarla
    And una vez habilitada, puedo continuar con el proceso de pago restringido
