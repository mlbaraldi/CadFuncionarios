public class FuncionarioTemporario extends Funcionario {

    public FuncionarioTemporario(int codigoFuncionario, float salarioBase, int tempoContrato) {
        this.codigoFuncionario = codigoFuncionario;
        this.salarioBase = salarioBase;
        this.tempoContrato = tempoContrato;
    }

    //metodo em polimorfismo de Funcionário para obter retorno específico de Temporário
    public void imprimirDados() {
        System.out.println("\n***************************");
        System.out.println("TIPO DE VÍNCULO: Temporário");
        System.out.println("TEMPO DE CONTRATO: " + this.tempoContrato + " meses");
        super.imprimirDados();

    }
    //metodo para devolver valor de salario final
    public float salarioFinal() {
        return (this.salarioBase + 15 * this.tempoContrato) + (super.getMenor(18) * 50);
    }

}

