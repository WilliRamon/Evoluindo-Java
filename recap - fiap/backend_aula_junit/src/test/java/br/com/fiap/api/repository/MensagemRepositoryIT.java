package br.com.fiap.api.repository;

import br.com.fiap.api.model.Mensagem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class MensagemRepositoryIT {

    @Autowired
    private MensagemRepository repository;

    @Test
    void devePermitirCriarTabela(){
        var totalDeRegistros = repository.count();
        assertThat(totalDeRegistros).isNotNegative();
    }

    @Test
    void devePermitirRegistrarMensagem(){
        //Arrange
        var id = UUID.randomUUID();
        var mensagem = gerarMensagem();
        mensagem.setId(id);

        //Act
        var mensagemRecebida = repository.save(mensagem);

        //Assert
        assertThat(mensagemRecebida).isInstanceOf(Mensagem.class).isNotNull();
        assertThat(mensagemRecebida.getId()).isEqualTo(id);
        assertThat(mensagemRecebida.getConteudo()).isEqualTo(mensagem.getConteudo());
        assertThat(mensagemRecebida.getUsuario()).isEqualTo(mensagem.getUsuario());
    }

    @Test
    void devePermitirBuscarMensagem(){
        //Arrange
        var id = UUID.randomUUID();
        var mensagem = gerarMensagem();
        mensagem.setId(id);
        registrarMensagem(mensagem);

        //Act
        var mensagemRecebidaOptional = repository.findById(id);

        //Assert
        assertThat(mensagemRecebidaOptional).isPresent();
        mensagemRecebidaOptional.ifPresent(mensagemRecebida -> {
            assertThat(mensagemRecebida.getId()).isEqualTo(mensagem.getId());
            assertThat(mensagemRecebida.getUsuario()).isEqualTo(mensagem.getUsuario());
            assertThat(mensagemRecebida.getConteudo()).isEqualTo(mensagem.getConteudo());
        });
    }

    @Test
    void devePermitirRemoverMensagem(){

    }

    @Test
    void devePermitirListarMensagem(){

    }
    private Mensagem gerarMensagem() {
        return Mensagem.builder()
                .usuario("Willi")
                .conteudo("Conteúdo da Mensagem")
                .build();
    }
    private Mensagem registrarMensagem(Mensagem mensagem) {
        return repository.save(mensagem);
    }
}
