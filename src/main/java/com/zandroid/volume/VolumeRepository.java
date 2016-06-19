package com.zandroid.volume;

import com.zandroid.volume.Volume;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(collectionResourceRel = "volume", path = "volume")
public interface VolumeRepository extends CrudRepository<Volume, Long> {

}