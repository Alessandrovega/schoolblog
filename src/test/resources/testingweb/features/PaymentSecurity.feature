Feature: Seguridad de Pagos
  Como usuario, quiero que mis datos de pago estén protegidos mediante medidas de seguridad robustas, para salvaguardar mis datos financieros de posibles amenazas cibernéticas.

  Scenario: Protección de datos de pago
    Given que soy un usuario que realiza un pago
    When ingreso mis datos de pago, como número de tarjeta y CVV
    Then el sistema cifra y protege mis datos de manera segura durante la transacción
    And se procesa el pago de forma segura

  Scenario: Detección de acceso no autorizado
    Given que soy un usuario que realiza un pago
    When se intenta acceder o modificar mis datos de pago por un tercero no autorizado
    Then el sistema detecta el intento de acceso no autorizado y bloquea la transacción
    And notifica al usuario y al equipo de seguridad sobre el intento

  Scenario: Autenticación adicional para comportamiento inusual
    Given que soy un usuario que realiza un pago
    When el sistema detecta un comportamiento inusual o una posible amenaza de seguridad durante la transacción
    Then se solicita autenticación adicional al usuario para confirmar su identidad antes de completar la transacción
