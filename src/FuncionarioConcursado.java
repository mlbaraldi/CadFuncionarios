public class FuncionarioConcursado extends Funcionario {

    public FuncionarioConcursado(int codigoFuncionario, float salarioBase, int tempoContrato) {
        this.codigoFuncionario = codigoFuncionario;
        this.salarioBase = salarioBase;
        this.tempoContrato = tempoContrato;
    }

    //metodo em polimorfismo de Funcionário para obter retorno específico de Concursado
    public void imprimirDados() {
        System.out.println("\n***************************");
        System.out.println("TIPO DE VÍNCULO: Concursado");
        System.out.println("TEMPO DE CONTRATO: " + this.tempoContrato + " anos");
        super.imprimirDados();
    }

    //metodo para devolver valor de salario final
    public float salarioFinal() {
        return this.salarioBase + 200 * this.tempoContrato + super.getMenor(21)*100;
    }

}

