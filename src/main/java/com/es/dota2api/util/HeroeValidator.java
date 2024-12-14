package com.es.dota2api.util;

import com.es.dota2api.error.exception.InsufficientDataException;
import com.es.dota2api.error.exception.InvalidHeroDataException;
import com.es.dota2api.model.Heroe;

import org.springframework.stereotype.Component;

@Component
public class HeroeValidator {

    // Validación para el campo "nombre"
    public void validateNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new InsufficientDataException("El nombre no puede ser nulo o vacío.");
        }
    }

    // Validación para el campo "inteligencia"
    public void validateInteligencia(Long inteligencia) {
        if (inteligencia == null) {
            throw new InsufficientDataException("La inteligencia no puede ser nula.");
        }
        if (inteligencia < 0) {
            throw new InvalidHeroDataException("La inteligencia no puede ser negativa.");
        }
    }

    // Validación para el campo "fuerza"
    public void validateFuerza(Long fuerza) {
        if (fuerza == null) {
            throw new InsufficientDataException("La fuerza no puede ser nula.");
        }
        if (fuerza < 0) {
            throw new InvalidHeroDataException("La fuerza no puede ser negativa.");
        }
    }

    // Validación para el campo "agilidad"
    public void validateAgilidad(Long agilidad) {
        if (agilidad == null) {
            throw new InsufficientDataException("La agilidad no puede ser nula.");
        }
        if (agilidad < 0) {
            throw new InvalidHeroDataException("La agilidad no puede ser negativa.");
        }
    }

    // Validación para el campo "vida"
    public void validateVida(Long vida) {
        if (vida == null) {
            throw new InsufficientDataException("La vida no puede ser nula.");
        }
        if (vida <= 0) {
            throw new InvalidHeroDataException("La vida debe ser mayor que 0.");
        }
    }

    // Validación para el campo "mana"
    public void validateMana(Long mana) {
        if (mana != null && mana < 0) {
            throw new InvalidHeroDataException("El mana no puede ser negativo.");
        }
    }

    // Validación para el campo "historia"
    public void validateHistoria(String historia) {
        if (historia == null || historia.trim().isEmpty()) {
            throw new InsufficientDataException("La historia no puede ser nula o vacía.");
        }
        if (historia.length() > 65535) {
            throw new InvalidHeroDataException("La historia excede el límite de longitud.");
        }
    }

    // Método principal que puede ser usado para validar todo el héroe
    public void validateHeroe(Heroe heroe) {
        validateNombre(heroe.getNombre());
        validateInteligencia(heroe.getInteligencia());
        validateFuerza(heroe.getFuerza());
        validateAgilidad(heroe.getAgilidad());
        validateVida(heroe.getVida());
        validateMana(heroe.getMana());
        validateHistoria(heroe.getHistoria());
    }
}

