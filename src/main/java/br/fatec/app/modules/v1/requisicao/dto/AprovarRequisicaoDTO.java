package br.fatec.app.modules.v1.requisicao.dto;


public class AprovarRequisicaoDTO {

    private long idRequisicao;

    private long idUsuarioAtendente;


    public long getIdRequisicao() {
        return this.idRequisicao;
    }

    public void setIdRequisicao(long idRequisicao) {
        this.idRequisicao = idRequisicao;
    }

    public long getIdUsuarioAtendente() {
        return this.idUsuarioAtendente;
    }

    public void setIdUsuarioAtendente(long idUsuarioAtendente) {
        this.idUsuarioAtendente = idUsuarioAtendente;
    }

}
