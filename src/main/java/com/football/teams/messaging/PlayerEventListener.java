package com.football.teams.messaging;

import com.football.teams.config.RabbitConfig;
import com.football.teams.dto.PlayerDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PlayerEventListener {

    @RabbitListener(queues = RabbitConfig.QUEUE_PLAYER_CREATED)
    public void onPlayerCreated(PlayerDto dto) {
        // Aquí tu lógica de Teams al recibir el evento de un jugador creado
        System.out.println("Evento recibido en Teams: " + dto);
        // Por ejemplo, podrías crear un TeamDto o asociar al Team alguna lógica...
    }
}