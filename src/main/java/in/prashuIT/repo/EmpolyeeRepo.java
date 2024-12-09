package in.prashuIT.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.prashuIT.Entity.Employee;

public interface EmpolyeeRepo extends JpaRepository<Employee, String>{

	Optional<Employee> findById(String employeeId);

}
