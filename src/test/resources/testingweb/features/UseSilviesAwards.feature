Feature: Usar monedas Silvies en la tienda de Recompensas
  Como usuario con monedas Silvies, quiero tener la posibilidad de canjear mis monedas Silvies por recompensas en la tienda de la plataforma, para obtener beneficios adicionales y aprovechar mis monedas de manera significativa.

  Scenario: Canjear una recompensa con suficientes monedas Silvies
    Given que soy un usuario con monedas Silvies disponibles en mi billetera virtual
    And navego hasta la sección de la tienda de recompensas
    When selecciono una recompensa que deseo canjear
    Then puedo confirmar mi selección y la cantidad de monedas Silvies que se deducirán de mi saldo
    And la recompensa seleccionada se agrega a mi perfil o se activa inmediatamente según corresponda

  Scenario: Error al canjear una recompensa por falta de monedas Silvies
    Given que soy un usuario con algunas monedas Silvies disponibles en mi billetera virtual
    And navego hasta la sección de la tienda de recompensas
    When intento seleccionar una recompensa que requiere más monedas Silvies de las que tengo disponibles en mi saldo
    Then se me muestra un mensaje de error que indica que no tengo suficientes monedas Silvies para canjear esa recompensa
    And no se realiza ninguna deducción de mis monedas Silvies
    And no se agrega ninguna recompensa a mi perfil

  Scenario: Error técnico al intentar canjear una recompensa
    Given que soy un usuario con monedas Silvies disponibles en mi billetera virtual
    And navego hasta la sección de la tienda de recompensas
    When selecciono una recompensa que deseo canjear
    And se produce un error técnico en el proceso de canje
    Then se me muestra un mensaje de error indicando que ha habido un problema técnico y que no se pudo realizar el canje en ese momento
    And se proporciona un enlace o información de contacto para que pueda informar sobre el problema y recibir asistencia técnica si es necesario
    And no se realiza ninguna deducción de mis monedas Silvies hasta que se resuelva el problema
