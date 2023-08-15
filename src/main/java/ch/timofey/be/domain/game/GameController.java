package ch.timofey.be.domain.game;

import ch.timofey.be.exception.GameNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Log4j2
@RestController
@RequestMapping("/api/v1/games")
public class GameController {
    private final GameService gameService;
    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Game>> getAllGames(){
        return ResponseEntity.ok().body(gameService.getAllGames());
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Game> getGame(@PathVariable("id") Integer id) throws GameNotFoundException {
        return ResponseEntity.ok().body(gameService.getGameById(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createGame(@Valid @RequestBody Game game) {
        gameService.addGame(game);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void updateGame(@Valid @PathVariable("id") Integer id, @RequestBody Game game) throws GameNotFoundException {
        gameService.updateGame(id, game);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteGame(@Valid @PathVariable("id") Integer id){
        gameService.deleteGame(id);
    }

    @ExceptionHandler(GameNotFoundException.class)
    public ResponseEntity<String> handleNoSuchElementException(GameNotFoundException dnfe) {
        log.error("The given Game was not found in the database");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dnfe.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException manve) {
        log.error("The given values of the Model has failed the requirements");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Objects.requireNonNull(manve.getFieldError()).getDefaultMessage());
    }
}
