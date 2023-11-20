Feature: Mostrar Notas Detalladas
  Como estudiante, quiero tener acceso a notas detalladas sobre mi desempeño en el curso, para comprender en qué áreas puedo mejorar y cómo estoy progresando.

  Scenario: Acceder a notas detalladas
    Given que soy un estudiante que ha completado un curso
    When accedo a la página de resumen de mi curso
    Then veo notas detalladas que incluyen calificaciones por tarea, pruebas o evaluaciones realizadas en el curso

  Scenario: Notas detalladas no disponibles
    Given que soy un estudiante que ha completado un curso
    When intento acceder a las notas detalladas
    Then si las notas aún no están disponibles o hay un error en la carga, recibo un mensaje que indica que las notas no están disponibles en ese momento

  Scenario: No hay calificaciones asignadas
    Given que soy un estudiante que ha completado un curso
    When accedo a la página de resumen de mi curso
    Then si no se asignaron calificaciones o notas en el curso, veo un mensaje que indica que no hay notas disponibles
