package se.ifmo.pepe.lab1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.ifmo.pepe.lab1.model.Skin;

import java.util.List;

@Repository
public interface SkinRepository extends CrudRepository<Skin, Long>, JpaRepository<Skin, Long> {
    List<Skin> findAllByApproved(Boolean areApproved);
    List<Skin> findAllByTag(String tag);
    List<Skin> findAllBySex(String sex);
}
