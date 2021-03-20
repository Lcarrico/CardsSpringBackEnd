package dev.carrico.services;

import dev.carrico.entities.StackLink;
import dev.carrico.repos.StackLinkRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class StackLinkServiceImpl implements StackLinkService{
    @Autowired
    StackLinkRepo stackLinkRepo;

    @Override
    public StackLink createStackLink(StackLink stackLink) {
        stackLinkRepo.save(stackLink);
        return stackLink;
    }

    @Override
    public StackLink getStackLinkById(int stackLinkId) {
        StackLink stackLink = this.stackLinkRepo.findById(stackLinkId).get();
        return stackLink;
    }

    @Override
    public Set<StackLink> getStackLinksByLearnerId(int learnerId) {
        Set<StackLink> stackLinks = this.stackLinkRepo.findByLearnerId(learnerId);
        return stackLinks;
    }

    @Override
    public Set<StackLink> getStackLinksByRelationship(String relationship) {
        Set<StackLink> stackLinks = this.stackLinkRepo.findByRelationship(relationship);
        return stackLinks;
    }

    @Override
    public Set<StackLink> getAllStackLinks() {
        Set<StackLink> stackLinks = new HashSet<>();
        this.stackLinkRepo.findAll().forEach(stackLinks::add);
        return stackLinks;
    }

    @Override
    public StackLink updateStackLink(StackLink stackLink) {
        this.stackLinkRepo.save(stackLink);
        return stackLink;
    }

    @Override
    public boolean deleteStackLinkById(int stackLinkId) {
        this.stackLinkRepo.deleteById(stackLinkId);
        return true;
    }
}
