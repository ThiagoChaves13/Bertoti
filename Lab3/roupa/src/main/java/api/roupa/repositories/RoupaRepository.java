package api.roupa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import api.roupa.models.Roupa;

import java.util.UUID;

@Repository
public interface RoupaRepository extends JpaRepository<Roupa, UUID> {
}
