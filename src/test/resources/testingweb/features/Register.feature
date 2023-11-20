Feature: Registrarse
  Como alumno nuevo, quiero registrarme en la plataforma para acceder a cursos y contenido educativo.

  Scenario: Registro exitoso
    Given que soy un nuevo usuario
    When ingreso mi información de registro válida, incluyendo nombre de usuario, contraseña y dirección de correo electrónico
    And confirmo mi registro
    Then se crea una cuenta en la plataforma de forma exitosa
    And se me redirige a la página de inicio de sesión

  Scenario: Registro con errores
    Given que soy un nuevo usuario
    When ingreso mi información de registro
    And cometo un error en algún campo o no completo todos los campos requeridos
    Then no se crea la cuenta y se muestran mensajes de error para corregir los campos
    And no se me redirige a la página de inicio de sesión

  Scenario: Registro con información duplicada
    Given que soy un nuevo usuario
    When ingreso mi información de registro válida, incluyendo nombre de usuario, contraseña y dirección de correo electrónico
    And ya existe una cuenta con la misma dirección de correo electrónico o nombre de usuario
    Then no se crea una nueva cuenta
    And se me notifica que la dirección de correo electrónico o nombre de usuario ya está en uso
    And se me proporciona la opción de restablecer mi contraseña o iniciar sesión en mi cuenta existente
