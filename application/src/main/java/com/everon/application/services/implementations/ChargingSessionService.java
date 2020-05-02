package com.everon.application.services.implementations;


import com.everon.application.dtos.ChargingSessionCreateResponseDto;
import com.everon.application.dtos.ChargingSessionResponseDto;
import com.everon.application.dtos.ChargingSessionSummaryResponseDto;
import com.everon.application.services.ApplicationServiceBase;
import com.everon.application.services.IChargingSessionService;
import com.everon.domain.chargingSessions.ChargingSession;
import com.everon.domain.chargingSessions.ChargingSessionRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service("chargingSessionService")
public class ChargingSessionService extends ApplicationServiceBase<ChargingSessionResponseDto>
        implements IChargingSessionService {

    private final ChargingSessionRepositoryI repository;

    @Autowired
    public ChargingSessionService(ChargingSessionRepositoryI chargingSessionRepository) {
        super(chargingSessionRepository);
        this.repository = chargingSessionRepository;
    }

    @Override
    public ChargingSessionCreateResponseDto createChargingSession(String stationId) {

        Objects.requireNonNull(stationId);
        ChargingSession chargingSession = repository.save(ChargingSession.Create(stationId));
        return ChargingSessionCreateResponseDto.convertFrom(chargingSession);
    }

    @Override
    public ChargingSessionResponseDto stopChargingSession(String id) {
        return Update(id, chargingSession -> chargingSession.stop(),
                chargingSession -> ChargingSessionResponseDto.convertFrom(chargingSession));

    }

    @Override
    public List<ChargingSessionResponseDto> getChargingSessions() {
        return repository.findAll().
                stream().
                map(ChargingSessionResponseDto::convertFrom).
                collect(Collectors.toList());
    }

    @Override
    public ChargingSessionSummaryResponseDto getSummary() {
        return null;
    }
//    public ChargingSessionSummaryResponseDto getChargingSummary() {
//        ChargingSessionSummaryResponseDto summary = new ChargingSessionSummaryResponseDto();
//        var exısıntgSessıons = repository.findAll();
//        exısıntgSessıons.stream().filter((startTime) -> startTime > 1)
//        summary.setTotalCount(exısıntgSessıons.count);
//        return summary;
//    }
}