Feature: Configurar Preferencias de Facturación
  Como usuario, quiero tener la capacidad de personalizar mis preferencias de facturación y notificaciones relacionadas con el pago, para adaptar la forma en que recibo información y comunicaciones financieras de acuerdo con mis preferencias personales.

  Scenario: Personalización de preferencias de facturación y notificaciones
    Given que soy un usuario que desea personalizar sus preferencias de facturación y notificaciones de pago
    When accedo a la sección de configuración de preferencias de facturación en mi perfil
    Then puedo seleccionar las opciones específicas que se relacionan con la facturación y las notificaciones
    And guardo mis preferencias personalizadas

  Scenario: Corrección de errores en preferencias de facturación
    Given que soy un usuario que desea personalizar sus preferencias de facturación y notificaciones de pago
    When intento guardar mis preferencias pero encuentro un error o falta de información en mi perfil
    Then el sistema muestra un mensaje de error y me guía para corregir la información faltante o incorrecta
    And se guarda la configuración de preferencias una vez corregida

  Scenario: Activación de nuevas opciones de notificación
    Given que soy un usuario que desea personalizar sus preferencias de facturación y notificaciones de pago
    When el sistema lanza una nueva opción de notificación, como notificaciones móviles
    Then se me notifica sobre la nueva opción y se me brinda la posibilidad de activarla o desactivarla según mis preferencias
