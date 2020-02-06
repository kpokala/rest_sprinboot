package payroll;


import java.util.List;
import java.util.stream.Collectors;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CustomerController {

	private final CustomerRepository repository;

	CustomerController(CustomerRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

	// tag::get-aggregate-root[]
	@GetMapping("/Customers")
	Resources<Resource<Customer>> all() {

		List<Resource<Customer>> Customers = repository.findAll().stream()
			.map(Customer -> new Resource<>(Customer,
				linkTo(methodOn(CustomerController.class).one(Customer.getId())).withSelfRel(),
				linkTo(methodOn(CustomerController.class).all()).withRel("Customers")))
			.collect(Collectors.toList());
		
		return new Resources<>(Customers,
			linkTo(methodOn(CustomerController.class).all()).withSelfRel());
	}
	// end::get-aggregate-root[]

	@PostMapping("/Customers")
	Customer newCustomer(@RequestBody Customer newCustomer) {
		return repository.save(newCustomer);
	}


	@GetMapping("/Customers/{id}")
	Resource<Customer> one(@PathVariable Long id) {
		
		Customer Customer = repository.findById(id);
		
		return new Resource<>(Customer,
			linkTo(methodOn(CustomerController.class).one(id)).withSelfRel(),
			linkTo(methodOn(CustomerController.class).all()).withRel("Customers"));
	}


	@PutMapping("/Customers/{id}")
	Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
		
		return repository.findById(id);
	}

	@DeleteMapping("/Customers/{id}")
	void deleteCustomer(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
