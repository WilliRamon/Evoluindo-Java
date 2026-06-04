package br.com.fiap.api.repository;

import br.com.fiap.api.model.Mensagem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.fail;

public class MensagemRepositoryTest {

    @Mock
    private MensagemRepository repository;

    AutoCloseable openMocks;

    @BeforeEach
    void setup(){
        openMocks = MockitoAnnotations.openMocks(this);
    }
    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void devePermitirRegistrarMensagem() {
        //Arrange
        var mensagem = Mensagem.builder().id(UUID.randomUUID())
                .usuario("Willi")
                .conteudo("Conteúdo da Mensagem")
                .build();

        Mockito.when(repository.save(mensagem)).thenReturn(mensagem);

        //Act
        var mensagemRegistrada = repository.save(mensagem);

        //Assert
        org.assertj.core.api.Assertions.assertThat(mensagemRegistrada)
                                       .isNotNull()
                                       .isEqualTo(mensagem);

        Mockito.verify(repository, Mockito.times(1)).save(mensagem);
    }

    @Test
    void devePermitirBuscarMensagem() {
        //fail("Teste não implementado");
    }

    @Test
    void devePermitirAlterarMensagem() {
        //fail("Teste não implementado");
    }

    @Test
    void devePermitirRemoverMensagem() {
        //fail("Teste não implementado");
    }
}