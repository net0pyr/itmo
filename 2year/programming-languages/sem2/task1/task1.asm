; print_hex.asm
section .data
codes:
    db      '0123456789ABCDEF'

new_line:
    db      10

section .text
global _start

print_hex:
    mov  rax, rdi
    mov  rdi, 1
    mov  rdx, 1
    mov  rcx, 64
.loop: 
    push rax
    sub  rcx, 4
    sar  rax, cl
    and  rax, 0xf
    lea  rsi, [codes + rax]
    mov  rax, 1
    push rcx
    syscall
    pop  rcx
    pop  rax
    test rcx, rcx
    jnz .loop
    mov rax, 1
    mov rsi, new_line
    syscall
    ret



_start:
    ; number 1122... in hexadecimal format
    mov  rax, 0x1122334455667788
    mov  rdi, rax
    call print_hex

    mov  rax, 0x118ABCDEF
    mov  rdi, rax
    call print_hex

    mov  rax, 0x1ABCD21431BD88
    mov  rdi, rax
    call print_hex

    mov  rax, 60            ; invoke 'exit' system call
    xor  rdi, rdi
    syscall