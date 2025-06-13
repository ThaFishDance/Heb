package com.tcb.heb.api.repository;

import com.tcb.heb.entities.User;
import com.tcb.heb.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@TestPropertySource(properties = "spring.flyway.enabled=false")
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void UserRepository_Save_ReturnSavedUser() {
        // Arrange
        User user = User
            .builder()
            .name("test")
            .email("test")
            .password("test")
            .build();

        // Act
        User savedUser = userRepository.save(user);

        // Assert
        System.out.println("Testing");
        Assertions.assertNotNull(savedUser);
        Assertions.assertEquals(user.getName(), savedUser.getName());
        System.out.println("Test complete");
    }
}
