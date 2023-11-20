Feature: Ganar monedas Silvies al completar un curso
  Como alumno, quiero ganar monedas Silvies al completar un curso para recompensar mi esfuerzo y dedicación en el aprendizaje, y para aumentar mi saldo de monedas Silvies que me permita acceder a más cursos y ventajas adicionales en la plataforma.

  Scenario: Ganar monedas Silvies al completar un curso exitosamente
    Given que soy un alumno que ha completado un curso en la plataforma
    When finalizo con éxito todas las actividades y requisitos del curso
    And el sistema verifica mi finalización
    Then se me otorgan monedas Silvies como recompensa
    And el saldo de mis monedas Silvies se incrementa de acuerdo a las monedas ganadas

  Scenario: No ganar monedas Silvies al no completar el curso con éxito
    Given que soy un alumno que ha completado un curso en la plataforma
    When no logro cumplir con los requisitos o actividades necesarias para finalizar el curso
    And el sistema verifica que no he completado el curso con éxito
    Then no se me otorgan monedas Silvies como recompensa
    And mi saldo de monedas Silvies permanece sin cambios

  Scenario: No ganar monedas Silvies al abandonar el curso
    Given que soy un alumno que ha completado un curso en la plataforma
    When decido abandonar el curso en cualquier punto del proceso de aprendizaje
    And no completo todas las actividades o requisitos
    Then no se me otorgan monedas Silvies como recompensa por el curso
    And mi saldo de monedas Silvies permanece sin cambios
