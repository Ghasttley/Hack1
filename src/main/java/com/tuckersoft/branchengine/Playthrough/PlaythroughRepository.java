package com.tuckersoft.branchengine.Playthrough;

import com.tuckersoft.branchengine.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlaythroughRepository extends JpaRepository<Playthrough, Long> {
    Optional<Playthrough> findByPlayerTag(String playerTag);
    boolean existsByPlayerTag(String playerTag);
    List<Playthrough> findByUserOrderByCreatedAtDesc(User user);
    List<Playthrough> findAllByOrderByCreatedAtDesc();
}