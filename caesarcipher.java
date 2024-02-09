import java.util.*;
class CaesarCipherProgram {
    //Encrypt Text Function
    public static void caesarEncrypt(String encryptText, int shift){
      String encryptedText = "";
      char character;
      for(int i=0; i < encryptText.length();i++) 
      {
           // Shift one character at a time
          character = encryptText.charAt(i);
          
          // if character lies between a and z 
          if(character >= 'a' && character <= 'z') 
          {
           // shift character
           character = (char) (character + shift);
           // if shift character greater than 'z'
           if(character > 'z') {
              // reshift to starting position 
              character = (char) (character+'a'-'z'-1);
           }
           encryptedText = encryptedText + character;
          }
          
          // if character lies between 'A'and 'Z'
          else if(character >= 'A' && character <= 'Z') {
           // shift character
           character = (char) (character + shift);    
              
           // if shift character greater than 'Z'
           if(character > 'Z') {
               //reshift to starting position 
               character = (char) (character+'A'-'Z'-1);
           }
           encryptedText = encryptedText + character;
          }
          else {
           encryptedText = encryptedText + character;   
          }
      
      }
      System.out.println(" Encrypted Text : " + encryptedText);
    }

    //Decrypt Text Function
    public static void caesarDecrypt(String decryptText, int shift){
      String decryptedText = "";
      for(int i=0; i < decryptText.length();i++)  

      {
          // Shift one character at a time
          char character = decryptText.charAt(i);
          // if character lies between a and z 
          if(character >= 'a' && character <= 'z')
          {
              // shift character
              character = (char) (character - shift);
          
              // shift character lesser than 'a'
              if(character < 'a') {
                  //reshift to starting position 
                  character = (char) (character-'a'+'z'+1);
              }
              decryptedText = decryptedText + character;
          }    
              // if character lies between A and Z
          else if(character >= 'A' && character <= 'Z')
          {
           // shift character
              character = (char) (character - shift);
              
              //shift character lesser than 'A'
              if (character < 'A') {
                  // reshift to starting position 
                  character = (char) (character-'A'+'Z'+1);
              }
              decryptedText = decryptedText + character;            
          }
          else 
          {
           decryptedText = decryptedText + character;            
          } 
      }
      System.out.println(" Decrypted Text : " + decryptedText);
    }
    public static void main(String args[]) {
        System.out.println("Enter 0 to Encrypt or 1 to Decrypt");
        Scanner scanner = new Scanner(System.in); 
        int number = scanner.nextInt();
        scanner.nextLine();
        //Call Encrypt Function
        if(number == 0){
          System.out.println(" Input the text message to encrypt: ");
          String encryptText = scanner.nextLine();
          System.out.println(" Enter the shift value : ");
          int shift = scanner.nextInt();
          CaesarCipherProgram.caesarEncrypt(encryptText, shift);
        }
        //Call Decrypt Function
        if(number ==  1){
          System.out.println(" Input the encrypted text message to decrypt: ");
          String decryptText = scanner.nextLine();
          System.out.println(" Enter the shift value : ");
          int shift = scanner.nextInt();
          CaesarCipherProgram.caesarDecrypt(decryptText, shift);
        }
    }
}