package com.techelevator.dao;

import com.techelevator.model.FavoriteDTO;
import com.techelevator.model.PostDTO;

import java.security.Principal;
import java.util.List;

public interface FavoriteDAO {


    List<PostDTO> favoriteFeed(Principal principal);

    void addToFavs(FavoriteDTO favoriteDTO);
}
