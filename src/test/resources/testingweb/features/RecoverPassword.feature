Feature: Recuperar contraseña
  Como usuario, quiero tener la opción de recuperar mi contraseña en caso de olvidarla, para poder restablecerla de manera segura a través de un proceso de recuperación de contraseña.

  Scenario: Recuperación de contraseña exitosa
    Given que soy un usuario registrado en la plataforma
    When olvido mi contraseña
    And sigo el proceso de recuperación de contraseña proporcionando mi dirección de correo electrónico
    Then debo recibir un correo electrónico de restablecimiento de contraseña con un enlace seguro
    And al hacer clic en el enlace, debo ser redirigido a una página donde pueda crear una nueva contraseña
    And una vez que establezca la nueva contraseña, debería poder iniciar sesión con éxito usando la nueva contraseña

  Scenario: Dirección de correo electrónico incorrecta
    Given que soy un usuario registrado en la plataforma
    When olvido mi contraseña
    And sigo el proceso de recuperación de contraseña proporcionando una dirección de correo electrónico incorrecta o no registrada en la plataforma
    Then debo recibir un mensaje de error indicando que la dirección de correo electrónico no existe o es incorrecta
    And no debería recibir un correo electrónico de restablecimiento de contraseña

  Scenario: Correo de recuperación en carpeta de spam
    Given que soy un usuario registrado en la plataforma
    When olvido mi contraseña
    And sigo el proceso de recuperación de contraseña proporcionando una dirección de correo electrónico válida
    But no recibo el correo electrónico de restablecimiento de contraseña después de un tiempo razonable
    Then debo tener la opción de verificar mi carpeta de spam o correo no deseado
    And si el correo electrónico está en la carpeta de spam, debería recibir instrucciones para marcarlo como correo deseado
