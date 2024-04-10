package br.com.bank.payments.type;

public enum TipoRecorrencia {
    SEMANAL("Semanal"),
    MENSAL("Mensal"),
    TRIMESTRAL("Trimestral"),
    SEMESTRAL("Semestral");

    private String valorEnum;

    TipoRecorrencia(String valor){
        this.valorEnum = valor;
    }
    public String getValorEnum(){
        return valorEnum;
    }

    public static TipoRecorrencia parsear(String tipo) throws Exception {
        TipoRecorrencia tipoRecorrencia = null;
        if("Semanal".equals(tipo)){
            tipoRecorrencia = TipoRecorrencia.SEMANAL;
        }
        else if("Mensal".equals(tipo)){
            tipoRecorrencia = TipoRecorrencia.MENSAL;
        }
        else if("Trimestral".equals(tipo)){
            tipoRecorrencia = TipoRecorrencia.TRIMESTRAL;
        }
        else if("Semestral".equals(tipo)){
            tipoRecorrencia = TipoRecorrencia.SEMESTRAL;
        }
        else{
            throw new Exception("Erro ao parsear o tipo: " + tipo);
        }
        return tipoRecorrencia;
    }
}