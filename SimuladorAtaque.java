public class SimuladorAtaque{
    public static void main(String[] args) {
        SistemaLogin sistema = new SistemaLogin();
        String usuario = "admin";

        String[] wordlist = {"0000", "123", "admin", "senha", "123456", "aleatorio"};

        for(String senhaTentativa : wordlist){
            System.out.println("Tentando senha: " + senhaTentativa);
            boolean sucesso = sistema.autenticarLogin(usuario, senhaTentativa);
            
            if(sucesso){
                System.out.println("Senha Descoberta: " + senhaTentativa);
                break;
            }
        }
    }
}