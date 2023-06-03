package bookshop.service;

import java.util.List;

import bookshop.DTO.Bill;

public interface IBillService {
	List<Bill> getBillByCart(Long id);
	Bill addNewBill(Bill bill);
	void deleteBill(Long id);
	Bill getPreviousBillInformation(Long id);
}
