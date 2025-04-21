public class ProcessoSeletivo {
    public static void main(String[] args)  {
        System.out.println("Processo Seletivo");
    }
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.00;
        if (salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato.");
        }else if (salarioBase == salarioPretendido){
            System.out.println("Aguardando demais candidatos.");
        }else{
            System.out.println("Ligar para o candidato com contrarpoposta!");
        }
    }
}
