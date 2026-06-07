package br.com.fiap.api.repository;

import br.com.fiap.api.model.Mensagem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
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
        var mensagem = gerarMensagem();

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
        //Arrange
        var id = UUID.randomUUID();
        var mensagem = gerarMensagem();
        mensagem.setId(id);

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(mensagem));

        //Act
        var mensagemRecebidaOpcional = repository.findById(id);

        //Assert
        org.assertj.core.api.Assertions.assertThat(mensagemRecebidaOpcional)
                .isPresent()
                .containsSame(mensagem);
        mensagemRecebidaOpcional.ifPresent(mensagemRecebida -> {
            org.assertj.core.api.Assertions.assertThat(mensagemRecebida.getId()).isEqualTo(mensagem.getId());
            org.assertj.core.api.Assertions.assertThat(mensagemRecebida.getConteudo()).isEqualTo(mensagem.getConteudo());
        });
        Mockito.verify(repository, Mockito.times(1)).findById(id);
    }

    @Test
    void devePermitirRemoverMensagem() {
        //fail("Teste não implementado");
    }

    private Mensagem gerarMensagem() {
        return Mensagem.builder()
                .usuario("Willi")
                .conteudo("Conteúdo da Mensagem")
                .build();
    }
}