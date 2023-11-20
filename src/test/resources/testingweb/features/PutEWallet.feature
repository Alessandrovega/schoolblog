Feature: Ingresar E-wallet
  Como usuario, quiero poder ingresar información de mi billetera electrónica (E-wallet) de forma segura, para utilizar métodos de pago alternativos y convenientes.

  Scenario: Ingreso seguro de detalles de E-wallet
    Given que soy un usuario que desea ingresar su E-wallet
    When accedo a la sección de ingreso de E-wallet en mi perfil o durante un proceso de pago
    Then puedo seleccionar la opción de E-wallet y proporcionar la información necesaria, como dirección de correo electrónico o número de cuenta, y el código de seguridad parental
    And el sistema verifica la validez de la información y la almacena de forma segura para futuros pagos

  Scenario: Corrección de detalles de E-wallet inválidos
    Given que soy un usuario que desea ingresar su E-wallet
    When ingreso información incorrecta o inválida de mi E-wallet
    Then el sistema muestra un mensaje de error y solicita la corrección de los detalles
    And no almacena información incorrecta de la E-wallet

  Scenario: Uso de E-wallet ya registrada
    Given que soy un usuario que desea ingresar su E-wallet
    When intento ingresar una E-wallet que ya está registrada en mi perfil
    Then el sistema muestra una notificación indicando que la E-wallet ya está registrada
    And me da la opción de utilizarla para el pago actual o seleccionar otra E-wallet
