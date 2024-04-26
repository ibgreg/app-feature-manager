package com.ibgreg.appfeaturetoggle.services;

import com.ibgreg.appfeaturetoggle.entities.FeatureToggle;
import com.ibgreg.appfeaturetoggle.repositories.FeatureToggleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FeatureToggleService {

    @Autowired
    private FeatureToggleRepository repository;

    public FeatureToggle findFeatureToggleById(Long id) {

        Optional<FeatureToggle> featureToggle = repository.findById(id);
        // TODO send an exception message when there is no feature toggle found
        return featureToggle.orElse(null);
    }

    public List<FeatureToggle> findAllFeatureToggles() {
        return repository.findAll();
    }

    @Transactional
    public FeatureToggle createNewFeatureToggle(FeatureToggle featureToggle) {
        featureToggle = repository.save(featureToggle);

        return featureToggle;
    }

    @Transactional
    public FeatureToggle updateFeatureToggle(FeatureToggle featureToggle) {
        // TODO create validations to improve and restrict the update flow
        FeatureToggle selectedFeatureToggle = findFeatureToggleById(featureToggle.getId());

        return repository.save(featureToggle);
    }

    public void archiveFeature(Long id) {
        FeatureToggle selectedFeature = findFeatureToggleById(id);

        // Set active status to false and Expires On fields to archive the feature
        selectedFeature.setActive(false);
        selectedFeature.setExpiresOn(LocalDateTime.now());

        repository.save(selectedFeature);
    }

}
