package ch.timofey.be.domain.game;

import ch.timofey.be.exception.GameNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {
        log.info("Game Items have been tried to be accessed");
        return Optional.of(gameRepository.findAll()).orElseThrow(() -> new GameNotFoundException("No Games have been found"));
    }

    public Game getGameById(Integer id) {
        log.info("Game Item have been tried to be accessed");
        return gameRepository.findById(id).orElseThrow(() -> new GameNotFoundException("Game with the given Id not found"));
    }

    public void addGame(Game game) {
        gameRepository.save(game);
        log.info("game has been added to the Database");
    }

    public void updateGame(Integer id, Game game) throws GameNotFoundException{
        if (gameRepository.findById(id).isPresent()){
            game.setId(id);
        } else {
            throw new GameNotFoundException("The given game id was not found in the Database");
        }
        gameRepository.save(game);
        log.info("Game has been updated");
    }

    public void deleteGame(Integer id){
        if (gameRepository.findById(id).isPresent()){
            gameRepository.deleteById(id);
        } else {
            throw new GameNotFoundException("The given Game id was not found in the Database");
        }
        log.info("Game has been deleted in the Database");
    }
}
