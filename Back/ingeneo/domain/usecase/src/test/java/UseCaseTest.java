import co.com.s.model.unitmeasure.Logistica;
import co.com.s.model.unitmeasure.gateways.IComponent;
import co.com.s.usecase.unitmeasure.UseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class UseCaseTest {

    @InjectMocks
    UseCase useCase;

    @Mock
    IComponent iComponent;

    Logistica logistica;

    @BeforeEach
    void setUp() {
        logistica = Logistica.builder().build();
    }

    @Test
     void save() {
        when(iComponent.save(logistica)).thenReturn(logistica);
        assertNotNull(useCase.save(logistica));
    }
    @Test
     void findAll() {

        List<Logistica> listaLogistica = new ArrayList<>();
        listaLogistica.add(logistica);

        when(iComponent.findAll()).thenReturn(listaLogistica);
        assertFalse(useCase.findAll().isEmpty());
    }

}
