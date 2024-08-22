section .data
	; load a, b, c values into memory
	a dd 5.0 
	b dd 6.0
	c dd 1.0
	four dd 4.0
	two dd 2.0
	result1 dd 0.0
	result2 dd 0.0

global _start

section .text

_main:	
	; load a and c from memory
	MOVSS xmm0, [a]
	MOVSS xmm1, [c]

	; calculate ac and store in xmm0
	MULSS xmm0, xmm1 

	; caluclate 4ac and store in xmm0
	MOVSS xmm1, [four]
	MULSS xmm0, xmm1 

	; move 4ac to xmm1
	MOVSS xmm1, xmm0

	; calculate b^2 and store in xmm0
	MOVSS xmm0, [b]
	MULSS xmm0, xmm0

	; calculate b^2 - 4ac and store in xmm0
	SUBSS xmm0, xmm1

	; calculate sqrt(b^2 - 4ac) and store in result1 (memory)
	SQRTSS xmm0, xmm0
	MOVSS [result1], xmm0  

	; calculate -b and store in xmm1
	XORPS xmm1,xmm1
	MOVSS xmm0, [b]
	SUBSS xmm1, xmm0
	
	; load tmp from memory into xmm0
	MOVSS xmm0, [result1]

	; calculate -b + sqrt(b^2 - 4ac) and store in result1 (memory)
	ADDSS xmm1, xmm0
	MOVSS [result1], xmm1

	; calculate -b and store in xmm1 (again...)
	XORPS xmm1, xmm1
	MOVSS xmm0, [b]
	SUBSS xmm1, xmm0

	; calculate -b - sqrt(b^2 - 4ac) and store in result2 (memory)
	SUBSS xmm1, xmm0
	MOVSS [result2], xmm1
	
	; calculate 2a and store in xmm0
	MOVSS xmm0, [two]
	MOVSS xmm1, [a]
	MULSS xmm0, xmm1

	; calculate (-b + sqrt(b^2 - 4ac))/2a and store in result1 (memory)
	MOVSS xmm1, [result1]
	DIVSS xmm1, xmm0
	MOVSS [result1], xmm1

	; calculate (-b + sqrt(b^2 - 4ac))/2a and store in result2 (memory)
	MOVSS xmm1, [result2]
	DIVSS xmm1, xmm0
	MOVSS [result2], xmm1

	; exit the program 
	mov eax, 1            
	mov ebx, 0            
	int 80h   


	

	
		

