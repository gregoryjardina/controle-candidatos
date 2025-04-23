import java.util.concurrent.ThreadLocalRandom;
public class ProcessoSeletivo {
    public static void main(String[] args)  {
        selecaoCandidatos();
    }

    static void selecaoCandidatos(){

        String[] candidatos = {"Felipe", "Marcia", "Paulo", "Mirela", "Dani", "Raul", "João", "Maria", "José", "Ana", "Pedro"};
        String[] selecionados = new String[5];
        
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.00;
        
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("* Relação de Candidatos e valores pretendidos *");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - -");

        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("| O candidato " + candidato + " almeja: __R$ " + String.format("%.2f", salarioPretendido));
            
            if(salarioBase >= salarioPretendido){
                System.out.println("Candidato " + candidato + " selecionado.");
                selecionados[candidatosSelecionados]  = candidato;
                candidatosSelecionados++;
            }//Mais prático ja fazer a separação e filtro dos selecionados durante separação dos sálarios!
            candidatosAtual++;
    
        }

        System.out.println("- - - - - - - - - - - - - - - - - - - -");
        System.out.println("*  Relação de selecionados  *");
        System.out.println("- - - - - - - - - - - - - - - - - - - -");

        for(int i = 0; i < selecionados.length; i++){
            if(selecionados[i] != null){ 
            System.out.println("Candidato selecionado: " + selecionados[i]);
            }
        }
        
        System.out.println("- - - - - - - - - - - - - - - - - - - -");
        System.out.println("*  Ligação aos Candidatos  *");
        System.out.println("- - - - - - - - - - - - - - - - - - - -");

        for (int i = 0; i < selecionados.length; i++) {
            String candidato = selecionados[i];
            if (candidato == null) continue;

            boolean atendeu = false;
            int tentativasRealizadas = 0;

         do { 
            atendeu = atendeu();
            tentativasRealizadas++;

            if (!atendeu){
                System.out.println("Sem resposta de "+ candidato +"!");
            }
          }while (!atendeu && tentativasRealizadas < 3);
        
        if(atendeu){
            System.out.println("Conseguimos contato com: " +  candidato + "!");
            continue;
        }else{
            System.out.println("Candidato não atendeu, encerrando processo com: " +  candidato + "!");
        }
    }
    
    }

    static boolean atendeu() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
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
