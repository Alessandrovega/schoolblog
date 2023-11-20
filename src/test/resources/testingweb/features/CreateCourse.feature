Feature: Crear un nuevo curso
  Como docente, quiero poder crear un nuevo curso en la plataforma para compartir mi conocimiento con los alumnos, proporcionando un título, descripción, objetivos y duración del curso.

  Scenario: Crear curso exitosamente
    Given que soy un docente autenticado en la plataforma
    When deseo crear un nuevo curso
    And proporciono un título, descripción, objetivos y duración válidos para el curso
    Then el curso se crea con éxito en la plataforma
    And recibo una confirmación de que el curso ha sido creado exitosamente

  Scenario: Error al crear curso por campos incompletos o inválidos
    Given que soy un docente autenticado en la plataforma
    When intento crear un nuevo curso
    And dejo campos obligatorios en blanco o proporciono información inválida en los campos requeridos
    Then se me muestra un mensaje de error indicando que la creación del curso ha fallado
    And se me solicita corregir los campos antes de poder continuar

  Scenario: Cancelar creación de curso
    Given que soy un docente autenticado en la plataforma
    When deseo cancelar la creación del curso en cualquier punto del proceso
    And decido no crear el curso en ese momento
    Then se cancela la acción de creación del curso
    And se me redirige de vuelta a la plataforma sin crear un nuevo curso
