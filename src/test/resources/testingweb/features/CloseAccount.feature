Feature: Cerrar sesión
  Como usuario, quiero poder cerrar sesión en mi cuenta en cualquier momento para garantizar la seguridad de mis datos y mi privacidad en la plataforma.

  Scenario: Cerrar sesión exitosamente
    Given que estoy autenticado en la plataforma
    When hago clic en el botón de "Cerrar sesión" en mi cuenta
    And confirmo mi acción
    Then debo ser redirigido a la página de inicio de sesión
    And debería recibir una confirmación de que mi sesión se ha cerrado con éxito

  Scenario: Error al cerrar sesión
    Given que estoy autenticado en la plataforma
    When intento cerrar sesión pero ocurre un error en el proceso
    And no puedo cerrar sesión de manera adecuada
    Then debería recibir un mensaje de error indicando que no se pudo cerrar sesión
    And todavía debería estar autenticado en mi cuenta

  Scenario: Cancelar cierre de sesión
    Given que estoy autenticado en la plataforma
    When intento cerrar sesión pero deseo cancelar la acción
    And hago clic en una opción de cancelar o retorno a la página anterior
    Then no se debe cerrar mi sesión
    And debería permanecer en la página actual o ser redirigido a la página anterior sin cerrar sesión
