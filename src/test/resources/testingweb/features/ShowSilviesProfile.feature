Feature: Ver saldo de monedas Silvies en mi perfil
  Como estudiante, quiero visualizar mi cantidad de monedas Silvies ganadas en mi perfil para conocer el monto exacto del que dispongo.

  Scenario: Visualizar saldo de monedas Silvies actualizado
    Given que soy un estudiante registrado
    When accedo a la plataforma
    And quiero visualizar mi cantidad de monedas Silvies
    Then se muestra una sección en la parte superior derecha con la cantidad de monedas Silvies que tengo
    And al darle clic accedo al historial de ganancias

  Scenario: Visualizar saldo de monedas Silvies con historial desactualizado
    Given que soy un estudiante registrado
    When accedo a la plataforma
    And quiero visualizar mi cantidad de monedas Silvies
    Then se muestra una sección en la parte superior derecha con la cantidad de monedas Silvies que tengo
    And al darle clic se visualiza mi historial de ganancias desactualizado

  Scenario: No visualizar saldo de monedas Silvies
    Given que soy un estudiante registrado
    When accedo a la plataforma
    And quiero visualizar mi cantidad de monedas Silvies
    Then no se muestra una sección en la parte superior derecha con la cantidad de monedas Silvies que tengo
    And al darle clic no me permite acceder al historial de ganancias
