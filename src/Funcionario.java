import java.util.ArrayList;

public abstract class Funcionario {
    public int codigoFuncionario;
    public float salarioBase;
    public int tempoContrato;
    //arraylist com dependentes associados
    public ArrayList<Dependente> Dependentes = new ArrayList<>();

    //metodo para adicionar dependentes no objeto funcionario
    public void adicionaDependente(Dependente m) {
            Dependentes.add(m);
        }


    //metodo para retornar quantidade de dependentes que contam para o bonus de acordo com a menoridade
    public int getMenor(int menoridade) {
        int adicionalDependente = 0;
        for(Dependente dependente : Dependentes) {
            if (dependente.idade <= menoridade) {
                adicionalDependente ++;
            }
        }
        return adicionalDependente;
    }


    public abstract float salarioFinal();

    ;


    public void imprimirDados() {
        System.out.println("CÓDIGO DO FUNCIONÁRIO: " + this.codigoFuncionario);
        System.out.println("SALÁRIO BASE: R$" + String.format("%.2f", this.salarioBase));
        if (Dependentes.size() > 0) {
            System.out.println("    LISTA DE DEPENDENTES:");
            int i = 1;
            for (Dependente d : Dependentes) {
                System.out.println("        Dependente" + i + " - Idade - " + d.idade);
                i++;
            }
        }
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("|SALÁRIO FINAL: R$" + String.format("%.2f", this.salarioFinal()) + " |");
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("***************************");
    }
}
