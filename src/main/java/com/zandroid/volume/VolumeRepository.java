package com.zandroid.volume;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "volume", path = "volume")
public interface VolumeRepository extends CrudRepository<Volume, Integer> {

}