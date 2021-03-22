package dev.carrico.CardsSpringBackEnd.ServiceTests;

import dev.carrico.entities.StackLink;
import dev.carrico.repos.StackLinkRepo;
import dev.carrico.services.StackLinkServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StackLinkServiceTests {

    @InjectMocks
    private StackLinkServiceImpl stackLinkService;

    @Mock
    private StackLinkRepo stackLinkRepo;

    @Test
    void create_stacklink(){
        Mockito.when(stackLinkRepo.save(any())).then(returnsFirstArg());

        StackLink stackLink = new StackLink();
        stackLink.setStackLinkId(9);
        stackLink.setRelationship("Creator");
        stackLink.setLearnerId(1);
        stackLink.setStackId(1);
        stackLink = this.stackLinkService.createStackLink(stackLink);

        Assertions.assertEquals(0, stackLink.getStackLinkId());
    }
}
