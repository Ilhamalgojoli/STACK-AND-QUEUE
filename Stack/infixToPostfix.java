package Stack;
/*
*
 * Apa itu infix ??
 *          infix adalah imbuhan yang kamu gabungkan di antara kata,atau di tengah kata
 *          kata lain.proses penggabungan imbuhan di tengah kata kata lain ini di sebut
 *          infixation dalama bahasa inggris.jadi bisa di asumsikan juga bahwa infix
 *          --> suatu bentuk ekspresi matematika yang di mana operator nya di tempatkan
 *          di tengah tengah 2 operand.
 *          jadi infix bisa di bilang bentuk matematika yang bisa dan dapat di logikan
 *          oleh manusia.
 * lalu apa itu postfix ?
 *          postfixt adalah ekspresi yang terdiri dari operand di tempatkan sebelum operator,
 *          oleh karena itu,kita bisa mengevaluasi kan ekspresi postfix dari kiri ke kanan,dengan
 *          masing masing operator di terapkan pada operand nya seperti yang di temui.
 *
 *          1 + 2 * 3 --> 123 *+
 *
 */
import java.util.Stack ;

public class infixToPostfix{
    //untuk mengecek hirarki
    private static int hirarki(char c){
        if (c == '^'){
            return 3;
        }
        else if (c == '/' || c == '*' || c == '%'){
            return 2 ;
        }
        else if (c == '+' || c == '-'){
            return 1 ;
        }else
            return -1;
    }
    static char asosiatif(char c){
        if (c == '^'){
            return 'R';
        }return 'L';
    }
    //function untuk notasi infix konversi ke postfix
private static void infixToPostfix(String s){
    StringBuilder hasil = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    int infix = s.length();
        for(int i = 0; i < infix; i++){
            char c = s.charAt(i);
                // fungsi untuk
                if((c >= 'a' && c <= 'z')||(c >= 'A' && c <= 'Z')||(c >='0' && c <= '9')){
                    hasil.append(c);
                }
                // untuk karakter jika tanda kurung nya terbuka
                else if (c == '('){
                    stack.push(c);
                }
                // jika karakter tanda kurung nya untuk menutup
                else if (c == ')'){
                    while (!stack.isEmpty() && stack.peek() != '('){
                        hasil.append(stack.pop());
                    }
                    stack.pop();
                }
                // fungsi untuk jika operator dengan prioritas lebih tinggi atau sama dalam stack
                else {
                    while(!stack.isEmpty() &&(hirarki(s.charAt(i)) < hirarki(stack.peek()) || hirarki(s.charAt(i)) == hirarki(stack.peek())
                    && asosiatif(s.charAt(i)) == 'L')){
                        hasil.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
            while(!stack.isEmpty()){
                hasil.append(stack.pop());
            }
            System.out.println(hasil);
        }
        public static void main(String[] args){
            String call = "a+b*(c^d-e)^(f+g*h)-i";
            System.out.println("Infix : " + call);
            System.out.print("Postfix : ");infixToPostfix(call);
        }
}

    // sumber referensi dari https://www.geeksforgeeks.org/convert-infix-expression-to-postfix-expression/
    // judul artikel conversition ifnix to postfix expresion
    // nama pembuat tidak di ketahui