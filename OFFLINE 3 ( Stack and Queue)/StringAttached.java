import java.util.Scanner;
public class StringAttached {

    public static void main(String[] args) {

        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a string:");
            String s = new String(input.next());
            int l = s.length();
            // int dup = 0;
            Boolean[] count = new Boolean[26];

            Queue<Character> inputthread = new Queue<Character>();
            Queue<String> outputthread = new Queue<String>();

            StringBuffer res = new StringBuffer();
            char[] token = s.toCharArray();

            for (int i = 0; i < 26; i++) {
                count[i] = false;

            }


            inputthread.enq(token[0]);
            res.append(inputthread.peek());
            for (int i = 1; i < l; i++) {

                for (int j = 0; j < i; j++) {
                    if (token[j] == token[i])
                        count[token[i] - 'a'] = true;
                }
              //  if (!inputthread.isEmpty()) {
                    if (count[token[i] - 'a'] == false) {
                        inputthread.enq(token[i]);
                        if(!inputthread.isEmpty())
                          res.append(inputthread.peek());
                    } else if (count[token[i] - 'a'] == true) {
                        if(!inputthread.isEmpty())
                        { if (token[i] == inputthread.peek()) {
                            for (int j = 0; j < i; j++) {
                                if (count[token[j] - 'a'] == false) {
                                    res.append(token[j]);

                                    if (!inputthread.isEmpty())
                                        inputthread.deq();
                                    inputthread.enq(token[j]);
                                    break;
                                } else {
                                    //res.append('#');
                                    if (!inputthread.isEmpty())
                                        inputthread.deq();
                                }
                            }
                        } else {
                            res.append(inputthread.peek());
                        }
                    }
                }
                 if (inputthread.isEmpty()) {
                    res.append('#');
                }

            }
            outputthread.enq(res.toString());
            outputthread.display();
        }
    }
}