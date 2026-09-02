package br.com.fiap.api.service;


import br.com.fiap.api.model.Mensagem;

import java.util.UUID;

public interface MensagemService {
    public Mensagem registrarMensagem(Mensagem mensage);
    public Mensagem buscarMensagem(UUID id);
    public Mensagem alterarMensagem(Mensagem mensagemAtual, Mensagem mensagemNova);
    public boolean removerMensagem(UUID id);
}
