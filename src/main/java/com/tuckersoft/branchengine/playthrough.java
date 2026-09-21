package com.tuckersoft.branchengine.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "playthroughs")
@Getter
@Setter
@NoArgsConstructor
public class Playthrough {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 40)
    private String playerTag;

    // El dueño sale del token, nunca del request body.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // No cambia nunca despues de creada la partida.
    @Column(nullable = false, updatable = false, length = 40)
    private String startNodeCode;

    // Se actualiza en cada decision que mueve la historia.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "current_node_id", nullable = false)
    private StoryNode currentNode;

    // Rango 0-100. Inicia en 100.
    @Column(nullable = false)
    private Integer lucidity = 100;

    // Rango 0-100. Inicia en 0.
    @Column(nullable = false)
    private Integer controlLevel = 0;

    // "ACTIVA" o "FINALIZADA".
    @Column(nullable = false, length = 20)
    private String status = "ACTIVA";

    // Nullable. Solo se asigna cuando status = FINALIZADA.
    @Column(length = 40)
    private String endingCode;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;
}
