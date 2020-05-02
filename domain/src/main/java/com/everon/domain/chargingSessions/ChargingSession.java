package com.everon.domain.chargingSessions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ChargingSession {

    private UUID id;
    private String stationId;
    private LocalDateTime startedAt = LocalDateTime.now();
    private LocalDateTime stoppedAt;
    private StatusEnum status;

    private ChargingSession(String stationId) {
        this.id = UUID.randomUUID();
        this.stationId = stationId;
        this.status = StatusEnum.IN_PROGRESS;
    }

    public static ChargingSession Create(String stationId)
    {
        return  new ChargingSession(stationId);
    }

    public void stop() {
        this.status = StatusEnum.FINISHED;
        this.stoppedAt = LocalDateTime.now();
    }
}

