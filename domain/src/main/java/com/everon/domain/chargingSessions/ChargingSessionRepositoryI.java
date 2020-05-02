package com.everon.domain.chargingSessions;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChargingSessionRepositoryI {

    Optional<ChargingSession> findChargingSessionById(final UUID id);

    ChargingSession save(final ChargingSession chargingSession);

    List<ChargingSession> findAll();

    ChargingSession update(final ChargingSession chargingSession);

}

