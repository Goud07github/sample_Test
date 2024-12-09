package in.prashuIT.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.prashuIT.Dto.TaxDetails;
import in.prashuIT.Entity.Employee;
import in.prashuIT.repo.EmpolyeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmpolyeeRepo repository;

	public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public TaxDetails calculateTax(String employeeId) {
        Employee employee = repository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        double yearlySalary = calculateYearlySalary(employee.getDoj(), employee.getSalary());
        double taxAmount = calculateTaxAmount(yearlySalary);
        double cessAmount = calculateCessAmount(yearlySalary);

        return new TaxDetails();
    }

	public double calculateYearlySalary(LocalDate doj, double monthlySalary) {
        LocalDate startDate = LocalDate.of(LocalDate.now().getYear(), 4, 1);
        LocalDate endDate = LocalDate.of(LocalDate.now().getYear() + 1, 3, 31);

        if (doj.isAfter(startDate)) {
            long monthsWorked = ChronoUnit.MONTHS.between(doj.withDayOfMonth(1), endDate.withDayOfMonth(1));
            return monthsWorked * monthlySalary;
        } else {
            return 12 * monthlySalary;
        }
    }

    public double calculateTaxAmount(double yearlySalary) {
        double tax = 0;
        if (yearlySalary > 250000) {
            tax += Math.min(250000, yearlySalary - 250000) * 0.05;
        }
        if (yearlySalary > 500000) {
            tax += Math.min(500000, yearlySalary - 500000) * 0.10;
        }
        if (yearlySalary > 1000000) {
            tax += (yearlySalary - 1000000) * 0.20;
        }
		return tax;
        
    }
    
    private double calculateCessAmount(double yearlySalary) {
        return yearlySalary > 2500000 ? (yearlySalary - 2500000) * 0.02 : 0;
    }
}
