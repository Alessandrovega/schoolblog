Feature: Ingresar Tarjeta
  Como usuario, quiero poder ingresar la información de mi tarjeta de crédito o débito de manera segura, para facilitar futuros pagos y transacciones en la plataforma.

  Scenario: Ingreso seguro de detalles de la tarjeta
    Given que soy un usuario que desea ingresar su tarjeta de crédito o débito
    When accedo a la sección de ingreso de tarjeta en mi perfil o durante un proceso de pago
    Then puedo ingresar los detalles de mi tarjeta, como número, fecha de vencimiento, CVV y código de seguridad paterno
    And el sistema verifica la validez de la tarjeta y la almacena de forma segura para futuros pagos

  Scenario: Corrección de detalles de la tarjeta inválidos
    Given que soy un usuario que desea ingresar su tarjeta de crédito o débito
    When ingreso información incorrecta o inválida de la tarjeta
    Then el sistema muestra un mensaje de error y solicita la corrección de los detalles
    And no almacena información incorrecta de la tarjeta

  Scenario: Uso de tarjeta ya registrada
    Given que soy un usuario que desea ingresar su tarjeta de crédito o débito
    When intento ingresar una tarjeta que ya está registrada en mi perfil
    Then el sistema muestra una notificación indicando que la tarjeta ya está registrada
    And me da la opción de utilizarla para el pago actual o seleccionar otra tarjeta
