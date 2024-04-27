package com.zmeev.redisproject;

import com.zmeev.redisproject.model.Aircraft;
import com.zmeev.redisproject.repository.AircraftRepository;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@EnableScheduling
@Component
public class PlaneFinderPoller {

    private WebClient webClient = WebClient.create("http://localhost:7634/aircraft");

    private final RedisConnectionFactory redisConnectionFactory;
    private final AircraftRepository aircraftRepository;

    public PlaneFinderPoller(RedisConnectionFactory redisConnectionFactory,
                             AircraftRepository aircraftRepository) {
        this.redisConnectionFactory = redisConnectionFactory;
        this.aircraftRepository = aircraftRepository;
    }

    @Scheduled(fixedRate = 1000)
    private void pollPlanes() {
        redisConnectionFactory.getConnection().serverCommands().flushDb();

        webClient.get()
                .retrieve()
                .bodyToFlux(Aircraft.class)
                .filter(plane -> !plane.getReg().isEmpty())
                .toStream()
                .forEach(aircraftRepository::save);

        aircraftRepository.findAll().forEach(System.out::println);
    }
}
