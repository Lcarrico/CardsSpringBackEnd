package dev.carrico.ServiceTests;

import dev.carrico.services.CardServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class CardServiceTests {

    @Autowired
    CardServiceImpl csi;

    @Test
    void create_card(){

    }

    @Test
    void get_card_by_id(){

    }

    
}
