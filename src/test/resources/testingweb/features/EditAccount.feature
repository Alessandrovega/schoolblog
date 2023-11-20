Feature: Editar datos personales
  Como usuario, quiero editar mis datos personales de manera sencilla para mantenerlos actualizados y precisos en mi perfil.

  Scenario: Editar datos exitosamente
    Given que soy un usuario autenticado en la plataforma
    When deseo editar mis datos personales
    And proporciono información válida y actualizada en los campos correspondientes
    Then los cambios se guardan correctamente en mi perfil
    And recibo una confirmación de que mis datos se han actualizado exitosamente

  Scenario: Editar datos con errores
    Given que soy un usuario autenticado en la plataforma
    When intento editar mis datos personales
    And proporciono información inválida o incompleta en los campos correspondientes
    Then se me muestra un mensaje de error indicando que la edición ha fallado
    And se me solicita corregir los datos incorrectos antes de guardar

  Scenario: Cancelar edición de datos
    Given que soy un usuario autenticado en la plataforma
    When deseo editar mis datos personales
    And decido cancelar la edición en cualquier punto del proceso
    Then se me redirige de vuelta a mi perfil sin realizar ningún cambio
    And mis datos personales permanecen sin cambios
