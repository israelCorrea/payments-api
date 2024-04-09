package br.com.bank.payments.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CpfValidateTest {

    @Test
    public void testValidCPF() {
        assertTrue(CpfValidate.isValidCPF("529.982.247-25"));
    }

    @Test
    public void testInvalidCPF_Null() {
        assertFalse(CpfValidate.isValidCPF(null));
    }

    @Test
    public void testInvalidCPF_Blank() {
        assertFalse(CpfValidate.isValidCPF(""));
    }

    @Test
    public void testInvalidCPF_WrongLength() {
        assertFalse(CpfValidate.isValidCPF("12345678901")); // CPF with length different from 11
    }

    @Test
    public void testInvalidCPF_WithLetters() {
        assertFalse(CpfValidate.isValidCPF("123.ABC.789-01")); // CPF containing letters
    }

    @Test
    public void testInvalidCPF_InvalidDigits() {
        assertFalse(CpfValidate.isValidCPF("000.000.000-00")); // CPF with all digits being the same
    }

    @Test
    public void testInvalidCPF_WrongCheckDigits() {
        assertFalse(CpfValidate.isValidCPF("529.982.247-26")); // CPF with incorrect check digits
    }
}
