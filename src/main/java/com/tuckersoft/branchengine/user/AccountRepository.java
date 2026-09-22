package com.tuckersoft.branchengine.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository {

    Account findByEmail(String username);
}
