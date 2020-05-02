package com.everon.api.controllers;


import com.everon.application.dtos.ChargingSessionCreateRequestDto;
import com.everon.application.dtos.ChargingSessionCreateResponseDto;
import com.everon.application.dtos.ChargingSessionResponseDto;
import com.everon.application.dtos.ChargingSessionSummaryResponseDto;
import com.everon.application.exceptions.BaseException;
import com.everon.application.services.IChargingSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/chargingSessions")
public class ChargingSessionController {

    private final IChargingSessionService chargingSessionService;

    @Autowired
    public ChargingSessionController(IChargingSessionService chargingSessionService) {
        this.chargingSessionService = chargingSessionService;
    }

    @PostMapping
    public ResponseEntity<ChargingSessionCreateResponseDto> createChargingSession(@Valid @RequestBody ChargingSessionCreateRequestDto request) throws BaseException {

        return ResponseEntity.ok(chargingSessionService.createChargingSession(request.getStationId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChargingSessionResponseDto> stopChargingSession(@PathVariable("id") String id) throws BaseException {

        return ResponseEntity.ok(chargingSessionService.stopChargingSession(id));
    }

    @GetMapping
    public ResponseEntity<List<ChargingSessionResponseDto>> getChargingSessions() throws BaseException {

        return ResponseEntity.ok(chargingSessionService.getChargingSessions());
    }

    @GetMapping("/summary")
    public ResponseEntity<ChargingSessionSummaryResponseDto> getChargingSessionsSummary() throws BaseException {

        return ResponseEntity.ok(chargingSessionService.getSummary());
    }

}
