package br.com.nexus.finance_manage_system.exception;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException() {
        super("Email already exists");
    }
}
