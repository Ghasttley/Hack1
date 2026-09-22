package com.tuckersoft.branchengine.Playthrough;

import com.tuckersoft.branchengine.StoryNode.StoryNode;
import com.tuckersoft.branchengine.User.User;
import com.tuckersoft.branchengine.user.Account;
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Account user;

    @Column(nullable = false, updatable = false, length = 40)
    private String startNodeCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "current_node_id", nullable = false)
    private StoryNode currentNode;

    @Column(nullable = false)
    private Integer lucidity = 100;

    @Column(nullable = false)
    private Integer controlLevel = 0;

    @Column(nullable = false, length = 20)
    private String status = "ACTIVA";

    @Column(length = 40)
    private String endingCode;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;
}