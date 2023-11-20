Feature: Usar monedas Silvies para comprar cursos
  Como alumno, quiero poder usar mis monedas Silvies para comprar cursos en la plataforma, de modo que pueda expandir mi conocimiento y experiencia en diferentes áreas temáticas, utilizando las monedas que he ganado previamente.

  Scenario: Comprar curso con suficientes monedas Silvies
    Given que soy un alumno autenticado en la plataforma
    And tengo suficientes monedas Silvies en mi saldo para pagar el curso
    When deseo comprar un curso utilizando mis monedas Silvies acumuladas
    And selecciono un curso disponible para su compra
    Then el curso se compra con éxito
    And se descuentan las monedas Silvies necesarias de mi saldo

  Scenario: Error al comprar curso por fondos insuficientes
    Given que soy un alumno autenticado en la plataforma
    And no tengo suficientes monedas Silvies en mi saldo para pagar el curso
    When intento comprar un curso utilizando mis monedas Silvies
    And selecciono un curso disponible para su compra
    Then se me muestra un mensaje de error indicando que la compra del curso ha fallado debido a fondos insuficientes
    And se me indica que obtenga más monedas Silvies antes de intentar la compra

  Scenario: Cancelar la compra de un curso
    Given que soy un alumno autenticado en la plataforma
    And tengo suficientes monedas Silvies en mi saldo para pagar el curso
    When decido cancelar la compra de un curso en cualquier punto del proceso
    And no finalizo la transacción de compra
    Then se cancela la acción de compra del curso
    And las monedas Silvies en mi saldo permanecen sin cambios
