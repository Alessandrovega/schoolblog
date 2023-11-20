Feature: Ver saldo de monedas Goldies en mi perfil
  Como estudiante, quiero visualizar mi cantidad de monedas Goldies compradas en mi perfil para conocer el monto exacto del que dispongo.

  Scenario: Visualizar saldo de monedas Goldies y acceder al historial de compras
    Given que soy un estudiante registrado
    When accedo a la plataforma
    And quiero visualizar mi cantidad de monedas Goldies
    Then se muestra una sección en la parte superior derecha con la cantidad de monedas Goldies que tengo
    And al darle clic, accedo al historial de compras de monedas Goldies

  Scenario: Visualizar saldo de monedas Goldies y ver historial de compras desactualizado
    Given que soy un estudiante registrado
    When accedo a la plataforma
    And quiero visualizar mi cantidad de monedas Goldies
    Then se muestra una sección en la parte superior derecha con la cantidad de monedas Goldies que tengo
    And al darle clic, se visualiza mi historial de compras de monedas Goldies desactualizado

  Scenario: No visualizar saldo de monedas Goldies y no acceder al historial de compras
    Given que soy un estudiante registrado
    When accedo a la plataforma
    And quiero visualizar mi cantidad de monedas Goldies
    Then no se muestra una sección en la parte superior derecha con la cantidad de monedas Goldies que tengo
    And al darle clic no me permite acceder al historial de compras de monedas Goldies
