
package apoio.login;

public class LoginSupport {
    private String login;
    private int senha;
    
    public void isUser(){
        
        
    }
    
    public static void main(String[] args) {
        System.out.println("Andrey em MD5 é = " + CripSenha.transformaMD5("Andrey"));
        System.out.println("123456 em MD5 é = "+ CripSenha.transformaMD5("123456"));
        
    }
}
