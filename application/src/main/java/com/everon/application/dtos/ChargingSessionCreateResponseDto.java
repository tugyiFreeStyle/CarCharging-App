package com.everon.application.dtos;

import com.everon.domain.chargingSessions.ChargingSession;
import lombok.Value;

@Value
public class ChargingSessionCreateResponseDto {

    private String id;
    private String stationId;
    private String startedAt;
    private String status;

    public static ChargingSessionCreateResponseDto convertFrom (final ChargingSession chargingSession) {
        return new ChargingSessionCreateResponseDto(chargingSession.getId().toString(),
                                                    chargingSession.getStationId(),
                                                    chargingSession.getStartedAt().toString(),
                                                    chargingSession.getStatus().toString());
    }
}
