package com.everon.infrastructure.repositories;


import com.everon.domain.chargingSessions.ChargingSession;
import com.everon.domain.chargingSessions.ChargingSessionRepositoryI;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ChargingSessionInMemoryRepository implements ChargingSessionRepositoryI {

    private final Map<UUID, ChargingSession> memory;

    public ChargingSessionInMemoryRepository() { memory = new ConcurrentHashMap<>(); }

    @Override
    public Optional<ChargingSession> findChargingSessionById(UUID id) {
        Objects.requireNonNull(id);
        return Optional.ofNullable(memory.get(id));
    }

    @Override
    public ChargingSession save(ChargingSession chargingSession) {
        Objects.requireNonNull(chargingSession, "Charging session must not be null");
        return memory.put(chargingSession.getId(), chargingSession);
    }

    @Override
    public List<ChargingSession> findAll() {
        return new ArrayList<>(memory.values());
    }

    @Override
    public ChargingSession update(ChargingSession chargingSession) {
        return memory.put(chargingSession.getId(), chargingSession);
    }

}
