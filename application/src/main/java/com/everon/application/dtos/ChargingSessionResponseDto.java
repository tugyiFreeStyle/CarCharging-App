package com.everon.application.dtos;

import com.everon.domain.chargingSessions.ChargingSession;
import lombok.Value;

@Value
public class ChargingSessionResponseDto {

    private String id;
    private String stationId;
    private String startedAt;
    private String stoppedAt;
    private String status;

    public static ChargingSessionResponseDto convertFrom (final ChargingSession chargingSession){
        return new ChargingSessionResponseDto(chargingSession.getId().toString(),
                                              chargingSession.getStationId(),
                                              chargingSession.getStartedAt().toString(),
                                              chargingSession.getStoppedAt().toString(),
                                              chargingSession.getStatus().toString());


    }
}
