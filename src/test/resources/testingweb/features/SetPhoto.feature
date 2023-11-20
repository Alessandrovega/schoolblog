Feature: Carga de nombre y fotografía

  Como usuario, quiero visualizar mi nombre y fotografía guardados en mi perfil, para tener personalizada mi página de inicio.

  Scenario: Visualización de nombre y fotografía actualizados
    Given que soy un usuario registrado
    And accedo a mi cuenta
    When me carga la página de inicio
    Then se visualizan mi fotografía y nombre en la parte izquierda de la pantalla
    And se actualiza si edito mi información en mi perfil en cualquier momento.

  Scenario: Visualización de nombre y fotografía sin actualizar
    Given que soy un usuario registrado
    And accedo a mi cuenta
    When me carga la página de inicio
    Then se visualizan mi fotografía y nombre en la parte izquierda de la pantalla
    And no se actualiza si edito mi información en mi perfil

  Scenario: Falta de visualización de nombre y fotografía
    Given que soy un usuario registrado
    And accedo a mi cuenta
    When me carga la página de inicio
    Then no se visualizan mi fotografía y nombre en la parte izquierda de la pantalla
    And no se actualiza si edito mi información en mi perfil
