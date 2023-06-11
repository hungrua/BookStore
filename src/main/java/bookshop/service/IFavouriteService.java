package bookshop.service;

import java.util.List;

import bookshop.DTO.Favourite;

public interface IFavouriteService {
	List<Favourite> getFavouriteByUser(Long id);
	String addFavourite(Favourite dto);
	void deleteFavourite (Long id);
}
