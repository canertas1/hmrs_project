package kodlama.io.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hmrs.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job,Integer> {

}
