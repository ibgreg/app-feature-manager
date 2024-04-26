package com.ibgreg.appfeaturetoggle.repositories;

import com.ibgreg.appfeaturetoggle.entities.FeatureToggle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureToggleRepository  extends JpaRepository<FeatureToggle, Long> {
}
