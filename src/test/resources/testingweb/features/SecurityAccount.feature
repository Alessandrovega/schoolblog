Feature: Seguridad de cuenta
  Como usuario, quiero mejorar la seguridad de mi cuenta para proteger mi información personal.

  Scenario: Mejora de seguridad exitosa
    Given que soy un usuario autenticado en la plataforma
    When deseo mejorar la seguridad de mi cuenta
    And realizo las acciones necesarias para aumentar la seguridad de mi cuenta
    Then la seguridad de mi cuenta se mejora con éxito
    And recibo una confirmación de que mi cuenta ahora es más segura

  Scenario: Problemas técnicos al mejorar seguridad
    Given que soy un usuario autenticado en la plataforma
    When intento mejorar la seguridad de mi cuenta
    And surgen problemas técnicos o de configuración que impiden la mejora de la seguridad
    Then se me muestra un mensaje de error indicando que la mejora de seguridad ha fallado
    And se me proporcionan instrucciones para resolver el problema o intentarlo más tarde

  Scenario: No se realizan cambios en la seguridad
    Given que soy un usuario autenticado en la plataforma
    When deseo mantener la seguridad de mi cuenta sin realizar cambios adicionales
    And decido no realizar ninguna acción adicional para aumentar la seguridad de mi cuenta
    Then la configuración de seguridad de mi cuenta permanece sin cambios
    And puedo seguir utilizando mi cuenta con las medidas de seguridad existentes
