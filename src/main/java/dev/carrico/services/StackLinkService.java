package dev.carrico.services;

import dev.carrico.entities.Learner;
import dev.carrico.entities.Stack;
import dev.carrico.entities.StackLink;

import java.util.Set;

public interface StackLinkService {

    StackLink createStackLink(StackLink stackLink);

    StackLink getStackLinkById(int stackLinkId);
    Set<StackLink> getAllStackLinks();

    StackLink updateStackLink(StackLink stackLink);

    boolean deleteStackLinkById(int stackLinkId);

}
