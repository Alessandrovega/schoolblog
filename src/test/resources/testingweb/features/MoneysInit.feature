Feature: Entrega de Monedas Iniciales para Nuevos Usuarios
  Como nuevo alumno, quiero recibir monedas Goldies iniciales al registrarme en la plataforma para poder tomar mi primer curso gratis.

  Scenario: Visualizar notificación y opción para curso gratis
    Given que soy un nuevo estudiante registrado
    When accedo a la plataforma
    And quiero visualizar mi cantidad de monedas Goldies recibidas
    Then se muestra una notificación indicando la cantidad de monedas Goldies que tengo
    And al darle clic, aparece la opción para acceder a mi primer curso gratis

  Scenario: Visualizar notificación sin opción para curso gratis
    Given que soy un nuevo estudiante registrado
    When accedo a la plataforma
    And quiero visualizar mi cantidad de monedas Goldies recibidas
    Then se muestra una notificación indicando la cantidad de monedas Goldies que tengo
    And al darle clic, no aparece la opción para acceder a mi primer curso gratis

  Scenario: No visualizar notificación ni opción para curso gratis
    Given que soy un nuevo estudiante registrado
    When accedo a la plataforma
    And quiero visualizar mi cantidad de monedas Goldies recibidas
    Then no recibo ninguna notificación ni puedo visualizar las Goldies que tengo
    And no aparece la opción para acceder a mi primer curso gratis
