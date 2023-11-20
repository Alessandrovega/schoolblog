Feature: Borrar cuenta
  Como usuario, quiero tener la opción de eliminar mi cuenta de forma segura para garantizar la privacidad de mis datos.

  Scenario: Eliminar cuenta exitosamente
    Given que soy un usuario autenticado en la plataforma
    When decido borrar mi cuenta
    And confirmo la acción proporcionando información de seguridad (por ejemplo, contraseña)
    Then mi cuenta se elimina permanentemente de la plataforma
    And recibo una confirmación de que mi cuenta se ha borrado exitosamente

  Scenario: Error al eliminar cuenta por falta de información de seguridad
    Given que soy un usuario autenticado en la plataforma
    When intento borrar mi cuenta
    And no proporcioné la información de seguridad requerida (por ejemplo, contraseña incorrecta)
    Then se me muestra un mensaje de error indicando que la eliminación ha fallado
    And se me solicita proporcionar la información de seguridad correcta antes de proceder

  Scenario: Cancelar eliminación de cuenta
    Given que soy un usuario autenticado en la plataforma
    When decido cancelar la eliminación de mi cuenta en cualquier punto del proceso
    And confirmo la cancelación de la eliminación
    Then la acción de eliminación se detiene
    And se me redirige de vuelta a mi perfil o al área principal de la plataforma
