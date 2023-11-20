Feature: Recibir Certificado por Finalización del Curso
  Como estudiante, quiero recibir un certificado de finalización al completar un curso, para validar mis logros educativos y tener un documento que demuestre mi competencia en el tema.

  Scenario: Recibir certificado de finalización con calificación satisfactoria
    Given que soy un estudiante que ha completado un curso con éxito
    When finalicé el curso y obtuve una calificación satisfactoria
    Then recibo un certificado de finalización del curso en formato digital que puedo descargar e imprimir

  Scenario: No cumplir con los requisitos para recibir un certificado
    Given que soy un estudiante que ha completado un curso con éxito
    When finalicé el curso pero no cumplo con los requisitos para obtener un certificado
    Then no recibo un certificado y se me informa que no cumplí con los criterios para recibirlo

  Scenario: Recibir certificado especial por rendimiento excepcional
    Given que soy un estudiante que ha completado un curso con éxito
    When finalizo el curso y obtengo una calificación sobresaliente
    Then recibo un certificado especial por un rendimiento excepcional que se muestra en mi perfil
