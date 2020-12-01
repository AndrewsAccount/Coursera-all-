import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
	Bracket(char type, int position) {
		this.type = type;
		this.position = position;
	}

	boolean Match(char c) {
		if (this.type == '[' && c == ']')
			return true;
		if (this.type == '{' && c == '}')
			return true;
		if (this.type == '(' && c == ')')
			return true;
		return false;
	}

	char type;
	int position;
}

class check_brackets {
	public static void main(String[] args) throws IOException {
		InputStreamReader input_stream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input_stream);
		String text = reader.readLine();
		Bracket open;
		int temp = -1;
		Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
		for (int position = 0; position < text.length(); ++position) {
			char next = text.charAt(position);

			if (next == '(' || next == '[' || next == '{') {
				// Process opening bracket, write your code here
				open = new Bracket(next, position);
				opening_brackets_stack.push(open);

			}
			if (next == ')' || next == ']' || next == '}') {
				// Process closing bracket, write your code here
				if (opening_brackets_stack.empty() || !opening_brackets_stack.peek().Match(next)){
					temp = position + 1;					
					break;
				}				
				opening_brackets_stack.pop();				
			}
		}
		// Printing answer, write your code here
		if (opening_brackets_stack.empty() && temp == -1)
			System.out.println("Success");
		else if (temp == -1)
			System.out.println(opening_brackets_stack.peek().position +1);
		else
			System.out.println(temp);
	}
}
