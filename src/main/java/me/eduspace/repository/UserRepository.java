package me.eduspace.repository;

import me.eduspace.entity.UserEntity;
import me.eduspace.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByPhone(String phone);

    @Transactional
    @Modifying
    @Query("update UserEntity u " +
            "set u.enabled = true, u.status = ?2 where u.phone=?1")
    void enableUser(String phone, UserStatus status);
}