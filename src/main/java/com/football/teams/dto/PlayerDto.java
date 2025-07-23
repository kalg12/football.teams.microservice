package com.football.teams.dto;

/**
 * DTO para recibir eventos de players-service.
 * Debe coincidir con el PlayerDto de players-service.
 */
public record PlayerDto(
    Long id,
    String name,
    String position
) { }