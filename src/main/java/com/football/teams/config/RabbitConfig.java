package com.football.teams.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String EXCHANGE_NAME        = "football.exchange";
    public static final String QUEUE_PLAYER_CREATED = "player.created.queue";
    public static final String ROUTING_KEY_CREATED  = "player.created";

    @Bean
    public Exchange footballExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME)
                              .durable(true)
                              .build();
    }

    @Bean
    public Queue playerCreatedQueue() {
        return QueueBuilder.durable(QUEUE_PLAYER_CREATED).build();
    }

    @Bean
    public Binding bindingPlayerCreated(Queue playerCreatedQueue, Exchange footballExchange) {
        return BindingBuilder.bind(playerCreatedQueue)
                             .to(footballExchange)
                             .with(ROUTING_KEY_CREATED)
                             .noargs();
    }
}