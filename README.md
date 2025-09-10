# Honest Calculator

This project is an implementation of an interactive calculator that evaluates expressions, stores results in memory, and
gives humorous feedback based on how "lazy" or trivial the calculation is. The program was built step by step, each
stage adding new logic and features:

1. **Stage 1 - Data collection:**  
   Implemented the basic input flow. The program validated numbers and operators, giving error messages if the input was
   not numeric or if the operator was invalid.

2. **Stage 2 - First calculations:**  
   Added arithmetic operations (+, -, *, /) with proper type handling. Division by zero was detected and handled with a
   special error message.

3. **Stage 3 - Total recall:**  
   Introduced a memory feature. Results could be stored and reused in later calculations by typing `M`. The user was
   asked whether to save results and whether to continue calculations.

4. **Stage 4 - The laziness test:**  
   Added the `check()` function to detect "lazy" operations. For example:
    - Single-digit operands triggered " ... lazy".
    - Multiplication by 1 triggered " ... very lazy".
    - Using 0 in addition, subtraction, or multiplication triggered " ... very, very lazy".  
      These were combined into a humorous message beginning with "You are".

5. **Stage 5 - Saving memory:**  
   Enhanced memory saving logic with confirmation prompts when the result was only one digit. The user had to confirm up
   to three times before such a value was stored, preventing accidental overwriting of memory with trivial results.

## Demo

<video width="1920" height="1080" align="center" src="https://github.com/user-attachments/assets/a8a0d3de-1df4-4f81-ae67-0d7b02c23d18"></video>


## Takeaway

This project strengthened my skills in building interactive command-line applications that combine input validation,
flow control, and state persistence. I gained deeper practice in designing user-friendly prompts, handling edge cases
like division by zero, and introducing layered confirmation steps for memory management. The "laziness check" also gave
me experience in structuring conditional logic in a readable and modular way. By the end, I had developed not just a
working calculator but one that interacts with the user in a witty, dynamic, and more human-like manner.
