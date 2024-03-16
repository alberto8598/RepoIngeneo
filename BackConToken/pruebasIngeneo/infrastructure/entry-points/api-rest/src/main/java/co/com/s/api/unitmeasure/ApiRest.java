package co.com.s.api.unitmeasure;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.com.s.model.unitmeasure.Logistica;
import co.com.s.usecase.unitmeasure.UseCase;
import lombok.RequiredArgsConstructor;
import static co.com.s.api.constant.Constant.URL_BASE;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = URL_BASE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ApiRest {
    private final UseCase logisticaUseCase;

    @GetMapping
    @ApiOperation(value = "List all logistics", notes = "This method retrieves a list of all logistics.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Logistica.class, responseContainer = "List"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 422, message = "Unprocessable Entity"),
            @ApiResponse(code = 401, message = "Bad Request"),
            @ApiResponse(code = 400, message = "the server is unable to process or recognize the request")

    })
    public List<Logistica> listar() {
        return logisticaUseCase.findAll();
    }

    @GetMapping(path = { "/{id}" })
    @ApiOperation(value = "List filter logistics", notes = "This method retrieves a list by Id logistics.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Logistica.class, responseContainer = "List"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 422, message = "Unprocessable Entity"),
            @ApiResponse(code = 401, message = "Bad Request"),
            @ApiResponse(code = 400, message = "the server is unable to process or recognize the request")

    })
    public Logistica listarId(@PathVariable("id") String id) {
        return logisticaUseCase.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "add logistics", notes = "This method add.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Logistica.class, responseContainer = "List"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 422, message = "Unprocessable Entity"),
            @ApiResponse(code = 401, message = "Bad Request"),
            @ApiResponse(code = 400, message = "the server is unable to process or recognize the request")

    })
    public Logistica add(@RequestBody Logistica p) {
        return logisticaUseCase.save(p);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "update logistics", notes = "This method update.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Logistica.class, responseContainer = "List"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 422, message = "Unprocessable Entity"),
            @ApiResponse(code = 401, message = "Bad Request"),
            @ApiResponse(code = 400, message = "the server is unable to process or recognize the request")

    })
    public Logistica edit(@RequestBody Logistica p, @PathVariable("id") String id) {
        //p.builder().id(id).build();
        p.setId(id);
        return logisticaUseCase.save(p);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete logistics", notes = "This method delete.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Logistica.class, responseContainer = "List"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 422, message = "Unprocessable Entity"),
            @ApiResponse(code = 401, message = "Bad Request"),
            @ApiResponse(code = 400, message = "the server is unable to process or recognize the request")

    })
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        logisticaUseCase.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();
    }

}
