import java.util.HashMap;
import java.util.Map;

public class SistemaLogin{
    private final Map<String, String> usuarios = new HashMap<>();
    private int tentativas = 0;
    private long ultimoAcesso = 0;
    private boolean bloqueado = false;

    public SistemaLogin(){
        usuarios.put("admin", "123456");
    }

    public boolean autenticarLogin(String usuario, String senha){
        if(bloqueado){
            System.out.println("Conta bloqueada. Tente mais tarde.");
            return false;
        }

        long agora = System.currentTimeMillis();

        if(usuarios.containsKey(usuario) && usuarios.get(usuario).equals(senha)){
            tentativas = 0;
            System.out.println("Login bem-sucedido!");
            return true;

        }else{
            tentativas++;
            System.out.println("Credenciais inválidas (" + tentativas + " tentativa)");

            if(tentativas >= 5){
                bloqueado = true;
                System.out.println("Muitas tentativas erradas. Conta bloqueada por segurança.");

            }else{
                int delay = tentativas * 1000;
                System.out.println("Aguardando " + delay / 1000 + "s antes da próxima tentativa...");
                try{
                    Thread.sleep(delay);

                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }

            return false;
        }
    }
}