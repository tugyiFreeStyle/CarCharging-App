package com.everon.application.dtos;

import lombok.Value;

@Value
public class ChargingSessionSummaryResponseDto {

    private long totalCount;
    private long startedCount;
    private long stoppedCount;

}
