package com.everon.application.services;

import com.everon.application.exceptions.ResourceNotFoundException;
import com.everon.domain.chargingSessions.ChargingSession;
import com.everon.domain.chargingSessions.ChargingSessionRepositoryI;
import com.everon.domain.chargingSessions.StatusEnum;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class ApplicationServiceBase<TUpdateDto> {

    private final ChargingSessionRepositoryI repository;

    public ApplicationServiceBase(ChargingSessionRepositoryI repository) {
        this.repository = repository;
    }

    public TUpdateDto Update(String id, Consumer<ChargingSession> updates, Function<ChargingSession, TUpdateDto> map) {
        Objects.requireNonNull(id);
        UUID uuid = UUID.fromString(id);
        ChargingSession chargingSession = repository.findChargingSessionById(uuid).
                filter(s -> s.getStatus().equals(StatusEnum.IN_PROGRESS)).
                orElseThrow(() -> new ResourceNotFoundException("No active charging session found with id" + uuid));
        updates.accept(chargingSession);
        repository.update(chargingSession);
        return map.apply(chargingSession);
    }

}