package com.canteen.canteen_mgmt_system.repo;

import com.canteen.canteen_mgmt_system.entity.EmailCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailCredRepo extends JpaRepository<EmailCredentials,Long> {

    @Query(value = "select * from emailcredentials where active='true' ORDER BY date desc limit 1",
            nativeQuery = true)
    EmailCredentials findOneByActive();

}

