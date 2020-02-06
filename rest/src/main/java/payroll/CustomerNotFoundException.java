package payroll;

class CustomerNotFoundException extends RuntimeException {

	CustomerNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}
