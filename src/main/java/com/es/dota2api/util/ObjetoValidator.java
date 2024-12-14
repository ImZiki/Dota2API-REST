package com.es.dota2api.util;

import com.es.dota2api.error.exception.InsufficientDataException;
import com.es.dota2api.error.exception.InvalidObjectDataException;
import com.es.dota2api.model.Objeto;
import org.springframework.stereotype.Component;

@Component
public class ObjetoValidator {

    // Validación para el campo "nombre"
    public void validateNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new InsufficientDataException("El nombre no puede ser nulo o vacío.");
        }
    }

    // Validación para el campo "danioFisico"
    public void validateDanioFisico(Long danioFisico) {
        if (danioFisico != null && danioFisico < 0) {
            throw new InvalidObjectDataException("El daño físico no puede ser negativo.");
        }
    }

    // Validación para el campo "danioMagico"
    public void validateDanioMagico(Long danioMagico) {
        if (danioMagico != null && danioMagico < 0) {
            throw new InvalidObjectDataException("El daño mágico no puede ser negativo.");
        }
    }

    // Validación para el campo "vida"
    public void validateVida(Long vida) {
        if (vida != null && vida < 0) {
            throw new InvalidObjectDataException("La vida adicional no puede ser negativa.");
        }
    }

    // Validación para el campo "mana"
    public void validateMana(Long mana) {
        if (mana != null && mana < 0) {
            throw new InvalidObjectDataException("El mana adicional no puede ser negativo.");
        }
    }

    // Validación para el campo "regenMana"
    public void validateRegenMana(Float regenMana) {
        if (regenMana != null && regenMana < 0) {
            throw new InvalidObjectDataException("La regeneración de mana no puede ser negativa.");
        }
    }

    // Validación para el campo "regenVida"
    public void validateRegenVida(Float regenVida) {
        if (regenVida != null && regenVida < 0) {
            throw new InvalidObjectDataException("La regeneración de vida no puede ser negativa.");
        }
    }

    // Validación para el campo "descripcion"
    public void validateDescripcion(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new InsufficientDataException("La descripción no puede ser nula o vacía.");
        }
        if (descripcion.length() > 65535) {
            throw new InvalidObjectDataException("La historia excede el límite de longitud.");
        }
    }

    // Método principal que puede ser usado para validar todo el objeto
    public void validateObjeto(Objeto objeto) {
        validateNombre(objeto.getNombre());
        validateDanioFisico(objeto.getDanioFisico());
        validateDanioMagico(objeto.getDanioMagico());
        validateVida(objeto.getVida());
        validateMana(objeto.getMana());
        validateRegenMana(objeto.getRegenMana());
        validateRegenVida(objeto.getRegenVida());
        validateDescripcion(objeto.getDescripcion());
    }
}

