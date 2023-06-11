package bookshop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookshop.DTO.Favourite;
import bookshop.converter.FavouriteConverter;
import bookshop.entity.FavouriteEntity;
import bookshop.entity.UserEntity;
import bookshop.repository.BookRepository;
import bookshop.repository.FavouriteRepository;
import bookshop.repository.UserRepository;
import bookshop.service.IFavouriteService;
@Service
public class FavouriteService implements IFavouriteService {
	
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	FavouriteRepository favouriteRepository;
	@Autowired
	FavouriteConverter favouriteConverter;
	@Override
	public List<Favourite> getFavouriteByUser(Long id) {
		UserEntity user = userRepository.findOne(id);
		List<FavouriteEntity> list  = user.getFavourites();
		List<Favourite> result = new ArrayList<>();
		for(FavouriteEntity x : list) {
			result.add(favouriteConverter.toDTO(x));
		}
		return result;
	}

	@Override
	public String addFavourite(Favourite dto) {
		FavouriteEntity checkEntity = favouriteRepository.findByUser_IdAndBook_Id(dto.getUser_id(), dto.getBook_id());
		if(checkEntity!=null){
			return "Cuốn sách đã có trong danh sách yêu thích";
		}
		else {
			FavouriteEntity newEntity = new FavouriteEntity();
			newEntity.setUser(userRepository.findOne(dto.getUser_id()));
			newEntity.setBook(bookRepository.findOne(dto.getBook_id()));
			favouriteRepository.save(newEntity);
			return "Đã thêm vào danh sách yêu thích";
		}
	}
	

	@Override
	public void deleteFavourite(Long id) {
		favouriteRepository.delete(id);
	}

}
