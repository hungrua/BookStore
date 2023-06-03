package bookshop.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bookshop.DTO.Bill;
import bookshop.service.IBillService;

@RestController
@CrossOrigin(origins ="*")
public class BillAPI {
	
	@Autowired
	IBillService billService;
	@GetMapping("/bill/{id}")
	List<Bill> getBillByCart(@PathVariable Long id) {
		return billService.getBillByCart(id) ;
	}
	@PostMapping("bill/add")
	Bill addNewBill(@RequestBody Bill bill) {
		return billService.addNewBill(bill);
	}
	
	@DeleteMapping("bill/delete/{id}")
	void deleteBill(@PathVariable Long id) {
		billService.deleteBill(id);
	}
	@GetMapping("/bill/previous/{id}")
	Bill getThePreviousBillInfo(@PathVariable Long id) {
		return billService.getPreviousBillInformation(id);
	}
	
}
