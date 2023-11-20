Feature: Login
  Como usuario, quiero poder iniciar sesión en la plataforma utilizando mis credenciales (nombre de usuario y contraseña) para acceder a mi cuenta de manera segura.

  Scenario: Iniciar sesión exitosamente
    Given que soy un usuario registrado en la plataforma
    When ingreso mi nombre de usuario y contraseña válidos
    And presiono el botón de inicio de sesión
    Then debo ser redirigido a mi cuenta de usuario
    And debería tener acceso a las funciones de la plataforma

  Scenario: Iniciar sesión con contraseña incorrecta
    Given que soy un usuario registrado en la plataforma
    When ingreso un nombre de usuario válido pero una contraseña incorrecta
    And presiono el botón de inicio de sesión
    Then debo recibir un mensaje de error indicando que las credenciales son incorrectas
    And no debería tener acceso a mi cuenta de usuario

  Scenario: Olvidar contraseña
    Given que soy un usuario registrado en la plataforma
    When intento iniciar sesión pero olvido ingresar mi contraseña
    And hago clic en el enlace "¿Olvidaste tu contraseña?"
    Then debo ser redirigido a la página de recuperación de contraseña
    And debería poder seguir los pasos para restablecer mi contraseña a través de un proceso seguro
