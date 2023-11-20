Feature: Recordatorio de Lecciones Incompletas
  Como estudiante, quiero recibir recordatorios periódicos sobre las lecciones que he dejado incompletas, para mantenerme al tanto de mi progreso y motivarme a continuar donde lo dejé.

  Scenario: Recibir recordatorios de lecciones incompletas
    Given que soy un estudiante inscrito en un curso
    And tengo lecciones incompletas en el curso
    When recibo recordatorios periódicos, por ejemplo, semanalmente
    Then los recordatorios me informan sobre las lecciones que aún no he completado

  Scenario: No recibir recordatorios sin lecciones incompletas
    Given que soy un estudiante inscrito en un curso
    And no tengo lecciones incompletas en el curso
    When no recibo recordatorios
    Then no se envían recordatorios, ya que no hay lecciones pendientes

  Scenario: Desactivar recordatorios en la configuración del perfil
    Given que soy un estudiante inscrito en un curso
    And tengo lecciones incompletas en el curso
    When desactivo los recordatorios en la configuración de mi perfil
    Then no recibo recordatorios, incluso si tengo lecciones incompletas
