Feature: Eliminar el curso
  Como docente, quiero eliminar un curso en la plataforma para retirar contenidos obsoletos o no deseados, asegurando que los alumnos no tengan acceso a él.

  Scenario: Eliminar el curso exitosamente
    Given que soy un docente autenticado en la plataforma
    When deseo eliminar un curso que he creado
    And confirmo la acción de eliminación
    Then el curso se elimina con éxito de la plataforma
    And los alumnos ya no tienen acceso al contenido del curso

  Scenario: Error al eliminar el curso por problemas técnicos
    Given que soy un docente autenticado en la plataforma
    When intento eliminar un curso
    And ocurre un error técnico o surge un problema al intentar eliminar el curso
    Then se me muestra un mensaje de error indicando que la eliminación del curso ha fallado
    And se me proporcionan instrucciones para solucionar el problema técnico

  Scenario: Cancelar eliminación del curso
    Given que soy un docente autenticado en la plataforma
    When deseo cancelar la eliminación del curso en cualquier punto del proceso
    And decido no eliminar el curso en ese momento
    Then se cancela la acción de eliminación del curso
    And el curso se mantiene disponible para los alumnos sin cambios en su contenido
