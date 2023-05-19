package Model;

/* 
* Esta classe realiza v�rios tipos de valida��o em um JTextField 
* Para usar este Document: ((AbstractDocuement) jTextField.getDocument()).setDocumentFilter(new FloatValidator()); 
*/  
import javax.swing.text.AttributeSet;  
import javax.swing.text.BadLocationException;  
  
public class ValidaTextfieldNumeros extends FixedLenghtDocument {  
    /** 
     * Determina quais caracteres especiais ser�o permitidos 
     */  
    private char[] specialCharactersAllowed;  
      
    /** 
     * Determina se qualquer caracter especial poder� ser digitado 
     */  
    private boolean allSpecialCharacterAllowed;  
      
    /**  
     * Determina se n�meros ser�o permitidos 
     */  
    private boolean intAllowed;  
      
    /** 
     * Determina se letras ser�o permitidos 
     */  
    private boolean lettersAllowed;  
      
    /** 
     * Determina se far� valida��o de ponto flutuante 
     */  
    private boolean floatValidation;  
      
    /** 
     * Verifica se j� existe ponto na string 
     */  
    private boolean point;  
      
    public ValidaTextfieldNumeros(int maxLenght, boolean intAllowed, boolean floatValidation, boolean lettersAllowed, boolean allSpecialCharacterAllowed, char ... specialCharactersAllowed) {  
        super(maxLenght);  
        this.intAllowed = intAllowed;  
        this.floatValidation = floatValidation;  
        this.lettersAllowed = lettersAllowed;  
        this.allSpecialCharacterAllowed = allSpecialCharacterAllowed;  
        this.specialCharactersAllowed = specialCharactersAllowed;          
    }  
      
    @Override  
    public void insertString(FilterBypass fb, int offset, String str, AttributeSet attr) throws BadLocationException {  
        // M�todo n�o utilizado, mas sua implementa��o � obrigat�ria  
    }  
  
    @Override  
    public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attr) throws BadLocationException {  
        char c;  
        byte n = 1;  
          
        // Se for validar ponto flutuante  
        if (floatValidation) {  
            // Caso tenha sele��o, verifica se h� ponto na sele��o, se houver, ele ser� apagado e um novo ponto pode ser digitado  
            if(length > 0)  
                for(int i=0;i<length;i++) {  
                    c = fb.getDocument().getText(offset, length).charAt(i);  
  
                    if(c == '.') {  
                        point = false;  
                        break;  
                    }  
                }  
            // Se n�o houver sele��o, verifica se h� ponto na string inteira  
            else  
                for(int i=0;i<fb.getDocument().getLength();i++) {  
                    c = fb.getDocument().getText(0, fb.getDocument().getLength()).charAt(i);  
  
                    if(c == '.') {  
                        point = true;  
                        break;  
                    } else {  
                        point = false;  
                    }  
                }  
        }  
          
        // Percorre a string  
        for (byte i=0;i<str.length();i++){  
            boolean isDigit = false;  
            boolean isLetter = false;  
              
            // Armazena o caracter  
            c = str.charAt(i);  
              
            // Se o caracter for num�rico e n�o for permitido n�meros  
            if(Character.isDigit(c) && !intAllowed) {  
                n = 0;  
                isDigit = true;    
            } else if(Character.isDigit(c))  
                isDigit = true;  
              
            // Se o caracter for letra e n�o for permitido letras  
            if((Character.getNumericValue(c) >= 10 && Character.getNumericValue(c) <= 35) && (!lettersAllowed || floatValidation)) {  
                n = 0;  
                isLetter = true;  
            } else if(Character.getNumericValue(c) >= 10 && Character.getNumericValue(c) <= 35)  
                isLetter = true;  
              
            // Verifica��o de caracteres especiais  
            if (!allSpecialCharacterAllowed && specialCharactersAllowed.length > 0 && !isLetter && !isDigit)  
                for(int k=0;k<specialCharactersAllowed.length;k++)  
                    if(c != specialCharactersAllowed[k])  
                        n = 0;  
                    else {  
                        n = 1;  
                        break;  
                    }  
            else if (allSpecialCharacterAllowed && !isLetter && !isDigit)  
                n = 1;  
            else if (!isLetter && !isDigit)  
                n = 0;  
              
            // Se estiver validando ponto flutuante  
            if (floatValidation) {              
                // Se for um ponto e j� ouver um ponto na string  
                if ((c == '.') & point)  
                    n = 0;  
                // Se for um ponto e n�o houver ponto na string  
                else if (c == '.') {  
                    n = 1;  
                    point = true;  
                }  
            }  
        }  
          
        // Se n n�o for igual a zero, todos os caracteres s�o permitidos  
        if(n != 0)  
            super.replace(fb, offset, length, str, attr);  
    }  
  
    public boolean isFloatValidation() {  
        return floatValidation;  
    }  
  
    public void setFloatValidation(boolean floatValidation) {  
        this.floatValidation = floatValidation;  
    }  
  
    public boolean isIntAllowed() {  
        return intAllowed;  
    }  
  
    public void setIntAllowed(boolean intAllowed) {  
        this.intAllowed = intAllowed;  
    }  
  
    public boolean isLettersAllowed() {  
        return lettersAllowed;  
    }  
  
    public void setLettersAllowed(boolean lettersAllowed) {  
        this.lettersAllowed = lettersAllowed;  
    }  
  
    public char[] getSpecialCharactersAllowed() {  
        return specialCharactersAllowed;  
    }  
  
    public void setSpecialCharactersAllowed(char[] specialCharactersAllowed) {  
        this.specialCharactersAllowed = specialCharactersAllowed;  
    }  
  
    public boolean isAllSpecialChacacterAllowed() {  
        return allSpecialCharacterAllowed;  
    }  
  
    public void setAllSpecialChacacterAllowed(boolean allSpecialChacacterAllowed) {  
        this.allSpecialCharacterAllowed = allSpecialChacacterAllowed;  
    }  
  
    public boolean hasPoint() {  
        return point;  
    }  
    
    public void setPoint(boolean point) {  
        this.point = point;  
    }
    
}
