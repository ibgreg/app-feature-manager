package com.ibgreg.appfeaturetoggle.resources;

import com.ibgreg.appfeaturetoggle.entities.FeatureToggle;
import com.ibgreg.appfeaturetoggle.services.FeatureToggleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/features")
public class FeatureToggleResource {

    @Autowired
    private FeatureToggleService service;

    @GetMapping
    public ResponseEntity<List<FeatureToggle>> listAllFeatureToggles() {
        List<FeatureToggle> featureTogglesList = service.findAllFeatureToggles();

        return ResponseEntity.ok(featureTogglesList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FeatureToggle> findFeatureToggleById(@PathVariable Long id) {

        FeatureToggle worker = service.findFeatureToggleById(id);

        return ResponseEntity.ok(worker);
    }

    @PostMapping
    public ResponseEntity<Void> createFeatureToggle(@RequestBody FeatureToggle featureToggle) {
        service.createNewFeatureToggle(featureToggle);

        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateMaintenance(@RequestBody FeatureToggle updatedFeatureToggle, @PathVariable Long id) {
        updatedFeatureToggle.setId(id);
        service.updateFeatureToggle(updatedFeatureToggle);

        return ResponseEntity.ok().build();
    }
}
