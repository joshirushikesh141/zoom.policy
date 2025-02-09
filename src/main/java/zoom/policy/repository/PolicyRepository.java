package zoom.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoom.policy.entity.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer>{

}
