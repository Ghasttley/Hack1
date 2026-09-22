package com.tuckersoft.branchengine.Playthrough;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.Instant;
import java.util.List;

public class PlaythroughDTO {

    private PlaythroughDTO() {}

    public record CreateRequest(
            @NotBlank(message = "playerTag es obligatorio")
            @Size(min = 2, max = 40, message = "playerTag debe tener entre 2 y 40 caracteres")
            String playerTag,

            @NotBlank(message = "startNodeCode es obligatorio")
            String startNodeCode
    ) {}

    public record Response(
            Long id,
            String playerTag,
            String ownerEmail,
            String startNodeCode,
            String currentNodeCode,
            Integer lucidity,
            Integer controlLevel,
            String status,
            String endingCode,
            Instant createdAt,
            Instant updatedAt
    ) {}

    public record PathStep(
            int order,
            Long decisionId,
            String fromNodeCode,
            String toNodeCode,
            String branchType,
            String impactLevel,
            Instant createdAt
    ) {}

    public record PathResponse(
            Long playthroughId,
            String playerTag,
            String status,
            String endingCode,
            String startNodeCode,
            String currentNodeCode,
            List<PathStep> steps
    ) {}
}