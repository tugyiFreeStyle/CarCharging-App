package com.everon.application.services;

import com.everon.application.dtos.ChargingSessionCreateResponseDto;
import com.everon.application.dtos.ChargingSessionResponseDto;
import com.everon.application.dtos.ChargingSessionSummaryResponseDto;
import com.everon.domain.chargingSessions.ChargingSession;

import java.util.List;


public interface IChargingSessionService {

    ChargingSessionCreateResponseDto createChargingSession(String stationId);

    ChargingSessionResponseDto stopChargingSession(String id);

    List<ChargingSessionResponseDto> getChargingSessions();

    ChargingSessionSummaryResponseDto getSummary();

}

