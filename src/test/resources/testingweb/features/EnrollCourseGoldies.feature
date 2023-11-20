Feature: Inscripción de Curso con Monedas Goldies
  Como usuario con monedas Goldies, quiero tener la opción de inscribirme en un curso utilizando mis monedas Goldies, para acceder a los cursos que ofrece la plataforma.

  Scenario: Inscribirse en un curso con monedas Goldies con éxito
    Given que soy un usuario con monedas Goldies y estoy interesado en un curso premium
    When selecciono la opción de inscribirme en el curso utilizando mis monedas Goldies
    And tengo suficientes monedas para cubrir el costo del curso
    Then se me inscribe exitosamente en el curso y se descuentan las monedas Goldies necesarias de mi saldo

  Scenario: Saldo insuficiente para la inscripción con monedas Goldies
    Given que soy un usuario con monedas Goldies y quiero inscribirme en un curso
    When selecciono la opción de inscripción con mis monedas Goldies
    And mi saldo de monedas Goldies es insuficiente para cubrir el costo total del curso
    Then se me muestra un mensaje de error que indica que no tengo suficientes monedas Goldies para inscribirme en el curso y se me redirige a la opción de comprar más monedas

  Scenario: Cancelar la inscripción con monedas Goldies antes de finalizar
    Given que soy un usuario con monedas Goldies y quiero inscribirme en un curso
    When inicio el proceso de inscripción utilizando mis monedas Goldies
    And decido cancelar la inscripción antes de finalizarla
    Then la inscripción se detiene y no se descuentan monedas de mi saldo. Se me proporciona una confirmación de cancelación
