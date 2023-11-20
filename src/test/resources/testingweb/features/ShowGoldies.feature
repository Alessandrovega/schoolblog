Feature: Disponibilidad de Goldies para Realizar la Compra
  Como usuario con monedas Goldies, quiero que mis monedas Goldies estén disponibles para su uso inmediato después de la compra, para poder inscribirme en cursos.

  Scenario: Compra exitosa de monedas Goldies con acreditación inmediata
    Given que soy un usuario con monedas Goldies disponibles
    When realizo con éxito la compra de monedas Goldies
    Then las monedas Goldies adquiridas se acreditan instantáneamente en mi saldo
    And puedo utilizarlas para inscribirme en cursos premium u otros elementos de la plataforma de inmediato

  Scenario: Error técnico durante la compra de monedas Goldies
    Given que soy un usuario con monedas Goldies disponibles
    When realizo la compra de monedas Goldies
    And debido a un error técnico, las monedas Goldies no se acreditan inmediatamente
    Then se muestra un mensaje de error indicando el problema
    And las monedas Goldies se acreditan en mi saldo tan pronto como se resuelva el problema

  Scenario: Retraso en la disponibilidad de monedas Goldies después de la compra
    Given que soy un usuario con monedas Goldies disponibles
    When realizo con éxito la compra de monedas Goldies
    And después de la compra, las monedas Goldies no se acreditan de inmediato debido a un problema en el sistema
    Then las monedas Goldies adquiridas no están disponibles de inmediato en mi saldo
    And no puedo utilizarlas para inscribirme en cursos premium u otros elementos de la plataforma de inmediato
    And se muestra un mensaje de notificación informándome sobre el retraso en la disponibilidad de mis monedas Goldies
    And después de que se resuelve el problema, las monedas Goldies se acreditan en mi saldo
    And puedo utilizarlas para inscribirme en cursos premium u otros elementos de la plataforma
