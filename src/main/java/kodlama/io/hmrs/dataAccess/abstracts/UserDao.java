package kodlama.io.hmrs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlama.io.hmrs.entities.concretes.Candidate;

public interface UserDao extends JpaRepository<Candidate, Integer> {
	// UserDao findByNationalityId(String nationalityId);
	// UserDao findByEmail(String email);
	

}
