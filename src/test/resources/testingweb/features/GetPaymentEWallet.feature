Feature: Recibir pago en e-wallet
  Como docente, quiero escoger mi e-wallet como depósito de pago para recibir mis ganancias generadas por mis servicios en tutorías y alumnos que compran mis cursos.

  Scenario: Configuración exitosa de e-wallet como medio de depósito
    Given que soy un docente
    When ingreso a mi página de inicio
    And selecciono la opción de pagos en el menú lateral
    And selecciono la opción e-wallet como medio de depósito de pagos
    And doy clic en aceptar
    Then estará configurado mi medio de depósito

  Scenario: Falla en la configuración de e-wallet como medio de depósito
    Given que soy un docente
    When ingreso a mi página de inicio
    And selecciono la opción de pagos en el menú lateral
    And selecciono la opción e-wallet como medio de depósito de pagos
    And doy clic en aceptar
    Then no se guarda mi configuración

  Scenario: Configuración sin opciones disponibles
    Given que soy un docente
    When ingreso a mi página de inicio
    And selecciono la opción de pagos en el menú lateral
    Then al dar clic en seleccionar las opciones para depósito de pagos no me muestra opciones
    And no puedo configurar mi depósito para pagos
