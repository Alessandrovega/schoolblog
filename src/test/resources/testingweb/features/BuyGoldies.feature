Feature: Compra de monedas Goldies
  Como usuario con monedas Goldies, quiero tener la opción de comprar más monedas Goldies en la plataforma, para adquirir cursos premium y aprovechar las ventajas del sistema Goldies.

  Scenario: Comprar más monedas Goldies con éxito
    Given que soy un usuario con monedas Goldies
    When selecciono la opción para comprar más monedas Goldies
    Then se me redirige a un proceso de pago seguro donde puedo elegir la cantidad de monedas a comprar y completar la transacción con éxito

  Scenario: Error durante la transacción de compra de monedas Goldies
    Given que soy un usuario con monedas Goldies
    When intento comprar más monedas Goldies
    And ocurre un error durante la transacción
    Then se me muestra un mensaje de error claro y se cancela la compra, sin que se realice ningún cargo en mi cuenta

  Scenario: Cancelar la compra de monedas Goldies antes de finalizar
    Given que soy un usuario con monedas Goldies
    When inicio el proceso de compra de monedas Goldies
    And decido cancelar la compra antes de finalizar
    Then la transacción se detiene y no se realiza ningún cargo en mi cuenta
    And se me proporciona una confirmación de cancelación
