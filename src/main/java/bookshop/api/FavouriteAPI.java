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

import bookshop.DTO.Favourite;
import bookshop.service.IFavouriteService;

@RestController
@CrossOrigin(origins="*")
public class FavouriteAPI {
	
	@Autowired
	IFavouriteService favouriteService;
	@GetMapping("/favourite/{id}")
	List<Favourite> getFavouriteByUser(@PathVariable Long id){
		return favouriteService.getFavouriteByUser(id);
	}
	@PostMapping("/favourite/add")
	String addFavourite(@RequestBody Favourite dto) {
		return favouriteService.addFavourite(dto);
	}
	@DeleteMapping("/favourite/delete/{id}")
	void deleteFavourite(@PathVariable Long id) {
		favouriteService.deleteFavourite(id);
	}
}
