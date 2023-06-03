package bookshop.converter;

import org.springframework.stereotype.Component;

import bookshop.DTO.Bill;
import bookshop.entity.BillEntity;

@Component
public class BillConverter {
	public BillEntity toEntity(Bill dto) {
		BillEntity entity = new BillEntity();
		entity.setReceiver(dto.getReceiver());
		entity.setContact(dto.getContact());
		entity.setAddress(dto.getAddress());
		entity.setNotes(dto.getNotes());
		return entity;
	}
	public Bill toDTO(BillEntity entity) {
		Bill dto = new Bill();
		dto.setId(entity.getId());
		dto.setReceiver(entity.getReceiver());
		dto.setAddress(entity.getAddress());
		dto.setContact(entity.getContact());
		dto.setNotes(entity.getNotes());
		dto.setTotal(entity.getTotal());
		dto.setCart_id(entity.getCart().getId());
		dto.setOrderDate(entity.getOrderDate());
		return dto;
	}
}
