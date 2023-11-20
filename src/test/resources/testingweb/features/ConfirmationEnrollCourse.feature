Feature: Recibir Confirmación de Inscripción al Curso
  Como usuario con monedas Goldies, quiero recibir una confirmación inmediata después de inscribirme en un curso premium con mis monedas Goldies, para tener la certeza de que mi inscripción se ha procesado correctamente.

  Scenario: Confirmación exitosa de inscripción al curso
    Given que soy un usuario con monedas Goldies disponibles
    And he elegido un curso premium y seleccionado la opción de "Inscripción con Monedas Goldies"
    And tengo suficientes monedas Goldies para la inscripción
    When confirmo la inscripción
    Then se me muestra una confirmación inmediata de inscripción al curso
    And el curso aparece en mi lista de cursos inscritos

  Scenario: Demora en la confirmación de inscripción al curso debido a error técnico
    Given que soy un usuario con monedas Goldies disponibles
    And he elegido un curso premium y seleccionado la opción de "Inscripción con Monedas Goldies"
    And tengo suficientes monedas Goldies para la inscripción
    And debido a un error técnico, no se puede confirmar mi inscripción de inmediato
    Then se muestra un mensaje de error indicando la demora

  Scenario: Insuficientes monedas Goldies para la inscripción
    Given que soy un usuario con monedas Goldies disponibles
    And he elegido un curso premium y seleccionado la opción de "Inscripción con Monedas Goldies"
    And no tengo suficientes monedas Goldies para la inscripción
    Then se muestra un mensaje de error indicando que no tengo suficientes monedas
